package com.alkenarts.usermanagement.account.dao;

import java.util.Set;

import org.springframework.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import com.alkenarts.usermanagement.account.model.User;

@Repository
public interface UserRepo extends LdapRepository<User> {	

    public User findByEmailAndPassword(String email,String password);
	public User findByEmail(String email);
	public Set<User> findByRole(String admin);
}
