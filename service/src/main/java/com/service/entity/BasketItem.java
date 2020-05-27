package com.service.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class BasketItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal price;
    @Column
    private String name;
    @Column
    private String category1;
    @Column
    private String category2;
    @Column
    private String itemType;
    @Column
    private String subMerchantKey;

    @Column
    private BigDecimal subMerchantPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSubMerchantKey() {
        return subMerchantKey;
    }

    public void setSubMerchantKey(String subMerchantKey) {
        this.subMerchantKey = subMerchantKey;
    }

    public BigDecimal getSubMerchantPrice() {
        return subMerchantPrice;
    }

    public void setSubMerchantPrice(BigDecimal subMerchantPrice) {
        this.subMerchantPrice = subMerchantPrice;
    }


    public String toString() {
        return (new ToStringRequestBuilder(this)).append("id", this.id).append("price", this.price).append("name", this.name).append("category1", this.category1).append("category2", this.category2).append("itemType", this.itemType).append("subMerchantKey", this.subMerchantKey).append("subMerchantPrice", this.subMerchantPrice).toString();
    }
}
