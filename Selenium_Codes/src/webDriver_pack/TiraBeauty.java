package webDriver_pack;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TiraBeauty {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		   WebDriver driver = new ChromeDriver();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		      driver.manage().window().maximize();

	        driver.get("https://www.tirabeauty.com/");

	        Thread.sleep(2000);

	        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[5]/div/a")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//*[@id=\"profile-builder\"]/div/div/div[1]/div/div[3]/button")).click();
	      
//	        driver.findElement(By.id("search")).sendKeys("face wash");
//
//	        driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
	        Thread.sleep(2000);
	        driver.findElement(By.id("mobile-number-input")).sendKeys("6202991257");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/svg/g/rect[2]")).click();
	        
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div[2]/div/div/div/div[2]/button")).click();
	        Thread.sleep(20000);
	        
	        //take a quiz
	        driver.findElement(By.xpath("//*[@id=\"profile-builder\"]/div/div[2]/div[2]/div[2]/div/div[1]/button")).click();
	        Thread.sleep(2000);
	        //1st question
	        driver.findElement(By.xpath("//*[@id=\"profile-builder\"]/div/div[2]/div[2]/div[2]/div/div/div/div[4]/div[3]/div/div[1]/span")).click();
	        Thread.sleep(2000);
	        //next btn
	        driver.findElement(By.xpath("//*[@id=\"profile-builder\"]/div/div[2]/div[2]/div[3]/div/div[2]/button")).click();
	        
	        
	        
	        //2nd quest
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"profile-builder\"]/div/div[2]/div[2]/div[2]/div/div/div/div[4]/div[1]/div/div[1]/span")).click();
	        Thread.sleep(2000);
	        //next btn
	        driver.findElement(By.xpath("//*[@id=\"profile-builder\"]/div/div[2]/div[2]/div[3]/div/div/button[2]")).click();
	        
	        //3rd question
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"profile-builder\"]/div/div[2]/div[2]/div[2]/div/div/div/div[4]/div[1]/div/div[1]/span")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"profile-builder\"]/div/div[2]/div[2]/div[3]/div/div[2]/button[2]")).click();
	        
	        //4th question
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"profile-builder\"]/div/div[2]/div[2]/div[2]/div/div/div/div[4]/div[1]/div/div[1]/span")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"profile-builder\"]/div/div[2]/div[2]/div[3]/div/div/button[2]")).click();
	        
	        //5th question
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"profile-builder\"]/div/div[2]/div[2]/div[2]/div/div/div/div[4]/div[1]/div/div[1]/span")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"profile-builder\"]/div/div[2]/div[2]/div[3]/div/div/button[2]")).click();
	        
	        Thread.sleep(2000);
	        
	        //submit btn
	        driver.findElement(By.xpath("//*[@id=\"profile-builder\"]/div/div[2]/div[2]/div[3]/div/div/button[2]")).click();
	        Thread.sleep(2000);
//	        driver.close();

	}

}
