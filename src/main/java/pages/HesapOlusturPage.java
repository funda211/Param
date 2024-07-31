package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HesapOlusturPage extends BasePage {

    // Kurumsal Giriş butonunu için CSS
    @FindBy(css = "a.btn.btn-outline-primary.btn-icon[href*='isyerim.param.com.tr']")
    WebElement kurumsalGirisButton;

    // Hesap Oluştur linki
    @FindBy(css = "span.signUp___3OOhy") // Hesap Oluştur linkinin CSS
    WebElement hesapOlusturLink;

    // Hesap oluşturma form elemanları
    @FindBy(name = "name")
    WebElement adInput;

    @FindBy(name = "surname")
    WebElement soyadInput;

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "gsmNumber")
    WebElement telefonInput;

    @FindBy(name = "checkBox1")
    WebElement aydinlatmaMetni;

    @FindBy(name = "checkBox2")
    WebElement veriMetni;

    @FindBy(name = "checkBox3")
    WebElement elektronikSozlesme;

    @FindBy(id = "continue_from_signup") // Devam butonu ID
    WebElement devamButton;

    public HesapOlusturPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickKurumsalGiris() {
        clickElement(kurumsalGirisButton);
    }

    public void clickHesapOlustur() {
        clickElement(hesapOlusturLink);
    }

    // Hesap oluşturma formunu doldur
    public void fillAccountCreationForm(String ad, String soyad, String email, String telefon) {
        sendKeysToElement(adInput, ad);
        sendKeysToElement(soyadInput, soyad);
        sendKeysToElement(emailInput, email);
        sendKeysToElement(telefonInput, telefon);
    }

    public void clickCheckboxes() {
        clickElement(aydinlatmaMetni);
        clickElement(veriMetni);
        clickElement(elektronikSozlesme);
    }

    // Devam butonuna tıkla
    public void clickDevam() {
        clickElement(devamButton);
    }
}
