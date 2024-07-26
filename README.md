Proje Yapısı ve Açıklaması

Paketler ve Sınıflar

 *`pom.xml`** (Project Object Model), Maven projesinin yapılandırma dosyasıdır.

**src/main/java/pages**
* HomePage.java - Ana sayfa ile ilgili işlemleri içerir.
LoginPage.java - Login ekranı ile ilgili işlemleri içerir.
* HesapOlusturPage.java - Hesap oluşturma işlemleri ile ilgili işlemleri içerir.
* OTPPage.java - OTP ekranı ile ilgili işlemleri içerir.

**src/main/java/utils**

* WebDriverSettings.java - WebDriver ayarlarını ve başlatma işlemlerini içerir.

**src/main/java/resources**
* config.properties - Konfigürasyon bilgilerini içerir.

**src/test/java**

* BaseTest.java - Tüm testler için ortak yapılandırmaları ve başlangıç işlemlerini içerir.
* HesapOlusturTest.java - Hesap oluşturma test senaryolarını içerir.
* ParamTest.java - Param sayfasına giriş için validasyonu içeren test senaryolarını içerir.

**Test Senaryoları**

**Test Senaryosu 1:** 
**Login Sayfasına Yönlendirme ve Hatalı Giriş**

Ana Sayfa Yönlendirmesi
--HomePage sınıfını kullanarak https://param.com.tr adresine gidin.
"Giriş Yap" butonuna tıklayarak /hesap-olustur sayfasına yönlendirin.

Kurumsal Giriş
--HesapOlusturPage sınıfını kullanarak "Kurumsal Giriş" seçeneğine tıklayın.
Login ekranına yönlendirilirsiniz (LoginPage sınıfı).
Hatalı Giriş
Yanlış giriş bilgilerini girin ve validasyon uyarısının doğrulandığını teyit edin.

****Test Senaryosu 2:** 
**Hesap Oluşturma ve OTP Doğrulama**

Login Sayfasına Yönlendirme
Bir önceki adımları tekrar ederek login sayfasına gidin (LoginPage sınıfı).

**Hesap Oluşturma** :
"Hesap Oluştur" seçeneğine tıklayın (LoginPage sınıfı).
HesapOlusturPage sınıfını kullanarak gerekli bilgileri doldurun.
"Devam" butonuna tıklayarak ilerleyin.

**OTP Doğrulama** :
OTP ekranına yönlendirilirsiniz (OTPPage sınıfı).
Yanlış OTP girerek validasyonun doğrulandığını teyit edin.




