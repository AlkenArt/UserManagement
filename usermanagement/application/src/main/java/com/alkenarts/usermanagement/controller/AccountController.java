package com.alkenarts.usermanagement.controller;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alkenarts.usermanagement.account.AccountService;
import com.alkenarts.usermanagement.account.GroupInfo;
import com.alkenarts.usermanagement.account.Role;
import com.alkenarts.usermanagement.account.UserInfo;

@RequestMapping("/api/account/")
@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	@ResponseBody
	@PreAuthorize("hasAuthority('ADMIN')")
	public Set<UserInfo> getAllUsers() {
		return accountService.getAllUsers();
	}

	@RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET)
	@ResponseBody
	public UserInfo getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		return accountService.getCurrentUser(userName);
	}

	@RequestMapping(value = "/getAllRoles", method = RequestMethod.GET)
	@ResponseBody
	@PreAuthorize("hasAuthority('ADMIN')")
	public Set<String> getAllRoles() {
		Set<String> allRoles = accountService.getAllRoles();
		return allRoles;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addUser(@RequestBody UserInfo userInfo) {
		String retVal = accountService.addUser(userInfo);
		return retVal;
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasAuthority('ADMIN')")
	public String updateUser(@RequestBody UserInfo userInfo) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String currentUser = auth.getName();
		return accountService.modifyUser(userInfo, currentUser);
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteUser(@RequestParam(value = "userId") String userId) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String currentUser = auth.getName();
		return accountService.deleteUser(userId, currentUser);
	}

	@RequestMapping(value = "/addGroup", method = RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addGroup(@RequestBody GroupInfo groupInfo,
			@RequestParam(value = "userList") Set<String> users) {
		String retVal = accountService.addGroup(groupInfo, users);
		return retVal;
	}

	@RequestMapping(value = "/getAllGroups", method = RequestMethod.GET)
	@ResponseBody
	public Set<GroupInfo> getAllGroups() {
		return accountService.getAllGroups();
	}

	@RequestMapping(value = "/getUserJSON", method = RequestMethod.GET)
	@ResponseBody
	public UserInfo getUserJSON() {

		UserInfo cust = new UserInfo("bindu_p22@yahoo.com", "Venkata",
				"Harikishan", "password", Role.MANAGER, new Date(), new Date(),
				null);

		return cust;
	}
}
