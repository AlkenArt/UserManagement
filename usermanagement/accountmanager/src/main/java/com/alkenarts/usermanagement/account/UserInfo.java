package com.alkenarts.usermanagement.account;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserInfo {

	private String userId;
	private String firstName;
	private String lastName;
	private String password;
	private Role role;

	private String createDate;
	private String lastUpdateDate;

	private Set<String> groups;

	public UserInfo() {
	}

	public UserInfo(String userId, String firstName, String lastName,
			String password, Role role, Date createDate,
			Date lastUpdateDate, Set<String> groups) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		
		this.setCreateDate(convertToString(createDate));
		this.setLastUpdateDate(convertToString(lastUpdateDate));
		this.setRole(role);
		this.groups = new HashSet<String>();
		if(null != groups && groups.size() > 0){
			for(String group : groups){
				this.addGroup(group);
			}
		}		
	}

	public String getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}	

	public Set<String> getGroups() {
		
		Set<String> retVal = new HashSet<String>();
		for(String str : groups){
			retVal.add(str);
		}
		
		return retVal;
	}

	public void addGroup(String group) {
		this.groups.add(group);
	}
	
	public void setUserId(String userId){
		this.userId = userId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	private static String convertToString(Date value) {

		String sdf = "";

		try {

			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
			return sdf;
		} catch (Exception e) {

		}
		return sdf;
	}
}
