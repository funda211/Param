package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HesapOlusturPage;
import pages.LoginPage;
import utils.BaseTest;

import java.time.Duration;

public class ParamTest extends BaseTest {

    private static final String EXPECTED_ERROR_MESSAGE = "Hatalı bilgi girişi yaptınız. Lütfen bilgilerinizi kontrol ediniz.";

    @Test
    public void testParamLogin() {
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

        // Giriş sayfasına erişim ve giriş işlemleri
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("13436394147");
        loginPage.enterPassword("334455");
        loginPage.clickLogin();

        // Hata mesajını kontrol et
        String messageText = loginPage.getErrorMessage().trim();
        System.out.println("Actual message: " + messageText);

        // Mesajın beklenen değerle eşleşip eşleşmediğini kontrol et
        String normalizedMessageText = messageText.replaceAll("\\s+", " ").trim();
        Assert.assertEquals(normalizedMessageText, EXPECTED_ERROR_MESSAGE, "Mesaj beklenilen değerle eşleşmiyor: " + messageText);

        tearDown();
    }
}
