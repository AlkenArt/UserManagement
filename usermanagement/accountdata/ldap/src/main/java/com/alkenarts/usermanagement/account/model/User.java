/*
 * Copyright 2005-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alkenarts.usermanagement.account.model;

import java.util.HashSet;
import java.util.Set;

import javax.naming.Name;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

/**
 * Simple class representing a single person.
 *
 * @author Mattias Hellborg Arthursson
 * @author Ulrik Sandberg
 */
@Entry(objectClasses = { "inetOrgPerson", "organizationalPerson", "person", "top" })
public class User {
	@Id
	private Name id;

	@Attribute(name = "mail")
	@DnAttribute(value = "mail", index = 0)
	private String email;

	@Attribute(name = "cn")
	private String firstName;

	@Attribute(name = "sn")
	private String lastName;

	@Attribute(name = "employeeType")
	private String role;

	
	@Attribute(name = "userPassword")
	private String password;

	@Attribute(name = "o")
	private String groups;
	
	public User(){}

	public User(String userId, String firstName2, String lastName2, String password2, String role,
			Set<String> groups2) {
		this.email = userId;
		this.firstName = firstName2;
		this.lastName = lastName2;
		this.password = password2;
		this.role = role;
		this.groups = groups2.toString();
	}

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public Name getId() {
		return id;
	}

	public void setId(Name id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public Set<String> getGroupSet(){	
		
		String groups = this.groups;	
		
		
		groups = groups.substring(1, groups.length() - 1);
		Set<String> retVal = new HashSet<String>();
		for(String str : groups.split(",")){
			retVal.add(str.trim());
		}
		return retVal;
	}
	
	
	
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
