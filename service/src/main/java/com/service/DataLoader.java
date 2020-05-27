package com.service;


import com.service.entity.BasketItem;
import com.service.entity.Buyer;
import com.service.service.CustomerService;
import com.service.service.ShoppingService;
import com.service.service.UrunService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class DataLoader implements CommandLineRunner {

    private UrunService urunService;

    private CustomerService customerService;

    private ShoppingService shoppingService;

    public DataLoader(UrunService urunService,CustomerService customerService,ShoppingService shoppingService) {
        this.urunService = urunService;
        this.customerService = customerService;
        this.shoppingService = shoppingService;
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

        //shoppingService.deleteAll();
        urunService.deleteAll();

        BasketItem basketItem = new BasketItem();
        basketItem.setId(1l);
        basketItem.setPrice(BigDecimal.valueOf(1580.00));
        basketItem.setName("DELL INSPIRON 2150");
        basketItem.setItemType("PHYSICAL");

        basketItem.setCategory1("Elektronik");
        basketItem.setCategory2("Bilgisayar");
        urunService.save(basketItem);

        BasketItem basketItem2 = new BasketItem();
        basketItem2.setId(2L);
        basketItem2.setPrice(BigDecimal.valueOf(1580.00));
        basketItem2.setName("Samsung HDD 7200 RPM");
        basketItem2.setItemType("PHYSICAL");
        basketItem2.setCategory1("Elektronik");
        basketItem2.setCategory2("Aksesuar");

        urunService.save(basketItem2);

        Buyer buyer = new Buyer();
        buyer.setId((long) 1);
        buyer.setCity("Edremit");
        buyer.setCountry("Nalıkesir");
        customerService.save(buyer);

        //System.out.println(urunService.getUrunList().iterator().next().getName());

    }
}
