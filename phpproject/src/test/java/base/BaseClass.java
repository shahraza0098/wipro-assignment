package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.ConfigReader;

public class BaseClass {

    public static void launchBrowser() {

        String browser = ConfigReader.getProperty("browser");

        WebDriver driver = null;

        switch(browser.toLowerCase()) {

        case "chrome":
            driver = new ChromeDriver();
            break;

        case "firefox":
            driver = new FirefoxDriver();
            break;

        case "edge":
            driver = new EdgeDriver();
            break;
        }

        DriverFactory.setDriver(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        driver.get(ConfigReader.getProperty("url"));
    }

    public static void quitBrowser() {

        DriverFactory.getDriver().quit();
        DriverFactory.unload();
    }
}