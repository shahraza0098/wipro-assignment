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
 
public class Tira_beauty {
	
	WebDriver driver;
	 WebDriverWait wait ;
	  JavascriptExecutor js;
	
	
	
  @BeforeTest
   public void beforeTest() {
	  driver = new ChromeDriver();
		 
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

     wait= new WebDriverWait(driver, Duration.ofSeconds(10));

     driver.get("https://www.tirabeauty.com/");
  
  }
//  @Test
//  public void registration() {
//	  driver.navigate().to("https://www.tirabeauty.com/auth/login?redirectUrl=%252F");
//	  WebElement phoneInput=driver.findElement(By.id("mobile-number-input"));
//	  phoneInput.sendKeys("6202991257");
//	  
//	  driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/svg/g/rect[1]")).click();
//	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"main-content\\\"]/div[2]/div[2]/div/div/div/div[2]/button"))).click();
//  }
//  @Test
//  public void login() {
//	  driver.navigate().to("https://www.tirabeauty.com/auth/login?redirectUrl=%252F");
//	  WebElement phoneInput=driver.findElement(By.id("mobile-number-input"));
//	  phoneInput.sendKeys("6202991257");
//	  
//	  driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/svg/g/rect[1]")).click();
//	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"main-content\\\"]/div[2]/div[2]/div/div/div/div[2]/button"))).click();
//  
//  
//  }
  @Test
  public void multiple_search() {
	  //beauty product
	  //lipstick
	  //lip balm
	  driver.navigate().to("https://www.tirabeauty.com/");
	  WebElement searchBar= driver.findElement(By.id("search"));
	  searchBar.sendKeys("beauty product");
      searchBar.sendKeys(Keys.ENTER);
      
      driver.navigate().back();
      searchBar.sendKeys("lipstick");
      searchBar.sendKeys(Keys.ENTER);
	  
      
      driver.navigate().back();
      searchBar.sendKeys("lip balm");
      searchBar.sendKeys(Keys.ENTER);
  }
  @Test
  public void add_to_cart() {
	  
driver.navigate().to("https://www.tirabeauty.com/products/?q=lip%20balm");
driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[4]/div[2]/div[2]/div[1]/div/div[1]/a/div/div[3]/div/div[2]/button")).click();
  }
  @Test
  public void product_details() {
	  driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[4]/div[2]/div[2]/div[1]/div/div[1]/a/div/div[1]/div[1]/div[3]/picture/img")).click();
  }
  @Test
  public void delete_cart_item() {
  }
  @Test
  public void change_Address() {
  }
  @Test
  public void Change_name() {
  }
 
  @AfterTest
  public void afterTest() {
	  System.out.println("succesfully");
  }
 
}