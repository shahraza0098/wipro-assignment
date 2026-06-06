package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public WebDriver driver;
	
	

	@BeforeTest
	public void setup() throws InterruptedException {
	
		 
//		driver= new ChromeDriver();
//		
////		driver.get("https://demo.guru99.com/");
//		 driver.get("https://demo.guru99.com/V4/");
//		driver.manage().window().maximize();
//		Thread.sleep(2000);
//		
		
		 System.out.println("Creating Driver");

		    driver = new ChromeDriver();

		    System.out.println("Driver Created");

		    driver.get("https://demo.guru99.com/V4/");

		    System.out.println("URL Opened");

		    driver.manage().window().maximize();

		    System.out.println("Window Maximized");
		
	}

	@AfterTest
	public void tearDown() {
//		driver.close();
		System.out.println("close");
	}
}
