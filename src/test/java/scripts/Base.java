package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import utils.ConfigReader;
import utils.Driver;

public class Base {
    WebDriver driver;
    boolean isMobile;
    BasePage basePage;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        isMobile = Boolean.parseBoolean(ConfigReader.getProperty("isMobile"));
        basePage = new BasePage();
    }

    @AfterMethod
    public void teardown() {
        Driver.quitDriver();
    }
}
