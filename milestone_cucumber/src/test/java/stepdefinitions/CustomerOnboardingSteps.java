package stepdefinitions;

import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.NewAccountPage;
import pages.NewCustomerPage;

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

    @When("User logs in with valid credentials")
    public void login() {

        loginPage.loginToApplication(
                "mngr662531",
                "eguvenA");

        Assert.assertTrue(
                loginPage.isLoginSuccessful());
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
                "abc66jf@gmail.com",
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