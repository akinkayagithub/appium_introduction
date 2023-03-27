package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import utils.Driver;

public class Base {
    WebDriver driver;
    BasePage basePage;


    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        basePage = new BasePage();
    }

    @AfterMethod
    public void teardown() {
        Driver.quitDriver();
    }
}
