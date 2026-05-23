package webDriver_pack;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class TestAuto {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		 

        driver.get("https://testautomationpractice.blogspot.com/");

        //name field
        WebElement name =driver.findElement(By.id("name"));
        name.click();
        name.sendKeys("Shahid");
        
        
        WebElement email =driver.findElement(By.id("email"));
        email.click();
        email.sendKeys("shahraza@gmail.com");
        
        
        WebElement phone =driver.findElement(By.id("phone"));
        phone.click();
        phone.sendKeys("9043889014");
        
        
        
     
        WebElement address =driver.findElement(By.id("textarea"));
        address.click();
        address.sendKeys("New Delhi, India");
        
        //gender
        driver.findElement(By.id("male")).click(); 
        
        //days
        driver.findElement(By.id("sunday")).click();
        driver.findElement(By.id("monday")).click();
        
        //country
        WebElement country=driver.findElement(By.id("country"));
        Select con1 = new Select(country);
        con1.selectByValue("india");
        
        
        //colors
        
        WebElement colors=driver.findElement(By.id("colors"));
        Select colors1 = new Select(colors);
        colors1.selectByValue("red");
        
        //animals
        
        WebElement animals=driver.findElement(By.id("animals"));
        Select animals1 = new Select(animals);
        animals1.selectByValue("deer");
        
        
        
        //date picker 1
        
//        driver.findElement(By.id("dateOfBirthInput")).click();
//
//        WebElement yr = driver.findElement(By.className("react-datepicker__year-select"));
//
//        WebElement mt = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
//
//        Select sel = new Select(yr);
//        sel.selectByIndex(100);
//
//        Select sel1 = new Select(mt);
//        sel1.selectByValue("4");
//
//        driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div[5]/div[4]")).click();
//        
        
        WebElement date1=driver.findElement(By.id("datepicker"));
        date1.click();
        date1.sendKeys("06/05/2026");
        
        
        
        
        WebElement date2=driver.findElement(By.id("txtDate"));
        date2.click();
        date2.sendKeys("08/05/2022");
        
        
        //for date range 
        
  
        // start date
        WebElement startDate = driver.findElement(By.id("start-date"));
        startDate.sendKeys("15-05-2026");

        // end date
        WebElement endDate = driver.findElement(By.id("end-date"));
        endDate.sendKeys("12-05-2023");
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
	       
        js.executeScript("window.scrollBy(0,500)");
        
        driver.findElement(By.className("submit-btn")).click();        
        
        
        
        //upload file
        
//        file1
        WebElement file=driver.findElement(By.id("singleFileInput"));
        file.sendKeys("C:\\Users\\shahr\\Downloads\\defectsreport.pdf");
        
        driver.findElement(By.xpath("//*[@id=\"singleFileForm\"]/button")).click();
        
        //file2
        
//        
        WebElement file2=driver.findElement(By.id("multipleFilesInput"));
        file2.sendKeys("C:\\Users\\shahr\\Downloads\\Amazon_Test_Plans.pdf");
        driver.findElement(By.xpath("//*[@id=\"multipleFilesForm\"]/button")).click();
        
        
        
        
        //ss
        
        
        TakesScreenshot tc = (TakesScreenshot) driver;

        File sc = tc.getScreenshotAs(OutputType.FILE);

        File dest = new File("tAPss2.png");

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
