package utilities;

import org.openqa.selenium.*;

public class ExceptionUtil {

    public static void clickWithRetry(
            WebElement element) {

        int attempts = 0;

        while(attempts < 3) {

            try {

                element.click();

                break;

            } catch(
                    StaleElementReferenceException e) {

                attempts++;
            }
        }
    }
}