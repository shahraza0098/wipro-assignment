package testing_practice;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DataLogin {
	 WebDriver driver;
	 
	 
	  @BeforeTest
	  public void beforeTest() {
		  
		  
		   driver = new ChromeDriver();

		     driver.manage().window().maximize();

		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		     driver.get("https://demowebshop.tricentis.com/login");
	  }
  
	
	  @DataProvider
	  public Object[][] loginCred() {
	    return new Object[][] {
	    	{"admin","admin123"},
	    	{"user", "user123"},
	    	{"test", "test123"}
	    };
	  }
	  
	  
  @Test(dataProvider = "loginCred")
  public void f(String userId, String pass) {
	  driver.findElement(By.id("Email")).sendKeys(userId);
	  
	  driver.findElement(By.id("Password")).sendKeys(pass);
  }

 


  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
