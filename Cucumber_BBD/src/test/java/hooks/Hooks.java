package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hooks {


    public static WebDriver driver;

    @BeforeAll
    public static void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://tutorialsninja.com/demo/");
    }

    @AfterAll
    public static void close() {

        driver.quit();
    }
}
