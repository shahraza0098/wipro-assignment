package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {

    	 ChromeOptions options = new ChromeOptions();
 	    options.addArguments("--headless=new");
 	    options.addArguments("--no-sandbox");
 	    options.addArguments("--disable-dev-shm-usage");
 	    options.addArguments("--disable-gpu");
 	    options.addArguments("--window-size=1920,1080");

 	    System.out.println("Creating Driver");
 	    driver = new ChromeDriver(options);
// 	    driver = new ChromeDriver();
 	    System.out.println("Driver Created");
 	    driver.get("https://demo.guru99.com/V4/");
 	    System.out.println("URL Opened");
 	    
 	    driver.manage().window().maximize();
         System.out.println("Window Maximized");
    }

    @After
    public void tearDown() {

        if(driver != null)
            driver.quit();
    }
}