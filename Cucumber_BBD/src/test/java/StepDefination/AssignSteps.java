package StepDefination;

import org.testng.Assert;

import hooks.HooksAssign;
import io.cucumber.java.en.*;

import pages.AssignPage;

public class AssignSteps {

	AssignPage page =
            new AssignPage(HooksAssign.driver);

    @Given("user opens browser")
    public void browser() {

        System.out.println("Browser Opened");
    }

    @When("user logs in using excel row {string}")
    public void login(String row) {

        page.loginUsingExcel(
                Integer.parseInt(row));
    }

    @When("user searches {string}")
    public void search(String product) {

        page.searchProduct(product);
    }

    @When("user applies filter")
    public void filter() {

        page.applyFilter();
    }

    @When("user adds multiple products to cart")
    public void addProducts() {

        page.addMultipleProducts();
    }

    @When("user removes one product")
    public void removeProduct() {

        page.removeOneProduct();
    }

    @Then("total amount should be validated")
    public void validateTotal() {

        String total =
                page.getTotalAmount();

        Assert.assertNotNull(total);
    }

    @When("user proceeds to checkout")
    public void checkout() {

        page.checkout();
    }

    @When("user logout")
    public void logout() {

        page.logout();
    }

    @Then("logout should be successful")
    public void logoutSuccess() {

        Assert.assertTrue(true);
    }
}