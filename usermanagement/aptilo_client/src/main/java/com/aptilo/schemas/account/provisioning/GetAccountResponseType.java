/**
 * GetAccountResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aptilo.schemas.account.provisioning;

public class GetAccountResponseType  implements java.io.Serializable {
    private com.aptilo.schemas.common.ResponseDetailType result;

    private com.aptilo.schemas.common.ResponseDetailsType details;

    private com.aptilo.schemas.account.provisioning.GetAccountResponseTypeResponses responses;

    public GetAccountResponseType() {
    }

    public GetAccountResponseType(
           com.aptilo.schemas.common.ResponseDetailType result,
           com.aptilo.schemas.common.ResponseDetailsType details,
           com.aptilo.schemas.account.provisioning.GetAccountResponseTypeResponses responses) {
           this.result = result;
           this.details = details;
           this.responses = responses;
    }


    /**
     * Gets the result value for this GetAccountResponseType.
     * 
     * @return result
     */
    public com.aptilo.schemas.common.ResponseDetailType getResult() {
        return result;
    }


    /**
     * Sets the result value for this GetAccountResponseType.
     * 
     * @param result
     */
    public void setResult(com.aptilo.schemas.common.ResponseDetailType result) {
        this.result = result;
    }


    /**
     * Gets the details value for this GetAccountResponseType.
     * 
     * @return details
     */
    public com.aptilo.schemas.common.ResponseDetailsType getDetails() {
        return details;
    }


    /**
     * Sets the details value for this GetAccountResponseType.
     * 
     * @param details
     */
    public void setDetails(com.aptilo.schemas.common.ResponseDetailsType details) {
        this.details = details;
    }


    /**
     * Gets the responses value for this GetAccountResponseType.
     * 
     * @return responses
     */
    public com.aptilo.schemas.account.provisioning.GetAccountResponseTypeResponses getResponses() {
        return responses;
    }


    /**
     * Sets the responses value for this GetAccountResponseType.
     * 
     * @param responses
     */
    public void setResponses(com.aptilo.schemas.account.provisioning.GetAccountResponseTypeResponses responses) {
        this.responses = responses;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAccountResponseType)) return false;
        GetAccountResponseType other = (GetAccountResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.result==null && other.getResult()==null) || 
             (this.result!=null &&
              this.result.equals(other.getResult()))) &&
            ((this.details==null && other.getDetails()==null) || 
             (this.details!=null &&
              this.details.equals(other.getDetails()))) &&
            ((this.responses==null && other.getResponses()==null) || 
             (this.responses!=null &&
              this.responses.equals(other.getResponses())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getResult() != null) {
            _hashCode += getResult().hashCode();
        }
        if (getDetails() != null) {
            _hashCode += getDetails().hashCode();
        }
        if (getResponses() != null) {
            _hashCode += getResponses().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAccountResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "getAccountResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.aptilo.com/common", "responseDetailType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("details");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "details"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.aptilo.com/common", "responseDetailsType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responses");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "responses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", ">getAccountResponseType>responses"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
