package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class NotebooksProductPage {

    WebDriver driver;

    @FindBy(xpath = "//img[@src='https://demowebshop.tricentis.com/content/images/thumbs/0000224_141-inch-laptop_125.png']")
    WebElement laptop14Inch_xpath;

    @FindBy(xpath = "//h1[contains(.,'Notebooks')]")
    WebElement notebooksH1Text_xpath;

    public NotebooksProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void verifyNotebookProductsPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(notebooksH1Text_xpath));
        Assert.assertEquals(notebooksH1Text_xpath.getText(),"Notebooks");
    }

    public  void selectLaptop(){
        laptop14Inch_xpath.click();
    }
}
