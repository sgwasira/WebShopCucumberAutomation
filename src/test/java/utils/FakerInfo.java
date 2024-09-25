package utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

public class FakerInfo {

    WebDriver driver;
    static Faker faker = new Faker();

    public FakerInfo(WebDriver driver){
        this.driver = driver;
    }

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = faker.internet().emailAddress();
    public static String password = firstName + lastName;

}
