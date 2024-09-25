package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ComputersPage {

    WebDriver driver;

    @FindBy(xpath = "//h1[contains(.,'Computers')]")
    WebElement computersH1Text_xpath;

    @FindBy(xpath = "//img[@src='https://demowebshop.tricentis.com/content/images/thumbs/0000232_notebooks_125.png']")
    WebElement noteBooksLink_xpath;


    public ComputersPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyTheComputersPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(computersH1Text_xpath));
        Assert.assertEquals(computersH1Text_xpath.getText(), "Computers");
    }

    public void selectNotebooks(){
        noteBooksLink_xpath.click();
    }
}
