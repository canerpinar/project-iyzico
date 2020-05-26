package com.projectiyzico;


import com.projectiyzico.entity.BasketItem;
import com.projectiyzico.entity.Buyer;
import com.projectiyzico.service.CustomerService;
import com.projectiyzico.service.ShoppingService;
import com.projectiyzico.service.UrunService;
import org.springframework.boot.CommandLineRunner;
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
        basketItem.setPrice(BigDecimal.valueOf(1580.00));
        basketItem.setName("DELL INSPIRON 2150");
        basketItem.setItemType("PHYSICAL");

        basketItem.setCategory1("Elektronik");
        basketItem.setCategory2("Bilgisayar");
        urunService.save(basketItem);

        BasketItem basketItem2 = new BasketItem();

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
