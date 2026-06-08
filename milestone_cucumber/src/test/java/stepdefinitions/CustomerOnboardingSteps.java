package stepdefinitions;

import org.openqa.selenium.Alert;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.*;

import pages.LoginPage;
import pages.NewAccountPage;
import pages.NewCustomerPage;
import utils.WaitUtils;
import utils.RanEmail;

public class CustomerOnboardingSteps {

    LoginPage loginPage =
            new LoginPage(Hooks.driver);

    NewCustomerPage customerPage =
            new NewCustomerPage(Hooks.driver);

    NewAccountPage accountPage =
            new NewAccountPage(Hooks.driver);

    String customerId;

    @Given("User launches application")
    public void user_launches_application() {

    }

    @When("User logs in with valid credentials {string} and {string} and {string}")
    public void login(String username, String password, String status) {

        loginPage.loginToApplication(username, password);

        if(status.equalsIgnoreCase("valid")) {

          

        	Assert.assertTrue(
                    loginPage.isLoginSuccessful(), "login validation failed");

            System.out.println("Valid Login Passed");

        } else {

        	
        	 try {
        		 
        	

        		 Alert alert = WaitUtils.waitForAlert(Hooks.driver);

        	        String alertText = alert.getText();

        	        System.out.println("Alert Message: " + alertText);

        	        Assert.assertTrue(
        	                alertText.contains("User or Password is not valid"),
        	                "Unexpected alert message");

        	        alert.accept();
        	        return;

        	    } catch(Exception e) {

        	        Assert.fail("Expected alert not displayed");
        	    }
        }
        
    }

    @When("User navigates to New Customer page")
    public void navigate_customer() {

        customerPage.navigateToNewCustomer();
    }

    @When("User creates a new customer")
    public void create_customer() {

        customerPage.createNewCustomer(
                "Shahid",
                "01-01-2000",
                "Patna",
                "Patna",
                "Bihar",
                "800001",
                "9876543210",
                RanEmail.generateEmail(),
            
                "test123");
    }

    @When("User captures customer id")
    public void capture_customer_id() {

        customerId =
                customerPage.getCustomerId();

        System.out.println(customerId);
    }

    @When("User navigates to New Account page")
    public void navigate_account() {

        accountPage.navigateToNewAccount();
    }

    @When("User creates account using customer id")
    public void create_account() {

        accountPage.createAccount(
                customerId,
                "Savings",
                "5000");
    }

    @Then("Account should be created successfully")
    public void verify_account() {

        Assert.assertTrue(
                accountPage.verifyAccountCreated());
    }
}