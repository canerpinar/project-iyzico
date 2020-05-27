package com.service.entity;


import org.apache.commons.lang3.builder.ToStringStyle;

public class StringRequestStyle extends ToStringStyle {

    public StringRequestStyle() {
        this.setUseClassName(false);
        this.setUseFieldNames(true);
        this.setUseIdentityHashCode(false);
    }

    public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
        if (value != null) {
            super.append(buffer, fieldName, value, fullDetail);
        }

    }
}
