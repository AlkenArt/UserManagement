package com.alkenarts.usermanagement.account.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private String id;

	private String email;
	private String firstName;
	private String lastName;
	private String password;

	private boolean active;
	private String role;
	private String groups;
	private Date createDate;
	private Date lastUpdateDate;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public User() {
	}

	public User(String email, String firstName, String lastName,
			String password, String role, Set<String> groups) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;

		this.role = role;
		if (null != groups)
			this.groups = groups.toString();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	public Set<String> getGroupSet() {
		String groups = this.groups;

		groups = groups.substring(1, groups.length() - 1);
		Set<String> retVal = new HashSet<String>();
		for (String str : groups.split(",")) {
			retVal.add(str.trim());
		}
		return retVal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
