package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
		 driver.findElement(newAccountBtnNav).click();
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
