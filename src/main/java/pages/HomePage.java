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

    @FindBy(id = "menu_login")  // Giriş Yap butonunun doğru ID'si
    private WebElement girisYapButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 saniye bekleme süresi
        PageFactory.initElements(driver, this);
    }


    public void clickGirisYap() {
        // Giriş Yap butonunun görünür olmasını ve tıklanabilir olmasını bekleyin
        wait.until(ExpectedConditions.elementToBeClickable(girisYapButton));
        // Giriş Yap butonuna tıklayın
        girisYapButton.click();
    }
}
