package testing_practice;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class LoginValidation {
	 WebDriver driver;

	
	  @DataProvider(name="data")
	  public Object[][] dp1() {
		   return new Object[][] {

	            // valid username and password
	            {"username", "password"},

	            // invalid username and valid password
	            {"invalid", "password"},

	            // valid username and invalid password
	            {"username", "2345678"},

	            // invalid username and invalid password
	            {"invalid", "invalid"}
	        };
	  }
  @Test(dataProvider = "data")
  public void loginTest(String username1,
          String password1)
          throws InterruptedException {

driver = new ChromeDriver();

driver.manage().window().maximize();


driver.get("http://zero.webappsecurity.com/login.html");

WebElement user =
driver.findElement(By.id("user_login"));

user.sendKeys(username1);

WebElement pass =
driver.findElement(By.id("user_password"));

pass.sendKeys(password1);

driver.findElement(By.name("submit"))
.click();

Thread.sleep(3000);

// driver.close();
}


}
