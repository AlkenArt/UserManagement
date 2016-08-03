package com.alkenarts.usermanagement.ale.service;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.rpc.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkenarts.usermanagement.ale.ALEAccountInfo;
import com.alkenarts.usermanagement.ale.AccessCode;
import com.alkenarts.usermanagement.ale.AleAccountService;
import com.alkenarts.usermanagement.ale.AleReadException;
import com.alkenarts.usermanagement.ale.AleWriteException;
import com.alkenarts.usermanagement.ale.client.AptiloAcctProvisionGateway;
import com.alkenarts.usermanagement.util.WiFiSolutionHelper;

@Service
public class AptiloAccountServiceImpl implements AleAccountService {

	@Autowired
	AptiloAcctProvisionGateway gateway;
	
	@Autowired
	ALEAccountInfo aleAccountInfo;

	@Override
	public ALEAccountInfo createAccessCodeSet(String realm, String duration,
			int count) throws AleWriteException {
		return createAccessCodes(realm, duration, count, null, null, null);
	}

	

	@Override
	public ALEAccountInfo createAccessCode(String accessCode, String realm,
			String duration, String startDateStr, String endDateStr)
			throws AleWriteException {

		String startDate = null;
		String endDate = null;
		try {
			startDate = WiFiSolutionHelper.convertDateFromJS(startDateStr);
			endDate = WiFiSolutionHelper.convertDateFromJS(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return createAccessCodes(realm, duration, 0, accessCode, startDate,
				endDate);
	}

	private ALEAccountInfo createAccessCodes(String realm, String duration,
			int count, String accessCode, String startDate, String endDate)
			throws AleWriteException {		

		aleAccountInfo.setRealm(realm);

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, aleAccountInfo.getValidity());

		String startDateStr = (startDate == null) ? new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())
				: startDate;

		String endDateStr = (endDate == null) ? new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss").format(calendar.getTime()) : endDate;

		aleAccountInfo.setStartDate(startDateStr);
		aleAccountInfo.setEndDate(endDateStr);
		aleAccountInfo.setServiceProfiles(duration);

		List<String> accessCodeList = null;
		if (null == accessCode) {
			accessCodeList = WiFiSolutionHelper.generateAccessCode(count);
		} else {
			accessCodeList = new ArrayList<String>();
			accessCodeList.add(accessCode);
		}
		aleAccountInfo.setAccessCodeList(accessCodeList);
		
		ALEAccountInfo jsonAccessCodes = new ALEAccountInfo(
				aleAccountInfo.getAccessCodes(),
				aleAccountInfo.getPassword(), aleAccountInfo.getRealm(),
				aleAccountInfo.getStartDate(), aleAccountInfo.getEndDate(),
				aleAccountInfo.getServiceProfiles(),
				aleAccountInfo.getAccountState());
		try {
			gateway.addAccount(aleAccountInfo);
			return jsonAccessCodes;
		} catch (RemoteException | ServiceException e) {
			// throw new AleWriteException(e.getMessage());
		}
		return jsonAccessCodes;
	}

	@Override
	public Set<AccessCode> getAllAccessCodes(Set<String> realms)
			throws AleReadException {

		Set<AccessCode> retVal = new HashSet<AccessCode>();
		if (null == realms) {
			return retVal;
		}		

		Set<AccessCode> accessCodes;
		for (String realm : realms) {
			try {
				accessCodes = gateway.getAccounts(
						aleAccountInfo.getServiceUrl(), realm);
				for (AccessCode accessCode : accessCodes) {
					retVal.add(accessCode);
				}
				accessCodes.clear();

			} catch (RemoteException | ServiceException e) {
				throw new AleReadException(e.getMessage());
			}
		}
		return retVal;
	}

}
