package Steps;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class BrowserTest {
    WebDriver driver;

    BrowserFactory browserFactory = new BrowserFactory();

    @Test
    public void testBrowser(){
        driver = browserFactory.StartBrowser("edge", "https://www.facebook.com");
    }

}
