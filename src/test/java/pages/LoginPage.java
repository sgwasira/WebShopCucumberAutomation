package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//input[contains(@id,'Email')]")
    WebElement email_xpath;

    @FindBy(xpath = "//input[contains(@id,'Password')]")
    WebElement password_xpath;

    @FindBy(xpath = "//input[contains(@id,'RememberMe')]")
    WebElement rememberMe_xpath;

    @FindBy(xpath = "//input[contains(@class,'button-1 login-button')]")
    WebElement loginButton_xpath;

    @FindBy(xpath = "//h1[contains(.,'Welcome, Please Sign In!')]")
    WebElement welcomeText_xpath;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyTheLoginPageTest(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(welcomeText_xpath));
        Assert.assertEquals(welcomeText_xpath.getText(),"Welcome, Please Sign In!");
    }

    public  void enterEmailTest(String email){
        email_xpath.sendKeys(email);
    }

    public  void enterPasswordTest(String password){
        password_xpath.sendKeys(password);
    }

    public  void clickRememberMeCheckboxTest(){
        rememberMe_xpath.click();
    }

    public void clickLoginButton(){
        loginButton_xpath.click();
    }
}
