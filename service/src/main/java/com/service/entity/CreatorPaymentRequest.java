package com.service.entity;




import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class CreatorPaymentRequest extends Request {


    @Column(name="price")
    private BigDecimal price;

    @Column(name="paidprice")
    private BigDecimal paidPrice;

    @Column(name="installment")
    private Integer installment;

    @Column(name="channel")
    private String paymentChannel;


    @Column(name="basketId")
    private String basketId;

    private String paymentGroup;

    @OneToOne
    @Transient
    private PaymentCard paymentCard;

    @OneToOne
    private Buyer buyer;

    @OneToOne
    private Address shippingAddress;
    
    @OneToOne
    private Address billingAddress;

    @OneToMany
    @Transient
    private List<BasketItem> basketItems;

    @Column(name="paymentSource")
    private String paymentSource;

    @Column(name="callbackUrl")
    private String callbackUrl;

    @Column(name="posOrderId")
    private String posOrderId;
    @Column(name="connectorName")
    private String connectorName;

    @Column(name="currency")
    private String currency;

    public CreatorPaymentRequest() {
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPaidPrice() {
        return this.paidPrice;
    }

    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
    }

    public Integer getInstallment() {
        return this.installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public String getPaymentChannel() {
        return this.paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public String getBasketId() {
        return this.basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    public String getPaymentGroup() {
        return this.paymentGroup;
    }

    public void setPaymentGroup(String paymentGroup) {
        this.paymentGroup = paymentGroup;
    }

    public PaymentCard getPaymentCard() {
        return this.paymentCard;
    }

    public void setPaymentCard(PaymentCard paymentCard) {
        this.paymentCard = paymentCard;
    }

    public Buyer getBuyer() {
        return this.buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Address getShippingAddress() {
        return this.shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return this.billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public List<BasketItem> getBasketItems() {
        return this.basketItems;
    }

    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    public String getPaymentSource() {
        return this.paymentSource;
    }

    public void setPaymentSource(String paymentSource) {
        this.paymentSource = paymentSource;
    }

    public String getCallbackUrl() {
        return this.callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getPosOrderId() {
        return this.posOrderId;
    }

    public void setPosOrderId(String posOrderId) {
        this.posOrderId = posOrderId;
    }

    public String getConnectorName() {
        return this.connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String toString() {
        return (new ToStringRequestBuilder(this)).appendSuper(super.toString()).append("price", this.price).append("paidPrice", this.paidPrice).append("installment", this.installment).append("paymentChannel", this.paymentChannel).append("basketId", this.basketId).append("paymentGroup", this.paymentGroup).append("paymentCard", this.paymentCard).append("buyer", this.buyer).append("shippingAddress", this.shippingAddress).append("billingAddress", this.billingAddress).append("basketItems", this.basketItems).append("paymentSource", this.paymentSource).append("currency", this.currency).append("posOrderId", this.posOrderId).append("connectorName", this.connectorName).append("callbackUrl", this.callbackUrl).toString();
    }
}
