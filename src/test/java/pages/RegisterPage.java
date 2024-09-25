package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;

    @FindBy(xpath = "//input[contains(@id,'gender-male')]")
    WebElement genderMale_xpath;

    @FindBy(xpath = "//input[contains(@id,'gender-female')]")
    WebElement getGenderFemale_xpath;

    @FindBy(xpath = "//input[contains(@id,'FirstName')]")
    WebElement firstName_xpath;

    @FindBy(xpath = "//input[contains(@id,'LastName')]")
    WebElement lastName_xpath;

    @FindBy(xpath = "//input[contains(@id,'Email')]")
    WebElement email_xpath;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement password_xpath;

    @FindBy(xpath = "//input[contains(@id,'ConfirmPassword')]")
    WebElement confirmPassword_xpath;

    @FindBy(xpath = "//input[contains(@id,'register-button')]")
    WebElement registerButton_xpath;

    @FindBy(xpath = "//h1[contains(.,'Register')]")
    WebElement registerTextHd_xpath;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyTheRegistrationPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(registerTextHd_xpath));
        Assert.assertEquals(registerTextHd_xpath.getText(), "Register");
    }

    public void selectGenderTest(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            genderMale_xpath.click();
        } else if (gender.equalsIgnoreCase("female")) {
            getGenderFemale_xpath.click();
        }

    }

    public void enterFirstNameTest(String firstName) {
        firstName_xpath.sendKeys(firstName);
    }

    public void enterLastNameTest(String lastName) {
        lastName_xpath.sendKeys(lastName);
    }

    public void enterEmailTest(String email) {
        email_xpath.sendKeys(email);
    }

    public void enterPasswordTest(String password) {
        password_xpath.sendKeys(password);
    }

    public void enterConfirmPasswordTest(String passwordConfirm) {
        confirmPassword_xpath.sendKeys(passwordConfirm);
    }

    public void clickRegisterButton() {
        registerButton_xpath.click();
    }
}
