package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "userCardNo")  // Kullanıcı adı alanının doğru ID veya seçicisini buraya ekleyin
    WebElement usernameField;

    @FindBy(name = "userPassword")  // Şifre alanının doğru ID veya seçicisini buraya ekleyin
    WebElement passwordField;

    @FindBy(id = "loginbutton")  // Giriş butonunun doğru ID veya seçicisini buraya ekleyin
    WebElement loginButton;

    @FindBy(css = ".validation-message")  // Validasyon mesajının doğru CSS seçicisini buraya ekleyin
    WebElement validationMessage;




    @FindBy(css = ".modalTitle___WE5UD")  // Hata mesajının CSS seçicisi
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 saniye bekleme süresi
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear(); // Kullanıcı adı alanını temizle
        usernameField.sendKeys(username); // Yeni kullanıcı adını gir
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear(); // Şifre alanını temizle
        passwordField.sendKeys(password); // Yeni şifreyi gir
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }





    public String getValidationMessage() {
        return validationMessage.getText();
    }



    public void waitForPasswordField() {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage)); // Hata mesajının görünür olmasını bekle
        return errorMessage.getText(); // Hata mesajını döndür
    }
}
