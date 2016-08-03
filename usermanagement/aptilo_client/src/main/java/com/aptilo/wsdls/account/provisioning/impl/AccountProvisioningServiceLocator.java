/**
 * AccountProvisioningServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aptilo.wsdls.account.provisioning.impl;

public class AccountProvisioningServiceLocator extends org.apache.axis.client.Service implements com.aptilo.wsdls.account.provisioning.impl.AccountProvisioningService {

    public AccountProvisioningServiceLocator() {
    }


    public AccountProvisioningServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AccountProvisioningServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SoapAccountProvisioning
    private java.lang.String SoapAccountProvisioning_address = "http://10.19.35.230:8443/scc/account";

    public java.lang.String getSoapAccountProvisioningAddress() {
        return SoapAccountProvisioning_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SoapAccountProvisioningWSDDServiceName = "SoapAccountProvisioning";

    public java.lang.String getSoapAccountProvisioningWSDDServiceName() {
        return SoapAccountProvisioningWSDDServiceName;
    }

    public void setSoapAccountProvisioningWSDDServiceName(java.lang.String name) {
        SoapAccountProvisioningWSDDServiceName = name;
    }

    public com.aptilo.wsdls.account.provisioning.AccountProvisioning getSoapAccountProvisioning() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SoapAccountProvisioning_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSoapAccountProvisioning(endpoint);
    }

    public com.aptilo.wsdls.account.provisioning.AccountProvisioning getSoapAccountProvisioning(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.aptilo.wsdls.account.provisioning.impl.SoapAccountProvisioningStub _stub = new com.aptilo.wsdls.account.provisioning.impl.SoapAccountProvisioningStub(portAddress, this);
            _stub.setPortName(getSoapAccountProvisioningWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSoapAccountProvisioningEndpointAddress(java.lang.String address) {
        SoapAccountProvisioning_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.aptilo.wsdls.account.provisioning.AccountProvisioning.class.isAssignableFrom(serviceEndpointInterface)) {
                com.aptilo.wsdls.account.provisioning.impl.SoapAccountProvisioningStub _stub = new com.aptilo.wsdls.account.provisioning.impl.SoapAccountProvisioningStub(new java.net.URL(SoapAccountProvisioning_address), this);
                _stub.setPortName(getSoapAccountProvisioningWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SoapAccountProvisioning".equals(inputPortName)) {
            return getSoapAccountProvisioning();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wsdls.aptilo.com/account/provisioning/impl", "accountProvisioningService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wsdls.aptilo.com/account/provisioning/impl", "SoapAccountProvisioning"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SoapAccountProvisioning".equals(portName)) {
            setSoapAccountProvisioningEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
