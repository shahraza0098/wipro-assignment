package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Question 10 – Reusable Wait Utility
 * All waits use WebDriverWait with ExpectedConditions.
 * Thread.sleep() is strictly PROHIBITED throughout this framework.
 */
public class WaitUtility {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final int DEFAULT_TIMEOUT = 20;

    public WaitUtility(WebDriver driver) {
        this.driver = driver;
        // Selenium 4 fix: Duration.ofSeconds() instead of raw int (Question 20 Problem 4)
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    public WaitUtility(WebDriver driver, int timeoutSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }

    /**
     * Waits until element is clickable.
     */
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits until element is visible.
     */
    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits until element is present in DOM (may not be visible).
     */
    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Waits until an alert is present.
     */
    public Alert waitForAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Waits until a frame is available and switches to it.
     */
    public WebDriver waitForFrame(String frameNameOrId) {
        return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
    }

    public WebDriver waitForFrame(WebElement frameElement) {
        return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }

    /**
     * Waits until element is invisible.
     */
    public boolean waitForInvisibility(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Waits until page title contains given text.
     */
    public boolean waitForTitleContains(String title) {
        return wait.until(ExpectedConditions.titleContains(title));
    }

    /**
     * Waits until URL contains given text.
     */
    public boolean waitForUrlContains(String url) {
        return wait.until(ExpectedConditions.urlContains(url));
    }

    /**
     * Waits until text is present in element.
     */
    public boolean waitForTextPresent(By locator, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
}
