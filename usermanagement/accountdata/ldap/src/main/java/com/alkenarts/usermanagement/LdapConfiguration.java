package com.alkenarts.usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.repository.config.EnableLdapRepositories;

import com.alkenarts.usermanagement.config.ConfigService;

@Configuration
@EnableLdapRepositories(basePackages = "com.arris.wifisolution.account.dao")
@PropertySource(value = "classpath:application.properties") 
public class LdapConfiguration {
    
    
    @Value("${ldap.url}")
    private String url;
    
    @Value("${ldap.base}")
    private String basedn;
    
    @Value("${ldap.user}")
    private String user;
    
    @Value("${ldap.password}")
	private String password;
    
    @Autowired
    ConfigService configService;

    @Bean
    public LdapContextSource contextSource () {
        LdapContextSource contextSource= new LdapContextSource();       
        
        contextSource.setUrl(url);
        contextSource.setBase(basedn);
        contextSource.setUserDn(user);
        contextSource.setPassword(password);  
        
        
        
        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate() {
        return new LdapTemplate(contextSource());        
    }
}