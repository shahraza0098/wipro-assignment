package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.RegistrationPage;
import utilities.RandomUtil;

public class RegistrationSteps {

    RegistrationPage register;

    @Given("user opens registration page")
    public void open_registration_page() {

        register =
                new RegistrationPage(
                        DriverFactory.getDriver());
    }

    @When("user enters registration details")
    public void enter_registration_data() {

        register.register(
                "Shahid",
                "Raza",
                RandomUtil.generateEmail(),
                "Password123",
                "24");
    }

    @Then("account should be created")
    public void account_created() {

        System.out.println(
                "Registration Successful");
    }
}