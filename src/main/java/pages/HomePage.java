package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "_palamar_chat_iframe")  // iframe'in ID'si
    private WebElement cookieIframe;

    @FindBy(css = "button[type='button']")  // Çerezleri kabul et butonunun `type` özniteliği
    private WebElement cookieAcceptButton;

    @FindBy(id = "menu_login")  // Giriş Yap butonunun doğru ID'si
    private WebElement girisYapButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 saniye bekleme süresi
        PageFactory.initElements(driver, this);
    }

    public void waitForCookiesBanner() {
        // İframe'in yüklenmesini ve geçişi bekleyin
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(cookieIframe));
        // Çerezleri kabul et butonunun görünür olmasını bekleyin
        wait.until(ExpectedConditions.visibilityOf(cookieAcceptButton));
    }

    public void acceptCookies() {
        // İframe'e geçiş yapın
        driver.switchTo().frame(cookieIframe);
        // Çerezleri kabul et butonuna tıklayın
        cookieAcceptButton.click();
        // Ana sayfaya dönün
        driver.switchTo().defaultContent();
    }

    public void clickGirisYap() {
        // Giriş Yap butonunun görünür olmasını ve tıklanabilir olmasını bekleyin
        wait.until(ExpectedConditions.elementToBeClickable(girisYapButton));
        // Giriş Yap butonuna tıklayın
        girisYapButton.click();
    }
}
