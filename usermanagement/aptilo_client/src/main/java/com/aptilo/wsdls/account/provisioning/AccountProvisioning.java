/**
 * AccountProvisioning.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aptilo.wsdls.account.provisioning;

public interface AccountProvisioning extends java.rmi.Remote {
    public com.aptilo.schemas.account.provisioning.GetAccountResponseType getAccount(com.aptilo.schemas.account.provisioning.GetAccountRequestType getAccountRequest) throws java.rmi.RemoteException;
    public com.aptilo.schemas.account.provisioning.DeleteAccountResponseType deleteAccount(com.aptilo.schemas.account.provisioning.DeleteAccountRequestType deleteAccountRequest) throws java.rmi.RemoteException;
    public com.aptilo.schemas.account.provisioning.CreateAccountResponseType createAccount(com.aptilo.schemas.account.provisioning.CreateAccountRequestType createAccountRequest) throws java.rmi.RemoteException;
    public com.aptilo.schemas.account.provisioning.UpdateAccountResponseType updateAccount(com.aptilo.schemas.account.provisioning.UpdateAccountRequestType updateAccountRequest) throws java.rmi.RemoteException;
}
