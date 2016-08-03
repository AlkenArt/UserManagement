package com.alkenarts.usermanagement.ale;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Configuration
@PropertySource(value = "classpath:application.properties") 
public class ALEAccountInfo {

	private List<String> accessCodes = new ArrayList<String>();

	public void setAccessCodeList(List<String> accessCodes) {
		if (!this.accessCodes.isEmpty()) {
			this.accessCodes.clear();
		}
		for (String accessCode : accessCodes) {
			this.accessCodes.add(accessCode);
		}
	}

	public ALEAccountInfo() {
		// TODO Auto-generated constructor stub
	}

	@JsonCreator
	public ALEAccountInfo(
			@JsonProperty("accessCodes") List<String> accessCodes,
			String password, String realm, String startDate, String endDate,
			String serviceProfiles, String accountState) {
		this.accessCodes = accessCodes;
		this.password = password;
		this.realm = realm;
		this.startDate = startDate;
		this.endDate = endDate;
		this.serviceProfiles = serviceProfiles;
		this.accountState = accountState;
	}

	public List<String> getAccessCodes() {
		return accessCodes;
	}

	@Value("${ale.account.password}")
	private String password;
	
	private String realm;
	
	private String startDate;
	private String endDate;
	
	private String serviceProfiles;
	
	@Value("${ale.account.accountState}") 
	private String accountState;
	
	@Value("${ale.account.purgeDelayTime}")
	private String purgeDelayTime;
	
	@Value("${ale.account.validity}")
	private int validity;
	
	@Value("${ale.serviceURL}")
	private String serviceUrl;

	public String getServiceUrl() {
		return serviceUrl;
	}
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountState() {
		return accountState;
	}

	public void setAccountState(String accountState) {
		this.accountState = accountState;
	}

	public String getPurgeDelayTime() {
		return purgeDelayTime;
	}

	public void setPurgeDelayTime(String purgeDelayTime) {
		this.purgeDelayTime = purgeDelayTime;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRealm() {
		return realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public String getServiceProfiles() {
		return serviceProfiles;
	}

	public void setServiceProfiles(String serviceProfiles) {
		this.serviceProfiles = serviceProfiles;
	}
}