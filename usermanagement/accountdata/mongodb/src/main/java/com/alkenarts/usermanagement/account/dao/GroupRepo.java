package com.alkenarts.usermanagement.account.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alkenarts.usermanagement.account.model.Group;

public interface GroupRepo extends MongoRepository<Group, String> { 

	public Group findByName(String name);  

}

