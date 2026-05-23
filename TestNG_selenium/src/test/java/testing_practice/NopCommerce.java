package testing_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class NopCommerce {
	
	
	WebDriver driver;
	 WebDriverWait wait ;
	  JavascriptExecutor js;
	
	
	
	@BeforeTest(alwaysRun=true)
	   public void beforeTest() {
	   
		 driver = new ChromeDriver();
		 
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	     wait= new WebDriverWait(driver, Duration.ofSeconds(10));

	     driver.get("https://demowebshop.tricentis.com/");
	
	}
	  @Test(groups="regression")
	  public void registration() throws InterruptedException {
		  
		  Thread.sleep(2000);
		  driver.findElement(By.linkText("Register")).click();
		  
//		  driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
		  driver.findElement(By.id("gender-male")).click();
		  driver.findElement(By.id("FirstName")).sendKeys("Shahid");
		  driver.findElement(By.id("LastName")).sendKeys("Raza");
		  
		  driver.findElement(By.id("Email")).sendKeys("srsh12@gmail.com");
		  
//		  driver.findElement(By.id("Company")).sendKeys("Wipro");
		  driver.findElement(By.id("Password")).sendKeys("shahid123");
		  driver.findElement(By.id("ConfirmPassword")).sendKeys("shahid123");
		  
		  
		  driver.findElement(By.id("register-button")).click();
		  
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input"))).click();
		  
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out"))).click();
		  
//		  
//		  Thread.sleep(10000);
//		  driver.findElement(By.xpath("//*[@id=\"Oahti6\"]/div/label/input")).click();
	  }
	  @Test(dependsOnMethods="registration",groups="regression")
	  public void login() throws InterruptedException {
		  
		  
		  
		  
		
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log in"))).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("Email")).sendKeys("srhshaah12@gmail.com");
		
		  driver.findElement(By.id("Password")).sendKeys("shahid123");
		  Thread.sleep(1000);
		
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"))).click();
		  
		  
//		  Thread.sleep(10000);
//		  driver.findElement(By.xpath("//*[@id=\"Oahti6\"]/div/label/input")).click();
		  
	  }
	  @Test(priority = 1,groups="smoke")
	  public void multiple_search() throws InterruptedException {
		  //beauty product
		  //lipstick
		  //lip balm
		  
		  
		  WebElement search=driver.findElement(By.id("small-searchterms"));
		  search.sendKeys("laptop");
		  search.sendKeys(Keys.ENTER);
	
		  
		  Thread.sleep(2000);
		  driver.navigate().back();
		  search.sendKeys(Keys.CONTROL, "a");
		  search.sendKeys(Keys.BACK_SPACE);
		  search.sendKeys("gift");
		  search.sendKeys(Keys.ENTER);
		  
		  Thread.sleep(2000);
		  driver.navigate().back();
		  search.sendKeys(Keys.CONTROL, "a");
		  search.sendKeys(Keys.BACK_SPACE);
		  
		  search.sendKeys("camera");
		  search.sendKeys(Keys.ENTER);
		  
		  
	  }
	  @Test(priority = 2,groups="smoke")
	  public void add_to_cart() throws InterruptedException {
		  
		  driver.navigate().to("https://demowebshop.tricentis.com/search?q=gift");
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]/div[3]/div[2]/input")).click();
		  driver.findElement(By.id("giftcard_4_RecipientName")).sendKeys("xyz");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button-4"))).click();
		  
	  }
	  @Test(priority = 3,groups="smoke")
	  public void product_details() {
		  driver.navigate().to("https://demowebshop.tricentis.com/");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[1]/a/img"))).click();
		  
	  }
	  @Test(priority = 4,groups="smoke")
	  public void delete_cart_item() throws InterruptedException {
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topcartlink"))).click();
		 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[1]/input"))).click();
		  Thread.sleep(2000);
		  
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[1]/div/input[1]"))).click();
	  }
//	  @Test(priority = 5)
//	  public void change_Address() {
//	  }
	  @Test(priority = 5,groups="smoke")
	  public void Change_name() {
		  driver.navigate().to("https://demowebshop.tricentis.com/");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/customer/info' and @class='account']"))).click();
		//a[@class='account']
		  
//		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName"))).click();
		  WebElement firtName=driver.findElement(By.id("FirstName"));
		  firtName.sendKeys(Keys.CONTROL, "a");
		  firtName.sendKeys(Keys.BACK_SPACE);
		  
		  firtName.sendKeys("new");
		  
		  
		  WebElement LastName=driver.findElement(By.id("LastName"));
		  
		  LastName.sendKeys(Keys.CONTROL, "a");
		  LastName.sendKeys(Keys.BACK_SPACE);
		  
		  LastName.sendKeys("name changed");
		  
		  //save name change
//		  driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/form/div[3]/input")).click();
		  
	  }
	 
	  @AfterTest
	  public void afterTest() throws InterruptedException {
		  Thread.sleep(8000);
		  driver.quit();
	  }
}
