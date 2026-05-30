package hooks;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class HooksAssign {

    public static WebDriver driver;

    @BeforeAll
    public static void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/");
    }

    @After
    public void screenshot(Scenario scenario) {

        if (scenario.isFailed()) {

            TakesScreenshot ts =
                    (TakesScreenshot) driver;

            byte[] img =
                    ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(
                    img,
                    "image/png",
                    "Failure Screenshot");
        }
    }

    @AfterAll
    public static void closeBrowser() {

        driver.quit();
    }
}