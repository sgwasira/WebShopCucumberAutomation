package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[contains(@id,'CountryId')]")
    WebElement countryId_xpath;

    @FindBy(xpath = "//select[contains(@id,'StateProvinceId')]")
    WebElement stateProvinceId_xpath;

    @FindBy(xpath = "//input[contains(@id,'ZipPostalCode')]")
    WebElement zipPostalCode_xpath;

    @FindBy(xpath = "//input[contains(@id,'termsofservice')]")
    WebElement termsOfService_xpath;

    @FindBy(xpath = "//button[contains(@id,'checkout')]")
    WebElement checkOut_xpath;

    public void selectCountry() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(countryId_xpath));
        Select dropdown = new Select(countryId_xpath);
        dropdown.selectByVisibleText("South Africa");
    }

    public void selectProvince(){
        Select dropdown = new Select(stateProvinceId_xpath);
        dropdown.selectByVisibleText("Other (Non US)");
    }

    public void enterZipCode(){
        zipPostalCode_xpath.sendKeys("344");
    }

    public  void selectTermsOfService(){
        termsOfService_xpath.click();
    }

    public void clickCheckOut(){
        checkOut_xpath.click();
    }
}
