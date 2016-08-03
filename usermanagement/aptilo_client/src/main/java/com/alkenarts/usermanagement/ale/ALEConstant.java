package com.alkenarts.usermanagement.ale;

public interface ALEConstant { 
	
	String USERNAME_PARAM = "User-Name";
	String PASSWORD_PARAM = "Password";
	String GROUP_PARAM = "Group";
	String ACCOUNT_STATE_PARAM = "Account-State";
	
	String VALIDITY_TIME_PARAM = "Validity-Time";
	String VALIDITY_TIME_VALUE = null;
	
	String PAS_FIRST_NAME_PARAM = "PAS-First-Name";
	String PAS_FIRST_NAME_VALUE = null;
	
	String PAS_LAST_NAME_PARAM = "PAS-Last-Name";
	String PAS_LAST_NAME_VALUE = "voucher";
	
	String VALID_FROM_PARAM = "Valid-From";
	String VALID_UNTIL_PRAM = "Valid-Until";
	
	String PURGE_DELAY_TIME_PARAM = "Purge-Delay-Time";
	
	String PAS_ACCOUNT_LOCKED_PARAM = "PAS-Account-Locked";
	String PAS_ACCOUNT_LOCKED_VALUE = "False";
	
	String PAS_ACCOUNT_TYPE_PARAM = "PAS-Account-Type";
	String PAS_ACCOUNT_TYPE_VALUE = "credits";
	
	String PAS_ALLOW_ACCOUNT_EXTENDED_PARAM = "PAS-Allow-Extend";
	String PAS_ALLOW_ACCOUNT_EXTENDED_VALUE = "True";
	
	String PAS_ALLOW_OVERWRITE_PARAM = "PAS-Allow-Overwrite";
	String PAS_ALLOW_OVERWRITE_VALUE = "True";
	
	String CREDITS_GRP = "Credits";
	String SERVICE_PROFILES_GRP = "Service-Profiles";
	
	String CREDIT_GRP_BUCKET_PARAM = "Bucket-1";
	String CREDIT_GRP_BUCKET_VALUE = "1";
	
	String ACCOUNT_TYPE = "Aptilo-WiFi-Account-DB";
	
	String SERVER_TIMEOUT = "2000";
	
	String AC_NOT_FOUND_CODE = "404";
	String AC_NOT_FOUND_DETAIL_MSG = "Can not find any account where Group = ";
	

}
