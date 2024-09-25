package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//a[@href='/login'][contains(.,'Log in')]")
    WebElement login_xpath;

    @FindBy(xpath = "//a[@href='/register'][contains(.,'Register')]")
    WebElement registerButton_xpath;

    @FindBy(xpath = "//h2[@class='topic-html-content-header'][contains(.,'Welcome to our store')]")
    WebElement welcomeText_xpath;

    @FindBy(xpath = "(//a[@href='/computers'][contains(.,'Computers')])[3]")
    WebElement computersCategoriesLink_xpath;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void clickLogInButton() throws InterruptedException {
        Thread.sleep(2000);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(login_xpath));
        login_xpath.click();
    }

    public void clickRegisterButtonTest(){
        registerButton_xpath.click();
    }

    public  void verifyUserIsLoggedIn(){
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(welcomeText_xpath));
        Assert.assertEquals(welcomeText_xpath.getText(), "Welcome to our store");
    }


    public void clickComputersCategoriesLink(){
        computersCategoriesLink_xpath.click();
    }
}
