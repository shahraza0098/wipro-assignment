package testing_practice;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class ExceldataPract {
	
	
	WebDriver driver;
	 WebDriverWait wait ;
	
	  @BeforeTest
	  public void beforeTest() {
		  driver = new ChromeDriver();
			 
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	     wait= new WebDriverWait(driver, Duration.ofSeconds(10));

	     driver.get("https://demowebshop.tricentis.com/login");
	  }
	  
	  @DataProvider(name = "loginData")
	    public Object[][] getData() throws IOException {

	        // Excel file path
		  FileInputStream fis = new FileInputStream(
				  "C:\\Users\\shahr\\eclipse-workspace\\wipro-assignment\\TestNG_selenium\\testData\\loginData.xlsx");

	        XSSFWorkbook workbook = new XSSFWorkbook(fis);

	        XSSFSheet sheet = workbook.getSheet("Sheet1");

	        int rows = sheet.getPhysicalNumberOfRows();
	        int cols = sheet.getRow(0).getLastCellNum();

	        Object[][] data = new Object[rows - 1][cols];

	        // Read data from Excel
	        for (int i = 1; i < rows; i++) {

	            for (int j = 0; j < cols; j++) {

	                data[i - 1][j] = sheet
	                        .getRow(i)
	                        .getCell(j)
	                        .toString();
	            }
	        }

	        workbook.close();
	        fis.close();

	        return data;
	    }
	  
	  
	  
	  @Test(dataProvider = "loginData")
	    public void loginTest(String user1, String pass1) throws InterruptedException {

	        System.out.println("Username: " + user1);
	        System.out.println("Password: " + pass1);

//	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log in"))).click();
			  Thread.sleep(1000);
	       
	        WebElement email=driver.findElement(By.id("Email"));
	        
	        email.sendKeys(user1);
	              

	        WebElement pass= driver.findElement(By.id("Password"));
	        
	        pass.sendKeys(pass1);
	        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"))
	              .click();
	        
	        email.clear();
	        pass.clear();
	        
	       
	    }

 


  @AfterTest
  public void afterTest() {
  }

}
