package com.alkenarts.usermanagement.ale;

import java.util.Set;

public interface AleAccountService {

	ALEAccountInfo createAccessCodeSet(String realm, String duration, int count) throws AleWriteException;

	ALEAccountInfo createAccessCode(String accessCode, String realm, String duration, String startDate, String endDate)
			throws AleWriteException;

	Set<AccessCode> getAllAccessCodes(Set<String> realms) throws AleReadException;
}