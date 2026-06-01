package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilities.ConfigReader;

/**
 * Question 7 – Thread Safe Driver Framework
 * Uses ThreadLocal<WebDriver> to ensure each thread gets its own browser instance.
 * No static driver. Supports parallel execution safely.
 */
public class DriverFactory {

    // ThreadLocal ensures a separate WebDriver instance per thread (Question 7)
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    /**
     * Initializes the WebDriver based on the browser specified in config.properties
     * Question 13 – Cross Browser Execution
     */
    public static void initDriver() {
        String browser = ConfigReader.getProperty("browser").trim().toLowerCase();
        WebDriver driver;

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-popup-blocking");
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        driver.manage().deleteAllCookies();
        driver.get(ConfigReader.getProperty("base.url"));
        setDriver(driver);
    }

    /**
     * Sets the WebDriver instance for the current thread.
     */
    public static void setDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

    /**
     * Returns the WebDriver instance for the current thread.
     */
    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    /**
     * Quits the browser and removes the driver from ThreadLocal to prevent memory leaks.
     */
    public static void quitDriver() {
        if (threadLocalDriver.get() != null) {
            threadLocalDriver.get().quit();
            threadLocalDriver.remove();
        }
    }
}
