package webDriver_pack;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
public class DemoQA {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		 WebDriver driver = new ChromeDriver();
		 

	        driver.get("https://demoqa.com/automation-practice-form");
	     
	        

	        WebElement fname = driver.findElement(By.id("firstName"));
	  
	        fname.sendKeys("Shahid");

	        WebElement lname = driver.findElement(By.id("lastName"));

	        lname.sendKeys("Raza");
	        
	        //userEmail
	        WebElement email = driver.findElement(By.id("userEmail"));
	        email.sendKeys("shahraza@gmail.com");
	        driver.findElement(By.id("gender-radio-1")).click();
	        WebElement phone=driver.findElement(By.id("userNumber"));
	        phone.sendKeys("9811087150");
	        
	        
	        
	     // click on date of birth field
	        driver.findElement(By.id("dateOfBirthInput")).click();

	        WebElement yr = driver.findElement(By.className("react-datepicker__year-select"));

	        WebElement mt = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));

	        Select sel = new Select(yr);
	        sel.selectByIndex(100);

	        Select sel1 = new Select(mt);
	        sel1.selectByValue("4");

	        driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div[5]/div[4]")).click();
	        
	        //selecting subject
	        
	        WebElement sub= driver.findElement(By.id("subjectsInput"));
	        sub.click();
	        sub.sendKeys("Com");
	        sub.sendKeys(Keys.ENTER);
	        sub.sendKeys("Com");
	        sub.sendKeys(Keys.ARROW_DOWN);
	        sub.sendKeys(Keys.ENTER);
	        
	        
	        
//	        Thread.sleep(3000);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	       
	        js.executeScript("window.scrollBy(0,900)");
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        // Hobbies seelction
	        driver.findElement(By.id("hobbies-checkbox-1")).click();
	        driver.findElement(By.id("hobbies-checkbox-2")).click();
	        
	        //upload file
	        WebElement file=driver.findElement(By.id("uploadPicture"));
	        file.sendKeys("C:\\Users\\shahr\\Downloads\\defectsreport.pdf");
	        
	        driver.findElement(By.id("currentAddress")).sendKeys("India");
	        
	        //state and city
	        
	        WebElement state1 = driver.findElement(By.id("react-select-3-input"));
//	        Select stateSel = new Select(state1);
//	        stateSel.selectByValue("Rajasthan");
	        state1.sendKeys("Rajasthan");
	        state1.sendKeys(Keys.ENTER);
	        
	        //select city
	        
	        
	        
	        WebElement city1 = driver.findElement(By.id("react-select-4-input"));
	        city1.sendKeys("Jaipur");
	        city1.sendKeys(Keys.ENTER);
	        
	       
	        driver.findElement(By.id("submit")).click();
//	        js.executeScript("window.scrollBy(0,-800)");
	        TakesScreenshot tc = (TakesScreenshot) driver;

	        File sc = tc.getScreenshotAs(OutputType.FILE);

	        File dest = new File("DemoQAForm.png");

	        try {
				FileHandler.copy(sc, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	        Thread.sleep(3000);
	        driver.close();
	        driver.quit();


	}

}
