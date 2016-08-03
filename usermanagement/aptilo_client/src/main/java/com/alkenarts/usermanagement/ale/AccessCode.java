package com.alkenarts.usermanagement.ale;

public class AccessCode {
	

	private String accessCode;
	
	private String realm;
	private String startDate;
	private String endDate;
	private String serviceProfile;
	private String accountState;
	
	public AccessCode(){
		
	}
	
	public AccessCode(ALEAccountInfo accInfo, int index) {
		super();
		this.setAccessCode(accInfo.getAccessCodes().get(index));		
		this.setStartDate(accInfo.getStartDate());
		this.setEndDate(accInfo.getEndDate());
		this.setRealm(accInfo.getRealm());
		this.setServiceProfile(accInfo.getServiceProfiles());
		this.setAccountState(accInfo.getAccountState());
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
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

	public String getAccountState() {
		return accountState;
	}

	public void setAccountState(String accountState) {
		this.accountState = accountState;
	}

	public String getServiceProfile() {
		return serviceProfile;
	}

	public void setServiceProfile(String serviceProfile) {
		this.serviceProfile = serviceProfile;
	}

}
