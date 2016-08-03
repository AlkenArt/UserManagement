package com.alkenarts.usermanagement.account.dao;

import org.springframework.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import com.alkenarts.usermanagement.account.model.Group;

@Repository
public interface GroupRepo extends LdapRepository<Group> {
	 Group findByName(String groupName);
}

