/**
 * DeleteAccountRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aptilo.schemas.account.provisioning;

public class DeleteAccountRequestType  implements java.io.Serializable {
    private com.aptilo.schemas.account.provisioning.IdentifyAccountType[] query;

    private java.lang.String accountType;  // attribute

    public DeleteAccountRequestType() {
    }

    public DeleteAccountRequestType(
           com.aptilo.schemas.account.provisioning.IdentifyAccountType[] query,
           java.lang.String accountType) {
           this.query = query;
           this.accountType = accountType;
    }


    /**
     * Gets the query value for this DeleteAccountRequestType.
     * 
     * @return query
     */
    public com.aptilo.schemas.account.provisioning.IdentifyAccountType[] getQuery() {
        return query;
    }


    /**
     * Sets the query value for this DeleteAccountRequestType.
     * 
     * @param query
     */
    public void setQuery(com.aptilo.schemas.account.provisioning.IdentifyAccountType[] query) {
        this.query = query;
    }

    public com.aptilo.schemas.account.provisioning.IdentifyAccountType getQuery(int i) {
        return this.query[i];
    }

    public void setQuery(int i, com.aptilo.schemas.account.provisioning.IdentifyAccountType _value) {
        this.query[i] = _value;
    }


    /**
     * Gets the accountType value for this DeleteAccountRequestType.
     * 
     * @return accountType
     */
    public java.lang.String getAccountType() {
        return accountType;
    }


    /**
     * Sets the accountType value for this DeleteAccountRequestType.
     * 
     * @param accountType
     */
    public void setAccountType(java.lang.String accountType) {
        this.accountType = accountType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeleteAccountRequestType)) return false;
        DeleteAccountRequestType other = (DeleteAccountRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.query==null && other.getQuery()==null) || 
             (this.query!=null &&
              java.util.Arrays.equals(this.query, other.getQuery()))) &&
            ((this.accountType==null && other.getAccountType()==null) || 
             (this.accountType!=null &&
              this.accountType.equals(other.getAccountType())));
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
        if (getQuery() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getQuery());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getQuery(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAccountType() != null) {
            _hashCode += getAccountType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeleteAccountRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "deleteAccountRequestType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("accountType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "accountType"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("query");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "query"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "identifyAccountType"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
