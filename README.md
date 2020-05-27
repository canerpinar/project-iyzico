Projede iki modüle bulunmaktadır.web-client modülü gelen ödeme bilgilerini alarak service modülüne sunmaktadır.
service modülü üzerinde bulunan PaymentService classının sendPayment fonksiyonu ile ödeme yapılmakta ve ödeme sonucunu PaymentStatus olarak 
web-client modülüne geri döndürmektedir.İşlemi yapan fonkisyon(sendPayment) CreatorPaymentRequest sınıfından obje almaktadır. 
Webclient modülünde gereklilikler tamamlandıktan sonra istekler service katmanına aktarılır.Aktarılan bilgilerin null özellikleri
kontrol edilir sorun varsa hatalar geri bildirim yapılır.
Satın alınması planlanan ürünler webclient modülünde session nesnesinde tutulur.İyzico api de mutlaka tutulması gereken sepet id ve conversation id
PaymentService classı tarafından sağlanan getNextConversation ve getNextBasketId fonksiyonları tarafından sağlanmaktadır.
<h4>Taksitlendirme</h4>
Taksitlendirme seçeneklerinde sepet tutarı sabit kalarak, iyzico apiden dönen taksit tutarlarının dökümü gözükmektedir.Burada ki tutarlar apiden
sağlanan tutarlara karşılık gelmektedir.Taksitli ödeme seçeneklerinde oluşan fiyat farkı ödeme yapan karta yansıtılmaktadır.
<h4>Kredi Kartı Bilgilerinin Kontrol Edilmesi</h4>
Kredi kartı bilgileri girilip ödeme isteği yapıldığında, oluşan hata olması durumunda hatalar ve kullanıcı bilgileri URL bilgilerine ekelenerek
web-client modülüne yansıtılmaktadır.web-client modülünde gelen hatalar javascript ile kontrol edilerek Uİ tasarımında gösterilmektedir.
Service katmanı ile web modüle arasında iletişim methodlar ile sağlanmaktadır.Gönderilen isteklere karşılık alınan cevaplar web-client modülünde işleme 
alınır.Service katmanında stateless bir durum söz konusudur.Data ve service katmanları servis modülünde barındırılmaktadır.
<h4>Ödemenin başarılı olması durumu</h4>
Ödemenin başarılı olması web-client modülünde callback fonksiyonun başarılı olması ile sağlanır.Callback fonksiyonuna gelen parametreler den 
conversation Id bulunarak creatorPaymentRequestService(findCreatorPaymentRequestByConversationId) ile  veritabanından sorgulanır.Sorgulama işlemi doğruysa veritabanından gelen bilgiler kullanıcıya yansıtılır.
Son olarak başarılı olan ödeme CreatorThreedPaymentRequestService ile CreatorThreedPaymentRequestRepository tablosuna yazılır.
<h4>Kurulum için</h4>
Mysql kurulu olması durumunda Maven install çalıştırılarak webclient war dosyası kullanılabilir.service modülü jar dosyası olarak paketlenmiştir.

<h3>NOTLAR</h3>
Geliştirme safhasında önyüzde template Engine framework olarak thymeleaf kullanılmıştır.Javascript kütüphanelerinden verileri işlemek için angular
kullanıldı.post get işlemleri için angular modülleri kullanıldı.Tomcat 9.0.3 ve 8.5  te denendi.

<h4>Kullanılan Versiyon Bilgisi</h4>
Mysql 5.7
Maven 3.5
Spring Boot 2.2.4
Java 1.8