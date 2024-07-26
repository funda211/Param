package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HesapOlusturPage;
import pages.OTPPage;
import utils.BaseTest;

import java.time.Duration;

public class HesapOlusturTest extends BaseTest {

    private static final String EXPECTED_ERROR_MESSAGE = "Girdiğiniz onay kodu hatalıdır.";

    @Test
    public void testHesapOlusturAndOTP() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Ana sayfaya git
        driver.get("https://param.com.tr/");
        HomePage homePage = new HomePage(driver);
        homePage.clickGirisYap();

        // Kurumsal giriş sayfasına git
        HesapOlusturPage hesapOlusturPage = new HesapOlusturPage(driver);
        hesapOlusturPage.clickKurumsalGiris();

        // Tüm pencere tutucularını geçiş yap
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        // "Hesap Oluştur" linkine tıklama
        hesapOlusturPage.clickHesapOlustur();

        // Hesap oluşturma bilgilerini doldur
        hesapOlusturPage.fillAccountCreationForm("ad", "soyad", "email@example.com", "5999999991");

        // CheckBox'lara tıklama
        hesapOlusturPage.clickCheckboxes();

        // Devam butonuna tıklama
        hesapOlusturPage.clickDevam();

        // OTP ekranına geçiş
        OTPPage otpPage = new OTPPage(driver);

        // Rastgele OTP gir
        otpPage.enterRandomOTP();

        // Onayla butonuna tıkla
        otpPage.clickOnayla();

        // Hata mesajını kontrol et
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorVerificationNo")));
        String otpMessageText = messageElement.getText().trim();
        System.out.println("Actual message: " + otpMessageText);

        // Mesajın beklenen değerle eşleşip eşleşmediğini kontrol et
        Assert.assertEquals(otpMessageText, EXPECTED_ERROR_MESSAGE, "Mesaj beklenilen değerle eşleşmiyor: " + otpMessageText);

        tearDown();
    }
}
