package testing_practice;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class ValidateSearch {
	 WebDriver driver;
	 WebDriverWait wait ;
	 
	 
	 
		@BeforeTest
		   public void beforeTest() {
		   
			 driver = new ChromeDriver();
			 
		      driver.manage().window().maximize();
		      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		     wait= new WebDriverWait(driver, Duration.ofSeconds(10));

		     driver.get("https://www.flipkart.com/");
		
		}

	  @DataProvider
	  public Object[][] search() {
	    return new Object[][] {
	    	{"ipho 17"},
	    	{"143256"},
	    	{"Samsung"},
	    	{"Asus"},
	    	{"Lloyd 2025 Model 1 Ton 3 Star Split Inverter with Wi-fi Anti-Viral AC"},
	    	{"GWALBROS New White Bluetooth Earbuds, True Wireless"},
	    	{"laptop under 100000"},
	    	{"mobile phone rating 4.5 above"}
	    };
	  }
	
	
	
  @Test(dataProvider = "search")
  public void searching(String search) throws InterruptedException {
	  
		  
//		  driver = new ChromeDriver();
//		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
////		     wait= new WebDriverWait(driver, Duration.ofSeconds(10));
//		  
//	  driver.manage().window().maximize();
//
//
//	  driver.get("https://www.flipkart.com/");
	
	  WebElement searchbar=driver.findElement(By.cssSelector("input[name=\"q\"]"));
	  Assert.assertTrue(searchbar.isDisplayed(), "failed to display");
	  searchbar.sendKeys(search);
	  searchbar.sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	 
	  searchbar.clear();
  }

}
