package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(id = "menu_login")  // Giriş Yap butonunun doğru ID'si
    private WebElement girisYapButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickGirisYap() {
        // Giriş Yap butonunun görünür ve tıklanabilir olmasını bekleyin ve tıklayın
        clickElement(girisYapButton);
    }
}
