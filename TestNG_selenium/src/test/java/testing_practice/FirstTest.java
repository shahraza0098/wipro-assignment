package testing_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class FirstTest {
	 WebDriver driver;
	 WebDriverWait wait ;
	  JavascriptExecutor js;
	
	 @BeforeTest
	 
		 
		 public void browsersetup() {
			 driver = new ChromeDriver();
	 
		      driver.manage().window().maximize();
		      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 
		     wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	 
		     driver.get("https://demoqa.com/alerts");
	  }

  @Test
  public void simpleAlert() throws InterruptedException {
	  
	// Simple Alert
			driver.findElement(By.id("alertButton")).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			
			
			
			
  }
  @Test
  public void conAlert() throws InterruptedException {
	  
	  //confirmation alert
	  driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
  }
  @Test
  public void promtAlert() throws InterruptedException {
	// Prompt Alert
			driver.findElement(By.id("promtButton")).click();

			Alert alert = driver.switchTo().alert();
			alert.sendKeys("Welcome");

			Thread.sleep(3000);

			alert.accept();
  }
	  
  
  
 
  @AfterTest
  public void afterTest() {
	  System.out.print("Successfully executed");  
	  driver.close();
  }

}
