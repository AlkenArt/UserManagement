/**
 * RetrieveAccountType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aptilo.schemas.account.provisioning;

public class RetrieveAccountType  implements java.io.Serializable {
    private com.aptilo.schemas.account.provisioning.IdType id;

    private com.aptilo.schemas.account.provisioning.RetrieveParametersType parameters;

    private java.lang.String reference;  // attribute

    private java.lang.String limit;  // attribute

    public RetrieveAccountType() {
    }

    public RetrieveAccountType(
           com.aptilo.schemas.account.provisioning.IdType id,
           com.aptilo.schemas.account.provisioning.RetrieveParametersType parameters,
           java.lang.String reference,
           java.lang.String limit) {
           this.id = id;
           this.parameters = parameters;
           this.reference = reference;
           this.limit = limit;
    }


    /**
     * Gets the id value for this RetrieveAccountType.
     * 
     * @return id
     */
    public com.aptilo.schemas.account.provisioning.IdType getId() {
        return id;
    }


    /**
     * Sets the id value for this RetrieveAccountType.
     * 
     * @param id
     */
    public void setId(com.aptilo.schemas.account.provisioning.IdType id) {
        this.id = id;
    }


    /**
     * Gets the parameters value for this RetrieveAccountType.
     * 
     * @return parameters
     */
    public com.aptilo.schemas.account.provisioning.RetrieveParametersType getParameters() {
        return parameters;
    }


    /**
     * Sets the parameters value for this RetrieveAccountType.
     * 
     * @param parameters
     */
    public void setParameters(com.aptilo.schemas.account.provisioning.RetrieveParametersType parameters) {
        this.parameters = parameters;
    }


    /**
     * Gets the reference value for this RetrieveAccountType.
     * 
     * @return reference
     */
    public java.lang.String getReference() {
        return reference;
    }


    /**
     * Sets the reference value for this RetrieveAccountType.
     * 
     * @param reference
     */
    public void setReference(java.lang.String reference) {
        this.reference = reference;
    }


    /**
     * Gets the limit value for this RetrieveAccountType.
     * 
     * @return limit
     */
    public java.lang.String getLimit() {
        return limit;
    }


    /**
     * Sets the limit value for this RetrieveAccountType.
     * 
     * @param limit
     */
    public void setLimit(java.lang.String limit) {
        this.limit = limit;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RetrieveAccountType)) return false;
        RetrieveAccountType other = (RetrieveAccountType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.parameters==null && other.getParameters()==null) || 
             (this.parameters!=null &&
              this.parameters.equals(other.getParameters()))) &&
            ((this.reference==null && other.getReference()==null) || 
             (this.reference!=null &&
              this.reference.equals(other.getReference()))) &&
            ((this.limit==null && other.getLimit()==null) || 
             (this.limit!=null &&
              this.limit.equals(other.getLimit())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getParameters() != null) {
            _hashCode += getParameters().hashCode();
        }
        if (getReference() != null) {
            _hashCode += getReference().hashCode();
        }
        if (getLimit() != null) {
            _hashCode += getLimit().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RetrieveAccountType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "retrieveAccountType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("reference");
        attrField.setXmlName(new javax.xml.namespace.QName("", "reference"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("limit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "limit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "idType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parameters");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "parameters"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "retrieveParametersType"));
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
