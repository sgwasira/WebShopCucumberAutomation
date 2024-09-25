package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterResultPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='result'][contains(.,'Your registration completed')]")
    WebElement registerMsgText_xpath;

    @FindBy(xpath = "//a[@href='/logout'][contains(.,'Log out')]")
    WebElement logOut_xpath;

    public RegisterResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void verifyThatUserIsRegistered() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(registerMsgText_xpath));
        Assert.assertEquals(registerMsgText_xpath.getText(), "Your registration completed");

        logOut_xpath.click();

    }
}
