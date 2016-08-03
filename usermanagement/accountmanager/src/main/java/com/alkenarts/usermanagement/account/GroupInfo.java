package com.alkenarts.usermanagement.account;

public class GroupInfo {
	
	private String groupName;
	private String groupDesc;
	
	public GroupInfo(){}
	
	public GroupInfo(String groupName, String groupDesc) {
		super();
		this.groupName = groupName;
		this.groupDesc = groupDesc;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDesc() {
		return groupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	
	
	
	

}
