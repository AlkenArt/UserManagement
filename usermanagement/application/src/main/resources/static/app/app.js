var ACG = angular.module('ACG', ['ngRoute', 'ngResource','ngAnimate','ui.bootstrap','ngLoadingSpinner','directive.contextMenu','ngTagsInput',"ngSanitize", "ngCsv"]);
ACG.controller('viewController', viewController);
ACG.controller('ACGenerationCtrl', ACGenerationCtrl);
ACG.controller('AccessCodesCtrl', AccessCodesCtrl);
ACG.controller('datePickerCtrl', datePickerCtrl);
ACG.controller('adminCtrl', adminCtrl);
ACG.controller('addUserCtrl', addUserCtrl);
ACG.controller('addGroupCtrl', addGroupCtrl);
ACG.controller('editUserCtrl', editUserCtrl);
ACG.controller('deleteUserCtrl', deleteUserCtrl);

ACG.config(['$routeProvider','$locationProvider',function($routeProvider, $locationProvider) {
    $routeProvider      
    .when("/createAC", { templateUrl: "view/startACG.html", controller : "viewController"})  
    .when("/generateAC", { templateUrl: "view/generatedAC.html", controller : "viewController"})
    .when("/accessCodes", { templateUrl: "view/accessCodes.html", controller : "viewController"})
    .when("/reports", { templateUrl: "view/reports.html", controller : "viewController"})
    .when("/admin", { templateUrl: "view/adminmanagement.html", controller : "viewController"})
    .when("/help", { templateUrl: "view/help.html", controller : "viewController"})
      .otherwise( {redirectTo: '/accessCodes'});
  }]);

function viewController($scope, $location, $rootScope, $http, $route) {
	 $scope.header="view/header.html";
	 $scope.footer="view/footer.html";
	 $scope.modal="view/modal/addUserModal.html";
	 $scope.addGroup="view/modal/addGroup.html";
	 $scope.editUser="view/modal/editUser.html";
	 $scope.deleteUser="view/modal/deleteUserModal.html";
	 $rootScope.errorMessagePart = "Couldn't load the"
	 $scope.click = function(pathurl)
	 {
	 	console.log(pathurl);
	 	$location.path(pathurl);	 	
	 }
	 
	 $scope.refresh = function()
	 {
	 	$route.reload();	 	
	 }
	 
	 $scope.adminAccess = false;
	$http.get("api/account/getCurrentUser").success(
		function(data) {
			$rootScope.currentUser = data;
			if($rootScope.currentUser.role == 'ADMIN'){
				$scope.adminAccess = true;
			}
			else{
				$scope.adminAccess = false;
			}
		}).error(
		function(data, status, headers, config) {
			$scope.errorMessage = $rootScope.errorMessagePart
					+ "User role, error # " + status;
		});
	};

ACG.service('groups', function() {
	this.groups = [];
    this.addGroup = function (group) {
    	this.groups.push(group);
    }
    this.getGroups = function () {
        return this.groups;
    }
    this.setGroups = function (groups) {
    	this.groups = groups;
    }
});
	
function ACGenerationCtrl($scope, $http, $location, $rootScope, groups ){
	$scope.accessCode = '';
	$scope.count = '';
	$scope.startDate = '';
	$scope.endDate = '';
	$scope.selection = 'auto';
	$scope.ACGenError = false;
	
	$scope.changeSelect =function(){
		$scope.ACGenError = false;
	}

	$http.get("api/account/getAllGroups").success(
			function(data) {
				$rootScope.allRealms = data;
				$rootScope.realms = [];
				angular.forEach($rootScope.allRealms, function(realm){
					angular.forEach($rootScope.currentUser.groups, function(group){
						if(group==realm.groupName){
							$rootScope.realms.push(realm);
						}
					})
				})
				groups.setGroups(data);
				$scope.realm=$rootScope.realms[0].groupName;
			}).error(
			function(data, status, headers, config) {
				$scope.errorMessage = $rootScope.errorMessagePart
						+ "Realm properties, error # " + status;
			});
	
	$http.get("data/serviceProfiles.json").success(
			function(data) {
				$scope.durations = data.durationsWithServices;
				$scope.validity=$scope.durations[0].service;
			}).error(
			function(data, status, headers, config) {
				$scope.errorMessage = $rootScope.errorMessagePart
						+ "Valid durtaion properties, error # " + status;
			});
	
	$http.get('data/noOfAccessCodes.json')
	.success(
			function(data) {
				$scope.accessCodeCount = data.accessCodeCounts;
				$scope.selectedCount = $scope.accessCodeCount[0].value;
			}).error(
			function(data, status, headers, config) {
				$scope.countryCntrl = $rootScope.errorMessagePart + " "
						+ "Access Code Counts properties, error # " + status;
			});
	
	$scope.generateAccessCode = function(accessCode, startDate, endDate, realm, duration){
		$scope.accessCode=accessCode;
		$rootScope.duration=duration;
		$scope.startDate=startDate;
		$scope.endDate=endDate;
		var datecomp = (( startDate.getDate() + 1)<=endDate.getDate());
		if($scope.accessCode == ''){
			$scope.ACGenError = true;
			$scope.ACGenMsg = "Please Enter Valid Access Code"
		}
		else if(!datecomp){
			$scope.ACGenError = true;
			$scope.ACGenMsg = "Invalid Valid-From and Valid-Until Dates"
		}
		else{
			$http.post("ale/api/generateAccessCode" + "?accessCode="+$scope.accessCode+"&realm="+realm+"&duration="+$rootScope.duration+"&startDate="+$scope.startDate+"&endDate="+$scope.endDate)
	        .success(function (data) {
	            $rootScope.accessCodes = data;
		        $location.path('/generateAC');
	            })
	        .error(function (data, status, headers, config) {
	            $scope.errorMessage = "Not able to generate the access codes, error # " + status;
	        });
		}
	}
	
	$scope.generateAccessCodeSet=function(realm, duration, count){
		$rootScope.duration=duration;
		$scope.count=count;
		$http.post("ale/api/generateAccessCodeSet" + "?realm="+realm+"&duration=" +$rootScope.duration+"&count="+$scope.count)
        .success(function (data) {
            $rootScope.accessCodes = data;
            $location.path('/generateAC');
            })
        .error(function (data, status, headers, config) {
            $scope.errorMessage = "Not able to generate the access codes, error # " + status;
        });
	}
	
	$scope.accessCodesJson = [];
	if(!angular.isUndefined($rootScope.accessCodes)){
		$scope.csvHeader = ["Access Code", "Group", "Valid-From", "Valid-Until", "Duration", "Status"];
		$rootScope.accessCodes.serviceProfiles = $rootScope.accessCodes.serviceProfiles.substring(8, $rootScope.accessCodes.serviceProfiles.length);
		for(var i=0;i<$rootScope.accessCodes.accessCodes.length;i++){
			$scope.accessCodesJson.push({"accessCode":$rootScope.accessCodes.accessCodes[i], "group":$rootScope.accessCodes.realm, "validFrom":$rootScope.accessCodes.startDate, "validUntil":$rootScope.accessCodes.endDate, "duration":$rootScope.accessCodes.serviceProfiles, "status":$rootScope.accessCodes.accountState})
		}
	}
	else{
		$scope.csvHeader = ["No any access code has been generated currently"];
	}
	
	$scope.filename = "access_codes";
    $scope.getArray = $scope.accessCodesJson;
    $scope.getHeader = $scope.csvHeader;
	
	$scope.downloadPdf = function(){
		var doc = new jsPDF('1', 'pt', 'letter', true);
		doc.text(200,30,'Generated Access Codes');
		doc.cellInitialize();
		
		if(!angular.isUndefined($rootScope.accessCodes)){
			angular.forEach($scope.csvHeader, function(header){
				if(header=='Access Code'||header=='Valid-From'||header=='Valid-Until'){
					doc.cell(1, 40, 120, 20, header, 0);
				}
				else{
					doc.cell(1, 40, 90, 20, header, 0);
				}
			})
			doc.setFontSize(12);
			for(var i=0;i<$scope.accessCodesJson.length;i++){
				angular.forEach($scope.accessCodesJson[i], function(cell, key){
					if(key=='accessCode'||key=='validFrom'||key=='validUntil'){
						doc.cell(1, 40, 120, 20, cell, (i+1));
					}
					else{
						doc.cell(1, 40, 90, 20, cell, (i+1));
					}
				})
			}
		}
		else{
			doc.text(30,60, "No any access code has been generated currently");
		}
		doc.save($scope.filename+'.pdf');
	}
	
};

function AccessCodesCtrl($scope, $http, $rootScope, filterFilter, $filter ){
	$scope.sortType     = 'startDate'
	$scope.sortReverse  = false;
	$scope.searchFish='';	
	
	$http.get("api/account/getAllGroups").success(
			function(data) {
				$rootScope.allRealms = data;
				$rootScope.realms=[];
				angular.forEach($rootScope.allRealms, function(realm){
					angular.forEach($rootScope.currentUser.groups, function(group){
						if(group==realm.groupName){
							$rootScope.realms.push(realm);
						}
					})
				})
				$scope.realm='all';
			}).error(
			function(data, status, headers, config) {
				$scope.errorMessage = $rootScope.errorMessagePart
						+ "Realm properties, error # " + status;
			});
	
	$http.get("ale/api/getAllAccessCodes")
		.success(function(data) {
			$rootScope.allAccessCodes = data;
			$rootScope.filteredAccessCodes = $rootScope.allAccessCodes;
			$rootScope.filteredAccessCodes = $filter('orderBy')($rootScope.filteredAccessCodes, $scope.sortType, true);
			$scope.totalItems = $rootScope.filteredAccessCodes.length;
		}).error(function(data, status, headers, config) {
			$scope.errorMessage = $rootScope.errorMessagePart
					+ "all Access Codes properties, error # " + status;
		});
	
	$scope.filterByRealm = function(realm){
		$rootScope.filteredAccessCodes=[];
		
		if(realm=="all"){
			$rootScope.filteredAccessCodes = $rootScope.allAccessCodes;
		}
		else {
			angular.forEach($scope.allAccessCodes, function(value){
				if(value.realm==realm){
					$rootScope.filteredAccessCodes.push(value);
				}
			});
		}
		$scope.totalItems = $rootScope.filteredAccessCodes.length;
	}
		
	$scope.searchByText = function(searchText){
		$rootScope.filteredAccessCodes=[];
		$rootScope.filteredAccessCodes = filterFilter($rootScope.allAccessCodes, searchText);
		$scope.totalItems = $rootScope.filteredAccessCodes.length;
	}
		
// Sorting
	$scope.order = function (order, sortReverse) {
		$scope.sortType = order;
		$scope.sortReverse  = !$scope.sortReverse;
		$rootScope.filteredAccessCodes = $filter('orderBy')($rootScope.filteredAccessCodes, order, sortReverse);
    }
// pagination code
	  $scope.viewby = 5;
	  $scope.currentPage = 4;
	  $scope.itemsPerPage = $scope.viewby;
	  $scope.maxSize = 3; // Number of pager buttons to show

	$scope.setItemsPerPage = function(num) {
	  $scope.itemsPerPage = num;
	  $scope.currentPage = 1; // reset to first page
	}
// Context-Menu start
	  $scope.edit = function() {
	  }
	  
	  $scope.deleteAC = function() {
	  }
};

function datePickerCtrl($scope){
	$scope.dateInitiator = function() {
	    $scope.startDate = new Date();
	    $scope.endDate = new Date();
	    $scope.endDate.setDate($scope.endDate.getDate() + 1);
	  };
	  $scope.dateInitiator();

	  $scope.clear = function() {
	    $scope.startDate = null;
	    $scope.endDate = null;
	  };

	  $scope.inlineOptions = {
	    customClass: getDayClass,
	    minDate: new Date(),
	    showWeeks:true
	  };

	  $scope.dateOptions = {
	  // dateDisabled: disabled, // uncomment to disable the weekends
	    formatYear: 'yyyy',
	    maxDate: new Date(2020, 5, 22),
	    minDate: new Date(),
	    startingDay: 1
	  };

	  // Disable weekend selection
	  function disabled(data) {
	    var date = data.date,
	      mode = data.mode;
	    return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
	  }

	  $scope.setMin = function(date) {
		    $scope.inlineOptions.minDate = date;
		    $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
		  };

	  $scope.open1 = function() {
	    $scope.popup1.opened = true;
	    $scope.inlineOptions.minDate = new Date();
	    $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
	  };

	  $scope.open2 = function(startDate) {
		  $scope.popup2.opened = true;
		  $scope.endDate = new Date(startDate);
		  $scope.endDate.setDate($scope.endDate.getDate() + 1);
		  $scope.setMin($scope.endDate);
	  };
	  
	  $scope.format = 'yyyy-MM-dd HH:mm:ss';

	  $scope.popup1 = {
	    opened: false
	  };

	  $scope.popup2 = {
	    opened: false
	  };

	  function getDayClass(data) {
	    var date = data.date,
	      mode = data.mode;
	    if (mode === 'day') {
	      var dayToCheck = new Date(date).setHours(0,0,0,0);

	      for (var i = 0; i < $scope.events.length; i++) {
	        var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

	        if (dayToCheck === currentDay) {
	          return $scope.events[i].status;
	        }
	      }
	    }

	    return '';
	  }
};

      
function adminCtrl($scope, $http, $rootScope, $route, $window, groups, filterFilter, $filter){
	$http.get("api/account/getAllGroups").success(
		function(data) {
			groups.setGroups(data);
		}).error(
		function(data, status, headers, config) {
			$scope.errorMessage = $rootScope.errorMessagePart
					+ "Realm properties, error # " + status;
		});
	
	$http.get('api/account/getAllUsers')
        .success(function (data) {
			$rootScope.Users=data;
			$rootScope.filteredUser = $filter('orderBy')($rootScope.Users, "lastUpdateDate", true);
			angular.forEach($rootScope.filteredUser, function(user){
				user.editModal =false;
				user.deleteModal =false;
			});
			$scope.totalItems = $scope.Users.length;
        })
        .error(function (data, status, headers, config) {
				$scope.errorMessage = $rootScope.errorMessagePart
						+ "Admin properties, error # " + status;
		});
	
	$http.get("api/account/getAllRoles")
		.success(function(data) {
			$scope.roles = data;
			$scope.role=$scope.roles[0];
		})
		.error(function(data, status, headers, config) {
			$scope.errorMessage = $rootScope.errorMessagePart+ "Roles properties, error # " + status;
		});
	
	$scope.changeGroupSelection = function(role) {
		if(role=='ADMIN'){
			$rootScope.selectedrealms =[];
			angular.forEach(groups.getGroups(), function(group){
				$rootScope.selectedrealms.push(group);
			});
			$rootScope.remainingRealms = [];
		}
		else{
			$rootScope.remainingRealms = [];
			angular.forEach(groups.getGroups(), function(group){
				$rootScope.remainingRealms.push(group);
			})
			$rootScope.selectedrealms = [];
		}
	};
	
	$scope.showAddUserModal = false;
 	$scope.openAddUserModal = function(role){
      $scope.showAddUserModal = true;
      $scope.changeGroupSelection(role);
 	}
 	
 	$scope.closeAddUserModal = function(){
 		$scope.showAddUserModal = false;
 		$route.reload();
 	}
 	
 	$scope.showAddGroupModal = false;
 	$scope.openAddGroupModal = function(){
      $scope.showAddGroupModal = true;
 	}
 	
 	$scope.closeAddGroupModal = function(){
 		$scope.showAddGroupModal = false;
 		$route.reload();
 	}
	
	$scope.openEditModal = function(user){
		user.editModal = true;
		$rootScope.remainingEditableRealms = [];
		$rootScope.selectedEditableRealms = [];
		angular.forEach(groups.getGroups(), function(userRealm){
			var present = false;
			angular.forEach(user.groups, function(userGroup){
				if(userRealm.groupName==userGroup){
					present = true;
				}
			});
			if(present==true){
				$rootScope.selectedEditableRealms.push(userRealm);
			}
			else{
				$rootScope.remainingEditableRealms.push(userRealm);
			}
		});
	  }
	
	$scope.editPopUpClose = function(user){
		user.editModal = false;
		$route.reload();
	}
	
	$scope.openDeleteModal = function(user){
		user.deleteModal = true;
	  }
	
	$scope.deletePopUpClose = function(user){
		user.deleteModal = false;
		$route.reload();
	}
	
    // Searching
    $scope.searchKey='';
    $scope.searchUser = function(searchKey){
		$rootScope.filteredUser=[];
		$rootScope.filteredUser = filterFilter($rootScope.Users, searchKey);
		$scope.totalItems = $rootScope.filteredUser.length;
	}
    
    // Sorting
    $scope.sortType     = 'lastUpdateDate'
    $scope.sortReverse  = false;
    $scope.orderUser = function (order, sortReverse) {
		$scope.sortType = order;
		$scope.sortReverse  = !$scope.sortReverse;
		$rootScope.filteredUser = $filter('orderBy')($rootScope.filteredUser, order, sortReverse);
    }
	    
    // pagination
    $scope.viewby = 5;
    $scope.currentPage = 4;
    $scope.itemsPerPage = $scope.viewby;
	$scope.setItemsPerPage = function(num) {
		$scope.itemsPerPage = num;
		$scope.currentPage = 1;
	}
};

function addUserCtrl($scope, $rootScope, groups, $http, $route){
	$scope.addUserError = false;
	
	$scope.selectGroup = function(group) {
		$rootScope.remainingRealms.splice($rootScope.remainingRealms.indexOf(group), 1);
		$rootScope.selectedrealms.push(group);
	};
	
	$scope.removeGroup = function(group) {
		$rootScope.selectedrealms.splice($rootScope.selectedrealms.indexOf(group), 1);
		$rootScope.remainingRealms.push(group);
	};
	
 	$scope.addUser=function(email, password,firstname,lastname,role,selectedrealms){
 		$scope.realmList = [];
    	angular.forEach(selectedrealms, function(realm){
    		$scope.realmList.push(realm.groupName);
    	})
    	
    	 $('form').submit(function(){
	       var options = selectedrealms;
	       if(options== "")
	    	   {
	         	 document.getElementById("demo").innerHTML = "Select Atleast One Group";
	              return false;
	    	   }
	       else
	    	  {
		          $http.post("api/account/addUser", {"userId":email,"password":password,"role":role,"firstName":firstname,"lastName":lastname,"groups":$scope.realmList})
	              .success(function (data) {
	                  $scope.result = data.result;
	                  if($scope.result=='SUCCESS'){
	                	  $route.reload();
	                  }
	                  else{
	                	  $scope.addUserError = true;
	                  }
	                })
	              .error(function (data, status, headers, config) {
	                  $scope.errorMessage = "Not able to add user details, error # " + status;
	              	});
	    	   }
	     });
 	};
}

function addGroupCtrl($scope, $rootScope, groups, $http, $route){
	$scope.groupName = '';
	$scope.groupDesc = '';
	
    $scope.loadUserlist = function($query) {
    	$scope.managerList = [];
    	angular.forEach($rootScope.Users, function(user){
    		if(user.role!='ADMIN'){
    			$scope.managerList.push(user);
    		}
    	})
		 angular.forEach($scope.managerList, function(value){
			 value.fieldName = value.lastName+','+value.firstName;
		 })
	      return $scope.managerList.filter(function(user) {
	        return user.userId.toLowerCase().indexOf($query.toLowerCase()) != -1;
	    })
    };
    
    $scope.addGroup = function(groupName, groupDesc, groupUser){
    	$scope.addGroupError = false;
    	$scope.addGroupNot = false;
    	$scope.addGroupNotMsg = "";
    	
    	$scope.userList = [];
    	$scope.invalidUserList = [];
    	angular.forEach(groupUser, function(user){
    		angular.forEach($scope.managerList, function(manager){
    			manager.fieldName = manager.lastName+','+manager.firstName;
    			if(angular.equals(manager.fieldName, user.fieldName)){
    				$scope.userList.push(user.userId);
    			}
    			else{
    				$scope.invalidUserList.push(user.fieldName);
    			}
    		});
    	});
    	
    	angular.forEach($scope.invalidUserList, function(invalidUser){
    		$scope.addGroupNot = true;
    	})
    	
    	if(groupName!=''&&groupDesc!=''){
    		$http.post("api/account/addGroup?userList="+$scope.userList, {"groupName":groupName,"groupDesc":groupDesc})
            .success(function (data) {
                $scope.addGroupResult = data.result;
                if($scope.addGroupResult=='SUCCESS'){
                	if($scope.addGroupNot!=true){
                		$route.reload();
                	}
                }
                else{
                	$scope.addGroupError = true;
                }
                
              })
            .error(function (data, status, headers, config) {
                $scope.errorMessage = "Not able to add user details, error # " + status;
            });
    	}
    }
}

function editUserCtrl($scope, $rootScope, groups, $http, $route){
	$scope.modifyUserError = false;
	$scope.password = '';
	$scope.password1 = '';
	
	$scope.selectEditableGroup = function(group) {
		$rootScope.remainingEditableRealms.splice($rootScope.remainingEditableRealms.indexOf(group), 1);
		$rootScope.selectedEditableRealms.push(group);
	};
	
	$scope.removeEditableGroup = function(group) {
		$rootScope.selectedEditableRealms.splice($rootScope.selectedEditableRealms.indexOf(group), 1);
		$rootScope.remainingEditableRealms.push(group);
	};
	
	$scope.updateUser = function(user, password, password1, selectedEditableRealms){
		$scope.updateError = false;
    	 $scope.updateErrorMsg = "";
		
		$scope.updatedRealmList = [];
    	angular.forEach(selectedEditableRealms, function(realm){
    		$scope.updatedRealmList.push(realm.groupName);
    	})
    
    	if(password==""&&password1==""){
    		$scope.password = user.password;
    		$scope.password1 = user.password;
    	}
    	
    if(password!=password1){
	    	$scope.updateError = true;
	   		$scope.updateErrorMsg = "Password update failed due to mismatch";
    	}
    else if(selectedEditableRealms<=0)
	   {
	   		$scope.updateError = true;
	   		$scope.updateErrorMsg = "Select Atleast One Group";
	   }
   else
	  {
	$http.post("api/account/updateUser", {"userId":user.userId,"password":$scope.password,"firstName":user.firstName,"lastName":user.lastName,"role":user.role,"groups":$scope.updatedRealmList})
    .success(function (data) {
        $scope.modifyUserResult = data.result;
        if($scope.modifyUserResult=="SUCCESS"){
      	  $scope.editPopUpClose(user);
        }
        else{
      	  $scope.modifyUserError = true;
        }
      })
    .error(function (data, status, headers, config) {
        $scope.errorMessage = "Not able to add user details, error # " + status;
    	});
	  }
	};
}

function deleteUserCtrl($scope, $http, $route){
	$scope.deleteUserError = false;
	
	$scope.deleteUser = function(user){
		user.deleteModal = true;
		
    	$http.post("api/account/deleteUser?userId="+user.userId)
	    	.success(function (data) {
	    		$scope.deleteUserResult = data.result;
	    		if($scope.deleteUserResult=='SUCCESS'){
	    			$scope.deletePopUpClose(user);
	    		}else{
	    			$scope.deleteUserError = true;
	    		}
	         })
	        .error(function (data, status, headers, config) {
	        	$scope.errorMessage = "Not able to delete user details, error # " + status;
	        });
    };	
}

ACG.directive('modal', function () {
	   return {
			template: '<div class="modal fade">' + 
	    '<div class="modal-dialog">' + 
	     '<div class="modal-content" style="width:75%;margin:auto;">' + 
	        '<div class="modal-body" ng-transclude></div>' + 
	      '</div>' + 
	    '</div>' + 
	  '</div>',
	  restrict: 'E',
	  transclude: true,
	 replace:true,
	animation: 'true',
	  scope:true,
	  link: function postLink(scope, element, attrs) {
		    scope.title = attrs.title;
		    scope.$watch(attrs.visible, function(value){
		     if(value == true)
		        $(element).modal('show');
		      else
		      $(element).modal('hide');
		    });
		
		    $(element).on('shown.bs.modal', function(){
		     scope.$apply(function(){
		        scope.$parent[attrs.visible] = true;
		      });
		   });
		
		    $(element).on('hidden.bs.modal', function(){
	          scope.$apply(function(){
	            scope.$parent[attrs.visible] = false;
	          });
		   });
	  }
	};
});
