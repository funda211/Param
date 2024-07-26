package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class HesapOlusturPage {
    WebDriver driver;

    // Kurumsal Giriş butonunun seçici
    @FindBy(css = "a.btn.btn-outline-primary.btn-icon[href*='isyerim.param.com.tr']")
    WebElement kurumsalGirisButton;

    // Hesap Oluştur linki
    @FindBy(css = "span.signUp___3OOhy") // Hesap Oluştur linkinin doğru seçicisini buraya ekleyin
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




    @FindBy(id = "continue_from_signup") // Devam butonunun doğru seçicisini buraya ekleyin
    WebElement devamButton;

    public HesapOlusturPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickKurumsalGiris() {
        kurumsalGirisButton.click();
    }

    public void clickHesapOlustur() {
        hesapOlusturLink.click();
    }

    // Hesap oluşturma formunu doldur
    public void fillAccountCreationForm(String ad, String soyad, String email, String telefon) {
        adInput.sendKeys(ad);
        soyadInput.sendKeys(soyad);
        emailInput.sendKeys(email);
        telefonInput.sendKeys(telefon);

    }

     public void clickCheckboxes() {
        aydinlatmaMetni.click();
        veriMetni.click();
        elektronikSozlesme.click();
    }
    // Devam butonuna tıkla
    public void clickDevam() {
        devamButton.click();


    }
}
