package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Default wait time
    }

    protected void clickElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)); // Ensure the element is visible
        wait.until(ExpectedConditions.elementToBeClickable(element)).click(); // Ensure the element is clickable
    }

    protected void sendKeysToElement(WebElement element, String keys) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear(); // Ensure the element is visible before clearing
        element.sendKeys(keys);
    }
}
