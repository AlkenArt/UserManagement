package com.alkenarts.usermanagement.config.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alkenarts.usermanagement.config.ConfigService;

@Service
public class ConfigServiceImpl implements ConfigService {
	
	
	
	
	Map<String,String> context = new HashMap<String,String>();
	
	public ConfigServiceImpl(){
		context.put("ldap.url","ldap://10.232.64.136:389");
		context.put("ldap.base", "dc=example,dc=com");
		context.put("ldap.user", "cn=admin,dc=example,dc=com");
		context.put("ldap.password", "password");		
	}

	@Override
	public String getProperty(String paramName) { 
		return context.get(paramName);
	}

}
