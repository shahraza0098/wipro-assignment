package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import utilities.WaitUtil;

public class CustomerPage {

WebDriver driver;
	
	public CustomerPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By newCustBtn=By.linkText("New Customer");
	
	By custName=By.name("name");
	
	By  date=By.id("dob");
	
	By address= By.name("addr");
	
	By city=By.name("city");
	
	By state=By.name("state");
	
	By pinCode=By.name("pinno");
	
	By mobNum=By.name("telephoneno");
	
	By email= By.name("emailid");
	
	By password=By.name("password");
	
	By subBtn=By.name("sub");
	
	
	 By customerId = By.xpath("//td[text()='Customer ID']/following-sibling::td");
	
	
	
	
	
	
	 public void navigateToNewCustomer() {

		    ((JavascriptExecutor) driver)
		            .executeScript("window.scrollTo(0,0)");

		    WaitUtil waitUtil = new WaitUtil(driver);

		    WebElement button =
		            waitUtil.waitForElementClickable(newCustBtn);

		    button.click();
		}
	
	public void enterCustomerName(String customerName) {
		driver.findElement(custName).sendKeys(customerName);
	}
	
	
	public void enterDOB(String DOB) {
		driver.findElement(date).sendKeys(DOB);
	}
	
	public void enterAddress(String add) {
		driver.findElement(address).sendKeys(add);
	}
	public void enterCity(String c) {
		driver.findElement(city).sendKeys(c);
		
	}
	
	public void enterState(String st) {
		driver.findElement(state).sendKeys(st);
	}
	
	public void enterPin(String pin) {
		driver.findElement(pinCode).sendKeys(pin);
	}
	
	public void enterPhone(String phone) {
		driver.findElement(mobNum).sendKeys(phone);
	}
	
	public void enterEmail(String e) {
		driver.findElement(email).sendKeys(e);
	}
	
	public void enterPass(String pass1) {
		driver.findElement(password).sendKeys(pass1);
	}
	
	public void submitCustomer() {
		driver.findElement(subBtn).click();
	}
	
	public void createNewCustomer(
	        String name,
	        String dob,
	        String addr,
	        String cityName,
	        String stateName,
	        String pin,
	        String phone,
	        String emailId,
	        String pass) {

	    enterCustomerName(name);
	    enterDOB(dob);
	    enterAddress(addr);
	    enterCity(cityName);
	    enterState(stateName);
	    enterPin(pin);
	    enterPhone(phone);
	    enterEmail(emailId);
	    enterPass(pass);

	    submitCustomer();
	}
	
	public String getCustomerId() {
	    return driver.findElement(customerId).getText();
	}
	
	
	
	
	
	
	
	
	//Edit customer:
	
	
	By editCustomerLink =
	        By.linkText("Edit Customer");

	By editCustomerId =
	        By.name("cusid");

	By submitBtn =
	        By.name("AccSubmit");

	By editAddress =
	        By.name("addr");

	By editCity =
	        By.name("city");

	By editState =
	        By.name("state");

	By submitEdit =
	        By.name("sub");
	
	 
	
	
	//edit customer methods
	
	
	public void navigateToEditCustomer() {

	    ((JavascriptExecutor) driver)
	            .executeScript("window.scrollTo(0,0)");

	    WaitUtil waitUtil = new WaitUtil(driver);

	    WebElement button =
	            waitUtil.waitForElementClickable(editCustomerLink);

	    button.click();
	}

	
	public void editCustomer(
	        String custId,
	        String newAddress,
	        String newCity,
	        String newState){

		navigateToEditCustomer();

	    driver.findElement(editCustomerId)
	            .sendKeys(custId);

	    driver.findElement(submitBtn)
	            .click();

	    WebElement addr =
	            driver.findElement(address);

	    addr.clear();

	    addr.sendKeys(newAddress);

	    driver.findElement(city).clear();
	    driver.findElement(city)
	            .sendKeys(newCity);

	    driver.findElement(state).clear();
	    driver.findElement(state)
	            .sendKeys(newState);

	    driver.findElement(submitEdit)
	            .click();
	}
	
	

	//delete customer
	

	By deleteCustomerLink = By.linkText("Delete Customer");
	
	By delCustId=By.name("cusid");
	By delSubmitBtn=By.name("AccSubmit");
	
	public void navigateToDeleteCustomer() {

	    ((JavascriptExecutor) driver)
	            .executeScript("window.scrollTo(0,0)");

	    WaitUtil waitUtil = new WaitUtil(driver);

	    WebElement button =
	            waitUtil.waitForElementClickable(deleteCustomerLink);

	    button.click();
	}
	
	public void acceptDeleteAlert() {
		 Alert alert = WaitUtil.waitForAlert(driver);

	        String alertText = alert.getText();

	        System.out.println("Alert Message: " + alertText);

	        Assert.assertTrue( alertText.contains("Do you really want to delete this Customer?"),
	                "Unexpected alert message");

	        alert.accept();
	}
	
	public void deleteCustomer(String custId) {
		navigateToDeleteCustomer();
		driver.findElement(delCustId).sendKeys(custId);
		driver.findElement(delSubmitBtn).click();
		
	}
	
}
