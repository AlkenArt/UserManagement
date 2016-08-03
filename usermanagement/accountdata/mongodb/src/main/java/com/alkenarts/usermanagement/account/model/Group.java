package com.alkenarts.usermanagement.account.model;

import org.springframework.data.annotation.Id;

public class Group {
	
	@Id
	private String id;
	
	private String name;
	private String desc;
	
	public Group(){}

	public Group(String id, String desc) {
		super();
		this.name = id;
		this.desc = desc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
