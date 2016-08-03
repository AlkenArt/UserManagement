package com.alkenarts.usermanagement.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.alkenarts.usermanagement.account.dao.UserRepo;
import com.alkenarts.usermanagement.account.model.User;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {

		User user = repo.findByEmail(emailId);
		org.springframework.security.core.userdetails.User userdetails = new org.springframework.security.core.userdetails.User(
				user.getEmail(), user.getPassword(), true, true, true, true, getAuthorities(user));

		return userdetails;
	}

	//below code will be used in case of ldap
	/*private String getDecryptedPassword(String password) {
		
		//System.out.println("encrypted : " + password);		
		String arr[] = password.split(",");		
		StringBuilder sb = new StringBuilder();

		for (String c : arr) {
			int integer = Integer.parseInt(c);
			char cha = (char) integer;
			sb.append(Character.toString(cha));		
		}
		//System.out.println("decrypted : " + sb.toString());
		return sb.toString();
	}*/

	public List<SimpleGrantedAuthority> getAuthorities(User user) {

		List<SimpleGrantedAuthority> authList = new ArrayList<SimpleGrantedAuthority>();

		String roleStr = user.getRole().toString();
		String[] roles = roleStr.split(",");

		for (String role : roles)
			authList.add(new SimpleGrantedAuthority(role));
		return authList;
	}
}
