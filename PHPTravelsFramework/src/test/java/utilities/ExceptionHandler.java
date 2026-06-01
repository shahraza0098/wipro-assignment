package utilities;

import base.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Supplier;

/**
 * Question 14 – Exception Handling Framework
 * Handles common Selenium exceptions gracefully.
 * Provides retry logic for StaleElementReferenceException.
 * Ensures execution continues where possible.
 */
public class ExceptionHandler {

    private static final int MAX_RETRY = 3;
    private static final int WAIT_TIMEOUT = 10;

    /**
     * Safely clicks an element with retry on StaleElementReferenceException.
     */
    public static void safeClick(By locator) {
        int attempt = 0;
        while (attempt < MAX_RETRY) {
            try {
                WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT));
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                return; // Success
            } catch (StaleElementReferenceException e) {
                attempt++;
                System.out.println("StaleElementReferenceException caught. Retrying click... Attempt: " + attempt);
                if (attempt == MAX_RETRY) {
                    throw new RuntimeException("Max retry reached for StaleElementReferenceException on: " + locator, e);
                }
            } catch (ElementClickInterceptedException e) {
                // Scroll and retry using JavaScript
                System.out.println("ElementClickInterceptedException – using JS click.");
                try {
                    WebElement el = DriverFactory.getDriver().findElement(locator);
                    ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].click();", el);
                    return;
                } catch (Exception jsEx) {
                    throw new RuntimeException("JS click also failed: " + jsEx.getMessage(), jsEx);
                }
            } catch (NoSuchElementException e) {
                System.err.println("NoSuchElementException: Element not found – " + locator);
                throw new RuntimeException("Element not found: " + locator, e);
            } catch (TimeoutException e) {
                System.err.println("TimeoutException: Element not clickable within timeout – " + locator);
                throw new RuntimeException("Timeout waiting for element: " + locator, e);
            }
        }
    }

    /**
     * Safely gets text from an element with retry on StaleElementReferenceException.
     */
    public static String safeGetText(By locator) {
        int attempt = 0;
        while (attempt < MAX_RETRY) {
            try {
                WebElement element = DriverFactory.getDriver().findElement(locator);
                return element.getText().trim();
            } catch (StaleElementReferenceException e) {
                attempt++;
                System.out.println("StaleElementReferenceException on getText. Retry " + attempt);
            } catch (NoSuchElementException e) {
                System.err.println("NoSuchElementException: " + locator);
                return "";
            }
        }
        return "";
    }

    /**
     * Safely sends keys with retry on StaleElementReferenceException.
     */
    public static void safeSendKeys(By locator, String text) {
        int attempt = 0;
        while (attempt < MAX_RETRY) {
            try {
                WebElement element = DriverFactory.getDriver().findElement(locator);
                element.clear();
                element.sendKeys(text);
                return;
            } catch (StaleElementReferenceException e) {
                attempt++;
                System.out.println("StaleElementReferenceException on sendKeys. Retry " + attempt);
            } catch (NoSuchElementException e) {
                System.err.println("NoSuchElementException: " + locator);
                return;
            } catch (ElementNotInteractableException e) {
                System.err.println("ElementNotInteractableException: " + locator);
                // Try via JavaScript
                try {
                    WebElement el = DriverFactory.getDriver().findElement(locator);
                    ((JavascriptExecutor) DriverFactory.getDriver())
                        .executeScript("arguments[0].value='" + text + "';", el);
                    return;
                } catch (Exception ex) {
                    System.err.println("JS setValue also failed: " + ex.getMessage());
                }
            }
        }
    }

    /**
     * Generic retry wrapper for any Supplier action.
     * Continues execution and returns null on repeated failure.
     */
    public static <T> T retryOnException(Supplier<T> action, String actionDescription) {
        int attempt = 0;
        while (attempt < MAX_RETRY) {
            try {
                return action.get();
            } catch (StaleElementReferenceException e) {
                attempt++;
                System.out.println("Stale element in [" + actionDescription + "]. Retry " + attempt);
            } catch (Exception e) {
                System.err.println("Exception in [" + actionDescription + "]: " + e.getMessage());
                return null; // Continue execution (Question 14 requirement)
            }
        }
        System.err.println("Action [" + actionDescription + "] failed after " + MAX_RETRY + " retries.");
        return null;
    }

    /**
     * Checks if an element is present without throwing exception.
     */
    public static boolean isElementPresent(By locator) {
        try {
            return !DriverFactory.getDriver().findElements(locator).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
}
