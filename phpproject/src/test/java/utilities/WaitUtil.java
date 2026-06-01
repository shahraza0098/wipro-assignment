package utilities;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitUtil {

    public static WebElement waitForVisible(
            WebDriver driver,
            By locator) {

        return new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions
                .visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(
            WebDriver driver,
            By locator) {

        return new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions
                .elementToBeClickable(locator));
    }

    public static Alert waitForAlert(
            WebDriver driver) {

        return new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions
                .alertIsPresent());
    }
}