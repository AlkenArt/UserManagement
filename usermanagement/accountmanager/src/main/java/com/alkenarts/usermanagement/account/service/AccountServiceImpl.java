package com.alkenarts.usermanagement.account.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkenarts.usermanagement.account.AccountService;
import com.alkenarts.usermanagement.account.GroupInfo;
import com.alkenarts.usermanagement.account.Role;
import com.alkenarts.usermanagement.account.UserInfo;
import com.alkenarts.usermanagement.account.dao.GroupRepo;
import com.alkenarts.usermanagement.account.dao.UserRepo;
import com.alkenarts.usermanagement.account.model.Group;
import com.alkenarts.usermanagement.account.model.User;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	GroupRepo groupRepo;

	private static String ACC_INVALID_DATA = "Invalid Data to create account\"}";
	private static String GRP_INVALID_DATA = "Invalid Data to create group\"}";
	private static String SUCCESS = "SUCCESS\"}";
	private static String ACC_EXISTS = "Account Already Exists\"}";
	private static String GRP_EXISTS = "Group Already Exists\"}";
	private static String CUR_USER_DEL_FAILED = "Logged in user can not be deleted\"}";
	private static String ADMIN_DEL_FAILED = "Admin user can not be deleted\"}";
	private static String ADMIN_MOD_FAILED = "Other Admin can not be modified\"}";
	private static String RESULT = "{\"result\":\"";

	@Override
	public String addUser(UserInfo userInfo) {

		String result = RESULT;

		if (null == userInfo) {
			result += ACC_INVALID_DATA;
			return result;
		}

		userInfo.setUserId(userInfo.getUserId().toLowerCase());
		User user = userRepo.findByEmail(userInfo.getUserId());
		if (user != null) {
			result += ACC_EXISTS;
			return result;
		}

		user = new User(userInfo.getUserId(), userInfo.getFirstName(), userInfo.getLastName(), userInfo.getPassword(),
				userInfo.getRole().toString(), userInfo.getGroups());
		//Date date = new Date();
		// user.setCreateDate(date);
		// user.setLastUpdateDate(date);
		userRepo.save(user);
		result += SUCCESS;
		return result;
	}

	@Override
	public UserInfo getUser(String userId, String password) {
		User user = userRepo.findByEmailAndPassword(userId, password);
		UserInfo userInfo = new UserInfo(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(),
				Role.valueOf(user.getRole()), new Date(), new Date(), user.getGroupSet());

		return userInfo;
	}

	@Override
	public Set<String> getGroups(String userId) {
		User user = userRepo.findByEmail(userId);
		return user.getGroupSet();
	}

	@Override
	public Set<GroupInfo> getAllGroups() {

		Set<GroupInfo> retVal = new HashSet<GroupInfo>();
		Iterable<Group> groups = groupRepo.findAll();
		if (null == groups) {
			return retVal;
		}
		for (Group group : groups) {
			retVal.add(new GroupInfo(group.getName(), group.getDesc()));
		}
		return retVal;
	}

	@Override
	public String deleteUser(String userId, String currentUser) {
		String result = RESULT;

		if (currentUser.equals(userId)) {
			result += CUR_USER_DEL_FAILED;
			return result;
		}
		User user = userRepo.findByEmail(userId);
		if (user.getRole().equals(Role.ADMIN)) {
			result += ADMIN_DEL_FAILED;
			return result;
		}

		userRepo.delete(user);
		result += SUCCESS;
		return result;
	}

	@Override
	public String modifyUser(UserInfo userInfo, String currentUser) {
		String result = RESULT;

		boolean checkAdmin = userInfo.getRole().equals(Role.ADMIN);
		boolean checkLoggedUser = currentUser.equals(userInfo.getUserId());

		if (checkAdmin && !checkLoggedUser) {
			result += ADMIN_MOD_FAILED;
			return result;
		}

		User user = userRepo.findByEmail(userInfo.getUserId());

		user.setGroups(userInfo.getGroups().toString());

		user.setPassword(userInfo.getPassword());
		user.setFirstName(userInfo.getFirstName());
		user.setLastName(userInfo.getLastName());
		// user.setLastUpdateDate(new Date());
		userRepo.save(user);
		result += SUCCESS;
		return result;
	}

	@Override
	public String addGroup(GroupInfo groupInfo, Set<String> users) {

		String result = RESULT;

		if (null == groupInfo) {
			result += GRP_INVALID_DATA;
			return result;
		}

		Group group = groupRepo.findByName(groupInfo.getGroupName());

		if (group != null) {
			result += GRP_EXISTS;
			return result;
		}
		group = new Group(groupInfo.getGroupName(), groupInfo.getGroupDesc());
		groupRepo.save(group);

		Set<User> userList = userRepo.findByRole(Role.ADMIN.toString());
		if (null != userList) {
			for (User user : userList) {
				addGroup(user.getEmail(), groupInfo.getGroupName());
			}
		}

		if (!users.isEmpty()) {
			for (String user : users) {
				addGroup(user, groupInfo.getGroupName());
			}
		}

		result += SUCCESS;
		return result;
	}

	@Override
	public Boolean addGroup(String userId, String groupName) {
		User user = userRepo.findByEmail(userId);
		if (user == null) {
			return false;
		}
		Set<String> groups = user.getGroupSet();
		groups.add(groupName);

		user.setGroups(groups.toString());
		userRepo.save(user);
		return true;
	}

	@Override
	public Set<UserInfo> getAllUsers() {
		Set<UserInfo> retVal = new HashSet<UserInfo>();
		Iterable<User> users = userRepo.findAll();
		if (null == users) {
			return retVal;
		}
		for (User user : users) {
			UserInfo userInfo = new UserInfo(user.getEmail(), user.getFirstName(), user.getLastName(),
					user.getPassword(), Role.valueOf(user.getRole()), new Date(), new Date(), user.getGroupSet());
			retVal.add(userInfo);
		}
		return retVal;
	}

	@Override
	public UserInfo getCurrentUser(String userName) {
		User user = userRepo.findByEmail(userName);
		UserInfo userInfo = new UserInfo(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(),
				Role.valueOf(user.getRole()), new Date(), new Date(), user.getGroupSet());
		return userInfo;
	}

	@Override
	public Set<String> getAllRoles() {

		Set<String> retVal = new HashSet<String>();
		Role[] roles = Role.values();
		for (Role role : roles) {
			retVal.add(role.toString());
		}
		return retVal;
	}

	@Override
	public void init() {
		userRepo.deleteAll();
		groupRepo.deleteAll();
		
		GroupInfo groupInfo1 = new GroupInfo("SDL", "Suddenlink realm");
		GroupInfo groupInfo2 = new GroupInfo("hospac", "Hospitality access code");
		Set<String> emptySet = new HashSet<String>();

		addGroup(groupInfo1, emptySet);
		addGroup(groupInfo2, emptySet);

		Set<String> groups = new HashSet<String>();

		groups.add(groupInfo1.getGroupName());
		groups.add(groupInfo2.getGroupName());

		UserInfo userInfo1 = new UserInfo("acadmin@arris.com", "AccessCodeAdmin", "Admin", "password", Role.ADMIN, new Date(),
				new Date(), groups);

		UserInfo userInfo2 = new UserInfo("acmanager@arris.com", "AccessCode", "Manager", "acmanager", Role.MANAGER,
				new Date(), new Date(), groups);
		
		UserInfo userInfo3 = new UserInfo("acadmin1@arris.com", "AccessCodeAdmin1", "Admin1", "password", Role.ADMIN, new Date(),
				new Date(), groups);


		addUser(userInfo1);
		addUser(userInfo2);
		addUser(userInfo3);

	}
}
