/**
 * SoapAccountProvisioningStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aptilo.wsdls.account.provisioning.impl;

public class SoapAccountProvisioningStub extends org.apache.axis.client.Stub implements com.aptilo.wsdls.account.provisioning.AccountProvisioning {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[4];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "getAccountRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "getAccountRequestType"), com.aptilo.schemas.account.provisioning.GetAccountRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "getAccountResponseType"));
        oper.setReturnClass(com.aptilo.schemas.account.provisioning.GetAccountResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "getAccountResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "deleteAccountRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "deleteAccountRequestType"), com.aptilo.schemas.account.provisioning.DeleteAccountRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "deleteAccountResponseType"));
        oper.setReturnClass(com.aptilo.schemas.account.provisioning.DeleteAccountResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "deleteAccountResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "createAccountRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "createAccountRequestType"), com.aptilo.schemas.account.provisioning.CreateAccountRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "createAccountResponseType"));
        oper.setReturnClass(com.aptilo.schemas.account.provisioning.CreateAccountResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "createAccountResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "updateAccountRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "updateAccountRequestType"), com.aptilo.schemas.account.provisioning.UpdateAccountRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "updateAccountResponseType"));
        oper.setReturnClass(com.aptilo.schemas.account.provisioning.UpdateAccountResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "updateAccountResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

    }

    public SoapAccountProvisioningStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public SoapAccountProvisioningStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public SoapAccountProvisioningStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.1");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", ">>getAccountResponseType>responses>response");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.GetAccountResponseTypeResponsesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", ">getAccountRequestType>queries");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.GetAccountRequestTypeQueries.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", ">getAccountResponseType>responses");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.GetAccountResponseTypeResponses.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "createAccountRequestType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.CreateAccountRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "createAccountResponseType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.CreateAccountResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "createAccountType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.CreateAccountType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "createParametersType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.CreateParametersType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "createParameterType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.CreateParameterType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "deleteAccountRequestType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.DeleteAccountRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "deleteAccountResponseType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.DeleteAccountResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "getAccountRequestType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.GetAccountRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "getAccountResponseType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.GetAccountResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "groupParametersType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.GroupParametersType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "identifyAccountType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.IdentifyAccountType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "idType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.IdType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "operationType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.OperationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "parameterType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.ParameterType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "retrieveAccountType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.RetrieveAccountType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "retrieveParametersType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.RetrieveParametersType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "updateAccountRequestType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.UpdateAccountRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "updateAccountResponseType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.UpdateAccountResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "updateAccountType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.UpdateAccountType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "updateGroupParametersType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.UpdateGroupParametersType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "updateParametersType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.UpdateParametersType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "updateParameterType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.account.provisioning.UpdateParameterType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/common", "responseDetailsType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.common.ResponseDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/common", "responseDetailType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.common.ResponseDetailType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.aptilo.com/common", "statusType");
            cachedSerQNames.add(qName);
            cls = com.aptilo.schemas.common.StatusType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.aptilo.schemas.account.provisioning.GetAccountResponseType getAccount(com.aptilo.schemas.account.provisioning.GetAccountRequestType getAccountRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getAccountRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aptilo.schemas.account.provisioning.GetAccountResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aptilo.schemas.account.provisioning.GetAccountResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.aptilo.schemas.account.provisioning.GetAccountResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aptilo.schemas.account.provisioning.DeleteAccountResponseType deleteAccount(com.aptilo.schemas.account.provisioning.DeleteAccountRequestType deleteAccountRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "deleteAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {deleteAccountRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aptilo.schemas.account.provisioning.DeleteAccountResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aptilo.schemas.account.provisioning.DeleteAccountResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.aptilo.schemas.account.provisioning.DeleteAccountResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aptilo.schemas.account.provisioning.CreateAccountResponseType createAccount(com.aptilo.schemas.account.provisioning.CreateAccountRequestType createAccountRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "createAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {createAccountRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aptilo.schemas.account.provisioning.CreateAccountResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aptilo.schemas.account.provisioning.CreateAccountResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.aptilo.schemas.account.provisioning.CreateAccountResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aptilo.schemas.account.provisioning.UpdateAccountResponseType updateAccount(com.aptilo.schemas.account.provisioning.UpdateAccountRequestType updateAccountRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "updateAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {updateAccountRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aptilo.schemas.account.provisioning.UpdateAccountResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aptilo.schemas.account.provisioning.UpdateAccountResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.aptilo.schemas.account.provisioning.UpdateAccountResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
