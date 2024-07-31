package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(name = "userCardNo")
    private WebElement usernameField;

    @FindBy(name = "userPassword")
    private WebElement passwordField;

    @FindBy(id = "loginbutton")
    private WebElement loginButton;

    @FindBy(css = ".modalTitle___WE5UD")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        sendKeysToElement(usernameField, username);
    }

    public void enterPassword(String password) {
        sendKeysToElement(passwordField, password);
    }

    public void clickLogin() {
        clickElement(loginButton);
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText().trim();
    }
}
