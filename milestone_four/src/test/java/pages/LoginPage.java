package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	private By username=By.name("uid");
	private By password=By.name("password");
	
	private By loginbtn=By.name("btnLogin");
	
	private By welcomeMessage=By.xpath("//marquee[@class='heading3']");
	
	public void enterUsername(String user1) {
		
		
		 driver.findElement(username).sendKeys(user1);
		 
		
		 
		 
		
	}
	
	
	public void enterPassword(String pass) {
		 driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLogin()
	{
		driver.findElement(loginbtn).click();
	}
	
	public void loginToApplication(String user, String pass) {
	    enterUsername(user);
	    enterPassword(pass);
	    clickLogin();
	}
	
	
	  public boolean isLoginSuccessful() {
	        return driver.findElement(welcomeMessage)
	                .getText()
	                .equals("Welcome To Manager's Page of Guru99 Bank");
	    }
}
