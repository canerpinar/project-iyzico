package com.service.entity;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingDetail {
    List<BasketItem> basketItemList = new ArrayList<BasketItem>();
    private BigDecimal toplam = new BigDecimal(0);

    public List<BasketItem> getBasketItemList() {
        return basketItemList;
    }

    public void setBasketItemList(List<BasketItem> basketItemList) {
        this.basketItemList = basketItemList;
    }

    public BigDecimal getToplam() {
        return toplam;
    }

    public void setToplam(BigDecimal toplam) {
        this.toplam.add(toplam);
    }
}
