package Steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.BrowserFactory;

public class StepDef {

    WebDriver driver;

    BrowserFactory browserFactory = new BrowserFactory();
    HomePage homePage;
    LoginPage loginPage;
    ComputersPage computersPage;
    NotebooksProductPage notebooksProductPage;
    LaptopProductPage laptopProductPage;

    @Given("I am on the Demo Web Shop Home Page")
    public void i_am_on_the_demo_web_shop_home_page() {
        driver = browserFactory.StartBrowser("edge", "https://demowebshop.tricentis.com/");
        homePage = new HomePage(driver);
    }

    @And("I click on the Log In Link on the main navigation")
    public void i_click_on_the_log_in_link_on_the_main_navigation() throws InterruptedException {
        homePage.clickLogInButton();
    }

    @Then("I enter my user name")
    public void i_enter_my_user_name() {
        loginPage = new LoginPage(driver);
        loginPage.verifyTheLoginPageTest();
        loginPage.enterEmailTest("sgwasira@yahoo.com");
    }

    @Then("I enter my password")
    public void i_enter_my_password() {
        loginPage.enterPasswordTest("Uplands747");
    }

    @Then("I check the Remember me box")
    public void i_check_the_remember_me_box() {
        loginPage.clickRememberMeCheckboxTest();
    }

    @Then("I click the Log in Button")
    public void i_click_the_log_in_button() {
        loginPage.clickLoginButton();
    }

    @Then("I must be logged in")
    public void i_must_be_logged_in() {
        homePage.verifyUserIsLoggedIn();
    }

    @And("I select the Computer Product")
    public void iSelectTheComputerProduct() {
        homePage.clickComputersCategoriesLink();
    }

    @And("I click on the Notebooks Link")
    public void iClickOnTheNotebooksLink() {
        computersPage = new ComputersPage(driver);
        computersPage.verifyTheComputersPage();
        computersPage.selectNotebooks();
    }


    @Then("Select the fourteen inch Laptop")
    public void selectTheFourteenInchLaptop() {
        notebooksProductPage = new NotebooksProductPage(driver);
        notebooksProductPage.verifyNotebookProductsPage();
        notebooksProductPage.selectLaptop();
    }

    @Then("I add the number of laptop I want to buy")
    public void i_add_the_number_of_laptop_i_want_to_buy() throws InterruptedException {
        laptopProductPage = new LaptopProductPage(driver);
        Thread.sleep(2000);
        laptopProductPage.clearQtyField();
        laptopProductPage.addQtyToBuy();

    }

    @Then("Click the add to cart button")
    public void click_the_add_to_cart_button() {
        laptopProductPage.clickAddToCart();
    }

    @Then("I click on the Shopping cart link")
    public void i_click_on_the_shopping_cart_link() {
        laptopProductPage.clickShoppingCartButton();
    }

}
