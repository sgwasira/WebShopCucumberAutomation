package Steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegisterResultPage;
import utils.BrowserFactory;
import utils.FakerInfo;

public class RegisterStepDefs {

    WebDriver driver;

    Faker faker = new Faker();

    BrowserFactory browserFactory = new BrowserFactory();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String password = firstName + lastName;

    HomePage homePage;
    RegisterPage registerPage;
    RegisterResultPage registerResultPage;

    @Given("I am on the Demo Web Shop Home Page before register")
    public void iAmOnTheDemoWebShopHomePageBeforeRegister() {
        driver = browserFactory.StartBrowser("edge", "https://demowebshop.tricentis.com/");
        homePage = new HomePage(driver);

    }

    @And("I click on the Register Link on the main navigation")
    public void iClickOnTheRegisterLinkOnTheMainNavigation() {
        homePage.clickRegisterButtonTest();
    }


    @Given("I verify the I am on the register page")
    public void i_verify_the_i_am_on_the_register_page() {
        registerPage = new RegisterPage(driver);
        registerPage.verifyTheRegistrationPage();
    }

    @Given("I select my gender")
    public void i_select_my_gender() {
        registerPage.selectGenderTest("female");
    }

    @Then("I enter my first name")
    public void i_enter_my_first_name() {
        registerPage.enterFirstNameTest(firstName);
    }

    @Then("I enter my last name")
    public void i_enter_my_last_name() {
        registerPage.enterLastNameTest(lastName);
    }

    @Then("I enter my email account")
    public void i_enter_my_email_account() {
        registerPage.enterEmailTest(email);
    }

    @Then("I enter my registration password")
    public void i_enter_my_registration_password() {
        registerPage.enterPasswordTest(password);
    }

    @Then("I confirm my registration password")
    public void i_confirm_my_registration_password() {
        registerPage.enterConfirmPasswordTest(password);
    }

    @Then("I click the register Button")
    public void i_click_the_register_button() {
        registerPage.clickRegisterButton();
    }

    @Then("I must be registered and logged in")
    public void i_must_be_registered_and_logged_in() {
        registerResultPage = new RegisterResultPage(driver);
        registerResultPage.verifyThatUserIsRegistered();
        driver.quit();
    }


}
