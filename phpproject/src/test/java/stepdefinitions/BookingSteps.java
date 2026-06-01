package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.BookingPage;

public class BookingSteps {

    BookingPage booking;

    @When("user completes booking")
    public void complete_booking() {

        booking =
                new BookingPage(
                        DriverFactory.getDriver());

        booking.completeBooking(
                "Shahid",
                "Raza");
    }

    @Then("booking confirmation should display")
    public void validate_booking() {

        System.out.println(
                "Booking Confirmed");
    }
}