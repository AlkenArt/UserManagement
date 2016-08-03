/*
 * Copyright 2015 ARRIS Enterprises, Inc. All rights reserved.
 * 
 * This program is confidential and proprietary to ARRIS Enterprises, Inc.
 * (ARRIS), and may not be copied, reproduced, modified, disclosed to others,
 * published or used, in whole or in part, without the express prior written
 * permission of ARRIS.
 *
 */
package com.alkenarts.usermanagement.ale.client;

import static com.alkenarts.usermanagement.util.WiFiSolutionHelper.convertToString;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.springframework.stereotype.Component;

import com.alkenarts.usermanagement.ale.ALEAccountInfo;
import com.alkenarts.usermanagement.ale.ALEConstant;
import com.alkenarts.usermanagement.ale.AccessCode;
import com.alkenarts.usermanagement.ale.AleReadException;
import com.alkenarts.usermanagement.ale.AleWriteException;
import com.aptilo.schemas.account.provisioning.CreateAccountRequestType;
import com.aptilo.schemas.account.provisioning.CreateAccountResponseType;
import com.aptilo.schemas.account.provisioning.CreateAccountType;
import com.aptilo.schemas.account.provisioning.CreateParameterType;
import com.aptilo.schemas.account.provisioning.CreateParametersType;
import com.aptilo.schemas.account.provisioning.GetAccountRequestType;
import com.aptilo.schemas.account.provisioning.GetAccountRequestTypeQueries;
import com.aptilo.schemas.account.provisioning.GetAccountResponseType;
import com.aptilo.schemas.account.provisioning.GetAccountResponseTypeResponses;
import com.aptilo.schemas.account.provisioning.GetAccountResponseTypeResponsesResponse;
import com.aptilo.schemas.account.provisioning.GroupParametersType;
import com.aptilo.schemas.account.provisioning.IdType;
import com.aptilo.schemas.account.provisioning.ParameterType;
import com.aptilo.schemas.account.provisioning.RetrieveAccountType;
import com.aptilo.schemas.account.provisioning.RetrieveParametersType;
import com.aptilo.schemas.common.ResponseDetailType;
import com.aptilo.schemas.common.StatusType;
import com.aptilo.wsdls.account.provisioning.impl.AccountProvisioningServiceLocator;
import com.aptilo.wsdls.account.provisioning.impl.SoapAccountProvisioningStub;

@Component
public class AptiloAcctProvisionGateway implements ALEConstant {

	/**
	 * This method is used to create ServiceLocator
	 * 
	 * @param baseUrl
	 * @param timeOutInSeconds
	 * @return Envivio4CasterServiceStub
	 * @throws ServiceException
	 * @throws AxisFault
	 */
	private SoapAccountProvisioningStub getaccountProvisioningStub(
			String baseUrl, String timeOutInSeconds) throws ServiceException,
			AxisFault {

		int timeout = Integer.parseInt(timeOutInSeconds) * 1000;

		SoapAccountProvisioningStub stub = new SoapAccountProvisioningStub();

		AccountProvisioningServiceLocator srvcLocator = new AccountProvisioningServiceLocator();
		srvcLocator.setSoapAccountProvisioningEndpointAddress(baseUrl);
		stub = ((SoapAccountProvisioningStub) srvcLocator
				.getSoapAccountProvisioning());
		stub.setTimeout(timeout);
		return stub;
	}

	public boolean addAccount(ALEAccountInfo accInfo) throws ServiceException,
			RemoteException, AleWriteException {

		SoapAccountProvisioningStub stub = getaccountProvisioningStub(
				accInfo.getServiceUrl(), SERVER_TIMEOUT);

		CreateAccountRequestType createAccountRequest = new CreateAccountRequestType();

		CreateAccountType[] accounts = new CreateAccountType[accInfo
				.getAccessCodes().size()];

		for (int index = 0; index < accInfo.getAccessCodes().size(); index++) {
			// Create Account
			CreateAccountType account = new CreateAccountType();
			CreateParametersType parameters = new CreateParametersType();
			CreateParameterType[] parameterArr = new CreateParameterType[14];

			for (int index2 = 0; index2 < 14; index2++) {
				parameterArr[index2] = new CreateParameterType();
			}

			parameterArr[0].setName(USERNAME_PARAM);
			parameterArr[0].setValue(accInfo.getRealm() + "/"
					+ accInfo.getAccessCodes().get(index));

			parameterArr[1].setName(PASSWORD_PARAM);
			parameterArr[1].setValue(accInfo.getPassword());

			parameterArr[2].setName(GROUP_PARAM);
			parameterArr[2].setValue(accInfo.getRealm());

			parameterArr[3].setName(ACCOUNT_STATE_PARAM);
			parameterArr[3].setValue(accInfo.getAccountState());

			parameterArr[4].setName(VALIDITY_TIME_PARAM);
			parameterArr[4].setValue(VALIDITY_TIME_VALUE);

			parameterArr[5].setName(PAS_FIRST_NAME_PARAM);
			parameterArr[5].setValue(PAS_FIRST_NAME_VALUE);

			parameterArr[6].setName(PAS_LAST_NAME_PARAM);
			parameterArr[6].setValue(PAS_LAST_NAME_VALUE);

			parameterArr[7].setName(VALID_FROM_PARAM);
			parameterArr[7].setValue(accInfo.getStartDate());

			parameterArr[8].setName(VALID_UNTIL_PRAM);
			parameterArr[8].setValue(accInfo.getEndDate());

			parameterArr[9].setName(PURGE_DELAY_TIME_PARAM);
			parameterArr[9].setValue(accInfo.getPurgeDelayTime());

			parameterArr[10].setName(PAS_ACCOUNT_LOCKED_PARAM);
			parameterArr[10].setValue(PAS_ACCOUNT_LOCKED_VALUE);

			parameterArr[11].setName(PAS_ACCOUNT_TYPE_PARAM);
			parameterArr[11].setValue(PAS_ACCOUNT_TYPE_VALUE);

			parameterArr[12].setName(PAS_ALLOW_ACCOUNT_EXTENDED_PARAM);
			parameterArr[12].setValue(PAS_ALLOW_ACCOUNT_EXTENDED_VALUE);

			parameterArr[13].setName(PAS_ALLOW_OVERWRITE_PARAM);
			parameterArr[13].setValue(PAS_ALLOW_OVERWRITE_VALUE);

			GroupParametersType[] group = new GroupParametersType[2];

			group[0] = new GroupParametersType();
			group[1] = new GroupParametersType();

			group[0].setName(CREDITS_GRP);
			group[1].setName(SERVICE_PROFILES_GRP);

			ParameterType[] creditParam = new ParameterType[1];
			creditParam[0] = new ParameterType();
			creditParam[0].setName(CREDIT_GRP_BUCKET_PARAM);
			creditParam[0].setValue(CREDIT_GRP_BUCKET_VALUE);

			ParameterType[] SPParam = new ParameterType[1];
			SPParam[0] = new ParameterType();
			SPParam[0].setName(accInfo.getServiceProfiles());
			SPParam[0].setValue("true");

			group[0].setParameter(creditParam);
			group[1].setParameter(SPParam);

			parameters.setParameter(parameterArr);
			parameters.setGroup(group);

			account.setParameters(parameters);
			account.setReference("Create" + "-" + index);
			accounts[index] = new CreateAccountType();
			accounts[index] = account;
		}
		createAccountRequest.setAccount(accounts);
		createAccountRequest.setAccountType(ACCOUNT_TYPE);
		CreateAccountResponseType response = stub
				.createAccount(createAccountRequest);

		if (response.getResult().getStatus() != StatusType.success) {
			throw new AleWriteException("Could not create accounts");
		}

		return true;
	}

	public Set<AccessCode> getAccounts(String serviceURL, String realm)
			throws AleReadException, AxisFault, ServiceException {

		SoapAccountProvisioningStub stub = getaccountProvisioningStub(
				serviceURL, SERVER_TIMEOUT);

		GetAccountRequestType request = new GetAccountRequestType();
		GetAccountRequestTypeQueries queries = new GetAccountRequestTypeQueries();
		RetrieveAccountType[] queryArr = new RetrieveAccountType[1];
		RetrieveParametersType parameters = new RetrieveParametersType();

		ParameterType parameter = new ParameterType();
		parameter.setName(GROUP_PARAM);
		parameter.setValue(realm);
		
		ParameterType parameter1 = new ParameterType();
		parameter1.setName(PAS_LAST_NAME_PARAM);
		parameter1.setValue(PAS_LAST_NAME_VALUE);

		queryArr[0] = new RetrieveAccountType();
		IdType id = new IdType();
		id.setParameter(parameter);
		parameters.setParameter(parameter1);
		queryArr[0].setId(id);
		queryArr[0].setParameters(parameters);
		queries.setQuery(queryArr);
		request.setAccountType(ACCOUNT_TYPE);

		request.setQueries(queries);

		GetAccountResponseType response = null;
		try {
			response = stub.getAccount(request);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<AccessCode> retVal = new HashSet<AccessCode>();

		StatusType status = response.getResult().getStatus();
		if (status != StatusType.success) {
			ResponseDetailType[] details = response.getDetails().getDetail();

			for (ResponseDetailType detail : details) {
				String code = detail.getCode();
				String detailMessage = detail.getMessage();
				String expMssage = AC_NOT_FOUND_DETAIL_MSG + realm;
				if (AC_NOT_FOUND_CODE.equals(code)
						&& expMssage.equals(detailMessage)) {
					return retVal;
				}
			}
			throw new AleReadException(response.getResult().getMessage());
		}

		GetAccountResponseTypeResponses getAccResponse = response
				.getResponses();
		GetAccountResponseTypeResponsesResponse[] responseArr = getAccResponse
				.getResponse();


		for (GetAccountResponseTypeResponsesResponse resp : responseArr) {

			ParameterType[] params = resp.getParameter();
			AccessCode accessCode = new AccessCode();
			accessCode.setRealm(realm);
			for (ParameterType param : params) {

				switch (param.getName()) {
				case USERNAME_PARAM:
					String[] arr = param.getValue().split("/");

					String username = (arr.length <= 1) ? "" : arr[1];
					accessCode.setAccessCode(username);
					break;
				case VALID_FROM_PARAM:
					accessCode.setStartDate(convertToString(param.getValue()));
					break;
				case VALID_UNTIL_PRAM:
					accessCode.setEndDate(convertToString(param.getValue()));
					break;
				case ACCOUNT_STATE_PARAM:
					accessCode.setAccountState(param.getValue());
					break;
				}
			}
			GroupParametersType[] groups = resp.getGroup();
			List<String> serviceProfile = new ArrayList<String>();
			for (GroupParametersType group : groups) {
				switch (group.getName()) {
				case SERVICE_PROFILES_GRP:
					ParameterType[] groupParams = group.getParameter();
					for ( ParameterType param : groupParams) {
						if(!param.getName().contains("Session-")){
							continue;
						}
						serviceProfile.add(param.getName());
					}
					String[] servProfile = serviceProfile.toString().split("Session-");
					if(servProfile.length<=2){
						accessCode.setServiceProfile(servProfile[1].substring(0, servProfile[1].length()-1));
					}
					break;
				}
			}
			retVal.add(accessCode);
		}
		return retVal;
	}
}
