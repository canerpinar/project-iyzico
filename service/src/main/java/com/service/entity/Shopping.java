package com.service.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Shopping")
public class Shopping {

    @Id
    @Column(name="id")
    private Long id;


    @OneToMany(mappedBy = "shopping",cascade = CascadeType.ALL)
    private List<PaymentDetail> paymentDetail;

    @OneToOne
    private Buyer buyer;

    @Column
    private Date shoppinTime;

    @Column
    private BigDecimal sumPrice;

    @Column
    private String paymentId;


    public List<PaymentDetail> getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(List<PaymentDetail> paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }


    public Date getShoppinTime() {
        return shoppinTime;
    }

    public void setShoppinTime(Date shoppinTime) {
        this.shoppinTime = shoppinTime;
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}
