package com.projectiyzico.installment;


import com.projectiyzico.entity.Request;
import com.projectiyzico.entity.ToStringRequestBuilder;

import java.math.BigDecimal;

public class RetrieveInstallmentRequest extends Request {
    private String binNumber;
    private BigDecimal price;

    public RetrieveInstallmentRequest() {
    }

    public String getBinNumber() {
        return this.binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String toString() {
        return (new ToStringRequestBuilder(this)).appendSuper(super.toString()).append("binNumber", this.binNumber).append("price", this.price).toString();
    }
}
