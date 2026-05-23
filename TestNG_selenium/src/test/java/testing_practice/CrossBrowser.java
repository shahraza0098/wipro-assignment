package testing_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class CrossBrowser {
	
	WebDriver driver;
	 WebDriverWait wait ;
	  JavascriptExecutor js;
	  
	  
	  
//	  @BeforeTest
//	  public void beforeTest() {
//	  }
  @Test
  public void chromeTest() {
	  driver = new ChromeDriver();
		 
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

     wait= new WebDriverWait(driver, Duration.ofSeconds(10));

     driver.get("https://www.selenium.dev/");
  }
  
  @Test
  public void edgeDriver() {
	  driver = new EdgeDriver();
		 
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

     wait= new WebDriverWait(driver, Duration.ofSeconds(10));

     driver.get("https://www.selenium.dev/");
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }

}
