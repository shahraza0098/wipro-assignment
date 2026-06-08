package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public WebDriver driver;
	
	

	@BeforeMethod
	public void setup() throws InterruptedException {
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--headless=new");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("--disable-gpu");
	    options.addArguments("--window-size=1920,1080");

	    System.out.println("Creating Driver");
	    driver = new ChromeDriver(options);
//	    driver = new ChromeDriver();
	    System.out.println("Driver Created");
	    driver.get("https://demo.guru99.com/V4/");
	    System.out.println("URL Opened");
	    
	    driver.manage().window().maximize();
        System.out.println("Window Maximized");
	}

	
	@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // use quit() not close()
        }
        System.out.println("Driver closed");
    }
}




//new code which doesnot requires chrome to download: 

//
//package base;
//
//import java.net.URL;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//public class BaseTest {
//
//    public WebDriver driver;
//
//    @BeforeMethod
//    public void setup() throws Exception {
//
//    	ChromeOptions options = new ChromeOptions();
//
//    	options.addArguments("--headless=new");
//    	options.addArguments("--no-sandbox");
//    	options.addArguments("--disable-dev-shm-usage");
//    	options.addArguments("--disable-gpu");
//    	options.addArguments("--window-size=1920,1080");
//
//    	driver = new RemoteWebDriver(
//    	        new URL("http://selenium:4444"),
//    	        options);
//        driver.get("https://demo.guru99.com/V4/");
//    }
//
//    @AfterMethod
//    public void tearDown() {
//
//        if(driver != null) {
//            driver.quit();
//        }
//    }
//}