package com.service.entity;


import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class ToStringRequestBuilder extends ToStringBuilder {
    public ToStringRequestBuilder(Object object) {
        super(object, new StringRequestStyle());
    }

    public ToStringBuilder append(String fieldName, Object obj) {
        return obj != null && obj instanceof BigDecimal ? super.append(fieldName, ((BigDecimal)obj).doubleValue()) : super.append(fieldName, obj);
    }
}
