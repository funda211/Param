package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class OTPPage extends BasePage {

    @FindBy(name = "input1")
    WebElement otpInput1;

    @FindBy(name = "input2")
    WebElement otpInput2;

    @FindBy(name = "input3")
    WebElement otpInput3;

    @FindBy(name = "input4")
    WebElement otpInput4;

    @FindBy(name = "input5")
    WebElement otpInput5;

    @FindBy(name = "input6")
    WebElement otpInput6;

    @FindBy(css = ".otpErrorSelector")
    WebElement otpErrorMessage;

    @FindBy(id = "continue_from_otp")
    WebElement onaylaButton;

    public OTPPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterRandomOTP() {
        Random rand = new Random();
        otpInput1.sendKeys(String.valueOf(rand.nextInt(10)));
        otpInput2.sendKeys(String.valueOf(rand.nextInt(10)));
        otpInput3.sendKeys(String.valueOf(rand.nextInt(10)));
        otpInput4.sendKeys(String.valueOf(rand.nextInt(10)));
        otpInput5.sendKeys(String.valueOf(rand.nextInt(10)));
        otpInput6.sendKeys(String.valueOf(rand.nextInt(10)));
    }

    public void clickOnayla() {
        clickElement(onaylaButton); // BasePage'deki clickElement metodunu kullan
    }
/*
    public WebElement getOtpErrorMessage() {
        return otpErrorMessage;
    }*/
}
