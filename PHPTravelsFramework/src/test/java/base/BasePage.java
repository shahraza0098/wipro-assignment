package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtility;

/**
 * Base class for all Page Object classes.
 * Provides shared driver access and wait utility.
 * Question 17 – Why Base Class?
 * – Centralizes driver and wait initialization.
 * – All pages inherit from here, reducing code duplication.
 */
public class BasePage {

    protected WebDriver driver;
    protected WaitUtility waitUtil;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.waitUtil = new WaitUtility(driver);
        PageFactory.initElements(driver, this);
    }
}
