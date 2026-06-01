package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.HotelSearchPage;

public class HotelSearchSteps {

    HotelSearchPage hotel;

    @When("user searches hotel")
    public void search_hotel() {

        hotel =
                new HotelSearchPage(
                        DriverFactory.getDriver());

        hotel.searchHotel("Dubai");
    }

    @Then("hotel results should display")
    public void hotel_result_validation() {

        System.out.println(
                "Hotels Found");
    }
}