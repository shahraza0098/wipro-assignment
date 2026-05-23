package webDriver_pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonDemoQA {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		/*
		 *  WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(15)); // maximum expected wait

    driver.get("https://www.amazon.in/");

    // first element = 2 sec + 5 sec = 7 sec actual wait
    // second element = 11 sec - 10 sec = 3 sec
    // third element = not found

    WebElement searchBox = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.id("twotabsearchtextbox")
            )
    );
		 */
		
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
	        driver.get("https://www.amazon.in/");
	        Thread.sleep(3000);
	       
	        //serach box
	        //twotabsearchtextbox
	        
	        WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(15));
	        
	        WebElement searchBar=driver.findElement(By.id("twotabsearchtextbox"));
	        
	        searchBar.click();
	        searchBar.sendKeys("laptop for gaming");
	        
	        
	        searchBar.sendKeys(Keys.ENTER);
	        
	        Thread.sleep(3000);
	      //*[@id="p_123/219979"]/span/a/div/label/i
	     
	        
//	        WebElement priceRange = wait.until(
//	                ExpectedConditions.visibilityOfElementLocated(
//	                        By.id("p_36/dynamic-picker-3")
//	                )
//	        );
	        
//	        priceRange.click();	        
	        
	        driver.findElement(By.xpath("//*[@id=\"p_123/219979\"]/span/a/div/label/i")).click();
	      
	        
	        //RAM selection
	        
	        
	        WebElement ram = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//*[@id=\\\"p_n_g-1003119721111/27399069031\\\"]/span/a/span")
	                )
	        );
	        ram.click();	        
//	        driver.findElement(By.xpath("//*[@id=\"p_36/dynamic-picker-3\"]/span/a/span")).click();
	        Thread.sleep(3000);
	 
	}

}
