package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.ExcelUtil;

public class LoginSteps {

    LoginPage login;

    @Given("user launches browser")
    public void user_launches_browser() {

        login = new LoginPage(
                DriverFactory.getDriver());
    }

    @When("user enters credentials from excel row {int}")
    public void user_enters_credentials_from_excel(int row) {

        String username =
                ExcelUtil.getCellData(
                        "Login",
                        row,
                        0);

        String password =
                ExcelUtil.getCellData(
                        "Login",
                        row,
                        1);

        System.out.println("Username : " + username);
        System.out.println("Password : " + password);

        login.enterEmail(username);
        login.enterPassword(password);
    }

    @And("clicks on login button")
    public void clicks_login_button() {

        login.clickLogin();
    }

    @Then("validate login result")
    public void validate_login() {

        System.out.println(
                "Validation Completed");
    }
}