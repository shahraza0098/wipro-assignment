package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.NewAccountPage;
import pages.NewCustomerPage;

public class CustomerOnboardingTest extends BaseTest {

	

	
    @Test
    public void createCustomerAndAccount() {
    	  System.out.println("Test Started");
        LoginPage loginPage =
                new LoginPage(driver);
        System.out.println("Test Started 2");
        NewCustomerPage customerPage =
                new NewCustomerPage(driver);

        NewAccountPage accountPage =
                new NewAccountPage(driver);

        // Login
        loginPage.loginToApplication(
                "mngr662531",
                "eguvenA");

        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Login Failed");

        // Create Customer
        customerPage.navigateToNewCustomer();

        customerPage.createNewCustomer(
                "Shahid",
                "01-01-2000",
                "Patna",
                "Patna",
                "Bihar",
                "800001",
                "9876593210",
                "shahffd1323@gmail.com",
                "test123");

        // Capture Customer ID
        String customerId =
                customerPage.getCustomerId();

        System.out.println(
                "Customer ID : " + customerId);

        // Create Account
        accountPage.navigateToNewAccount();

        accountPage.createAccount(
                customerId,
                "Savings",
                "5000");

        Assert.assertTrue(
                accountPage.verifyAccountCreated(),
                "Account Creation Failed");
    }
}