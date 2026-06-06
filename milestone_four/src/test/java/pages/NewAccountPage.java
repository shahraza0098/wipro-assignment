package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountPage {

	
    WebDriver driver;
	
	
	public NewAccountPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By newAccountBtnNav=By.linkText("New Account");
	 By cusID=By.name("cusid");
	 
	 By accType=By.name("selaccount");
	 By initDep=By.name("inideposit");
	 By newAccBtn=By.name("button2");
	 
	 private By successMessage = By.xpath("//p[@class='heading3']");
	
	 
	 public void navigateToNewAccount() {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		    
		    WebElement newAccountLink = wait.until(
		        ExpectedConditions.elementToBeClickable(
		            By.linkText("New Account")
		        )
		    );
		    
		    // Scroll into view, then JS click to bypass any overlay
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", newAccountLink);
		    js.executeScript("arguments[0].click();", newAccountLink);
		}
	 
	 
	 public void enterCustomerId(String id) {
		 driver.findElement(cusID).sendKeys(id);
	 }
	 
	 
	 public void selectAccountType(String accountType) {
		    Select select = new Select(driver.findElement(accType));
		    select.selectByVisibleText(accountType);
		}
	 
	 
	  public void enterInitialDeposit(String depAmount) {
		  driver.findElement(initDep).sendKeys(depAmount);
	  }
	  public void submitAccount() {
		  driver.findElement(newAccBtn).click();
	  }
	  
	  public void createAccount(
		        String customerId,
		        String accountType,
		        String deposit) {

		    enterCustomerId(customerId);
		    selectAccountType(accountType);
		    enterInitialDeposit(deposit);
		    submitAccount();
		}
	  
	  public boolean verifyAccountCreated() {

		    String actual = driver.findElement(successMessage).getText();

		    return actual.contains("Account Generated Successfully");
		}
}
