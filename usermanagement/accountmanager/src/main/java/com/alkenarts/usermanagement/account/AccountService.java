package com.alkenarts.usermanagement.account;

import java.util.Set;

public interface AccountService {

	Set<UserInfo> getAllUsers();

	String addUser(UserInfo user);

	String deleteUser(String userId, String currentUser);

	String modifyUser(UserInfo userInfo, String currentUser);

	UserInfo getUser(String userId, String password);

	Set<String> getGroups(String userId);

	String addGroup(GroupInfo groupInfo, Set<String> users);

	Boolean addGroup(String userId, String groupName);

	Set<GroupInfo> getAllGroups();

	UserInfo getCurrentUser(String userName);
	
	Set<String> getAllRoles();

	void init();
}
