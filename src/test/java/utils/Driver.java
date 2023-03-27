package utils;

import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    private static WebDriver driver;
    private static final DesiredCapabilities caps = new DesiredCapabilities();


    public static WebDriver getDriver(){
        if(driver == null){
            boolean isMobile = Boolean.parseBoolean(ConfigReader.getProperty("isMobile"));
            if(isMobile){
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
                caps.setCapability(MobileCapabilityType.BROWSER_NAME, ConfigReader.getProperty("browser"));

                URL appiumURL = null;
                try {
                    appiumURL = new URL("http://127.0.0.1:4723/wd/hub/");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                driver = new RemoteWebDriver(appiumURL, caps);
            }
            else{
                String browser = ConfigReader.getProperty("browser");
                switch (browser.toLowerCase()){
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case "safari":
                        WebDriverManager.getInstance(SafariDriver.class);
                        driver = new SafariDriver();
                        break;
                    default:
                        throw new IllegalStateException(browser + " browser does not match any case!!!");
                }
                driver.manage().window().maximize();
            }
            driver.get(ConfigReader.getProperty("appURL"));
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitWait")), TimeUnit.SECONDS);
        }
        return driver;
    }


    public static void quitDriver(){
        if(driver != null){
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }

}
