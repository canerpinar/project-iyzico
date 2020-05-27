package com.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PaymentDetail extends BaseEntity {

    @ManyToOne
    private Shopping shopping;

    @OneToOne
    private BasketItem basketItem;

    @Column
    private String paymentTransactionId;

    public BasketItem getBasketItem() {
        return basketItem;
    }

    public void setBasketItem(BasketItem basketItem) {
        this.basketItem = basketItem;
    }

    public String getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(String paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    public Shopping getShopping() {
        return shopping;
    }

    public void setShopping(Shopping shopping) {
        this.shopping = shopping;
    }
}
