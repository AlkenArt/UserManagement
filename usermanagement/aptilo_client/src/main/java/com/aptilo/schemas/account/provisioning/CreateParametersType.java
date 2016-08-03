/**
 * CreateParametersType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aptilo.schemas.account.provisioning;

public class CreateParametersType  implements java.io.Serializable {
    private com.aptilo.schemas.account.provisioning.CreateParameterType[] parameter;

    private com.aptilo.schemas.account.provisioning.GroupParametersType[] group;

    public CreateParametersType() {
    }

    public CreateParametersType(
           com.aptilo.schemas.account.provisioning.CreateParameterType[] parameter,
           com.aptilo.schemas.account.provisioning.GroupParametersType[] group) {
           this.parameter = parameter;
           this.group = group;
    }


    /**
     * Gets the parameter value for this CreateParametersType.
     * 
     * @return parameter
     */
    public com.aptilo.schemas.account.provisioning.CreateParameterType[] getParameter() {
        return parameter;
    }


    /**
     * Sets the parameter value for this CreateParametersType.
     * 
     * @param parameter
     */
    public void setParameter(com.aptilo.schemas.account.provisioning.CreateParameterType[] parameter) {
        this.parameter = parameter;
    }

    public com.aptilo.schemas.account.provisioning.CreateParameterType getParameter(int i) {
        return this.parameter[i];
    }

    public void setParameter(int i, com.aptilo.schemas.account.provisioning.CreateParameterType _value) {
        this.parameter[i] = _value;
    }


    /**
     * Gets the group value for this CreateParametersType.
     * 
     * @return group
     */
    public com.aptilo.schemas.account.provisioning.GroupParametersType[] getGroup() {
        return group;
    }


    /**
     * Sets the group value for this CreateParametersType.
     * 
     * @param group
     */
    public void setGroup(com.aptilo.schemas.account.provisioning.GroupParametersType[] group) {
        this.group = group;
    }

    public com.aptilo.schemas.account.provisioning.GroupParametersType getGroup(int i) {
        return this.group[i];
    }

    public void setGroup(int i, com.aptilo.schemas.account.provisioning.GroupParametersType _value) {
        this.group[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateParametersType)) return false;
        CreateParametersType other = (CreateParametersType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.parameter==null && other.getParameter()==null) || 
             (this.parameter!=null &&
              java.util.Arrays.equals(this.parameter, other.getParameter()))) &&
            ((this.group==null && other.getGroup()==null) || 
             (this.group!=null &&
              java.util.Arrays.equals(this.group, other.getGroup())));
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
        if (getParameter() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParameter());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParameter(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGroup() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGroup());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGroup(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateParametersType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "createParametersType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parameter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "parameter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "createParameterType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("group");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.aptilo.com/account/provisioning", "groupParametersType"));
        elemField.setMinOccurs(0);
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
