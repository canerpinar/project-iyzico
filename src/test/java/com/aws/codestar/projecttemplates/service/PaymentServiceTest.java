package com.aws.codestar.projecttemplates.service;


public class PaymentServiceTest {
/*
    @Autowired
    PaymentService paymentService;

    private CreatePaymentRequest request;
    private CreditCard paymentCard;
    private Customer buyer;
    private Address shippingAddress;
    private Address billingAddress;
    private List<BasketItem> basketItems;
    private ThreedsInitialize threedsInitialize;


    @Before
    public void setUp() throws Exception {
        request = new CreatePaymentRequest();

        request.setConversationId("123456789");
        request.setPrice(BigDecimal.valueOf(100));
        request.setPaidPrice(BigDecimal.valueOf(100));
        request.setCurrency(Currency.TRY.name());
        request.setInstallment(1);
        request.setBasketId("B67832");
        request.setPaymentChannel(PaymentChannel.WEB.name());
        request.setPaymentGroup(PaymentGroup.PRODUCT.name());
        request.setCallbackUrl("http://localhost:8080/callback");

        buyer = new Customer();
        buyer.setId(1L);
        buyer.setName("Ahmet Geçen");
        buyer.setEmail("kemal_su@hotmail.com");
        buyer.setIdentityNumber("26895264506");
        buyer.setCity("Bilinmiyor");
        buyer.setCountry("Türkiye");
        buyer.setGsmNumber("Bilinmiyor");
        buyer.setIp("160.75.62.59");
        buyer.setSurname("Yetmez");
        buyer.setRegistrationAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");

        shippingAddress = new Address();
        shippingAddress.setContactName("Jane Doe");
        shippingAddress.setCity("Istanbul");
        shippingAddress.setCountry("Turkey");
        shippingAddress.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        shippingAddress.setZipCode("34742");

        billingAddress = new Address();
        billingAddress.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        billingAddress.setContactName("Ahmet Geçen Yetmez");
        billingAddress.setCity("Şişli");
        billingAddress.setCountry("İstanbul");

        paymentCard = new CreditCard();

        paymentCard.setCardHolderName("Ahmet Geçen");
        paymentCard.setCardNumber("9792020000000001");
        paymentCard.setCvc("120");
        paymentCard.setExpireMonth("10");
        paymentCard.setExpireYear("2030");

        basketItems = new ArrayList<>();

        Urun basketItem = new Urun();
        basketItem.setCategory1("Elektronik");
        basketItem.setCategory2("Bilgisayar");
        basketItem.setId(1L);
        basketItem.setPrice(new BigDecimal(100));
        basketItem.setItemType(BasketItemType.PHYSICAL.toString());
        basketItem.setName("DELL LATİTUTE 2110");
        //basketItems.add(basketItem);

        paymentService.addUrun(basketItem);
        paymentService.setBuyer(buyer);
        paymentService.setShippingAddress(shippingAddress);
        paymentService.setCreatePaymentRequest(request);
        paymentService.setPaymentCard(paymentCard);
        //paymentService.setBasketItems(basketItems);
        paymentService.setBillingAddress(billingAddress);

    }

    @Test
    public void getOptions() {
    }

    @Test
    public void sendPayment() throws JsonProcessingException, EntityNotFoundException, PropertiesNotFound {
        ThreedsInitialize threedsInitialize = paymentService.sendPayment();
        assertEquals(threedsInitialize.getStatus(),"success");
        assertEquals(threedsInitialize.getConversationId(),"123456789");
    }


 */


}