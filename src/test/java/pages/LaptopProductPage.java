package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaptopProductPage {
    WebDriver driver;

    @FindBy(xpath = "//input[contains(@id,'addtocart_31_EnteredQuantity')]")
    WebElement qty_xpath;

    @FindBy(xpath = "//input[contains(@id,'add-to-cart-button-31')]")
    WebElement addToCart_31_xpath;

    @FindBy(xpath = "//span[@class='cart-label'][contains(.,'Shopping cart')]")
    WebElement  shoppingCart_xpath;

    public  LaptopProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clearQtyField(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(qty_xpath));
        qty_xpath.clear();

    }

    public void addQtyToBuy(){
        qty_xpath.sendKeys("2");
    }

    public  void clickAddToCart(){
        addToCart_31_xpath.click();
    }

    public  void clickShoppingCartButton(){
        shoppingCart_xpath.click();
    }
}
