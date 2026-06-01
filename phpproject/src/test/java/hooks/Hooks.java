package hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.LoginHelper;

public class Hooks {

    @Before
    public void setup() {

        BaseClass.launchBrowser();

        try {

            WebDriverWait wait =
                    new WebDriverWait(
                            DriverFactory.getDriver(),
                            Duration.ofSeconds(10));

            WebElement continueBtn =
                    wait.until(
                            ExpectedConditions.elementToBeClickable(
                                    By.id("acknowledgeDemoWarning")));

            continueBtn.click();

            System.out.println("Demo popup handled");

        } catch (Exception e) {

            System.out.println("Demo popup not displayed");
        }
    }
    @Before("@LoginRequired")
    public void loginBeforeScenario() {

        LoginHelper.login();
    }

    @After
    public void tearDown() {

        BaseClass.quitBrowser();
    }
}