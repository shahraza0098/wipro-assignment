package testing_practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AssertPrac {
	WebDriver driver;
	 WebDriverWait wait ;
	  JavascriptExecutor js;
	  
	  @BeforeTest
	  public void beforeTest() {

			 driver = new ChromeDriver();
			 
		      driver.manage().window().maximize();
		      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		     wait= new WebDriverWait(driver, Duration.ofSeconds(10));

		     driver.get("https://www.selenium.dev/");
	  }
	
  @Test
  public void titleValidation() {
	  
// hard assert
//	    String expectedTitle = "Selenium";
//	    String actualTitle = driver.getTitle();
//	    
//	    Assert.assertEquals(actualTitle, expectedTitle);
//	    
//	    
	    
	    //soft assert
	    
	    SoftAssert soft = new SoftAssert();

	    String expectedTitle = "Selenium dev";
	    String actualTitle = driver.getTitle();

	    soft.assertEquals(actualTitle, expectedTitle,
	            "Title validation failed");

	    String expectedUrl = "https://www.selenium.dev/";
	    String actualUrl = driver.getCurrentUrl();

	    soft.assertEquals(actualUrl, expectedUrl,
	            "URL validation failed");

  }
  
  

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
