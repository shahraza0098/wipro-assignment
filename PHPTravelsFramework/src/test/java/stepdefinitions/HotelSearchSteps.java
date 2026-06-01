package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.HotelSearchPage;
import pages.LoginPage;
import pages.BookingPage;
import reports.ExtentReportManager;

import java.util.List;
import java.util.Map;

/**
 * Step definitions for Hotel Search (Question 3), Price Validation (Question 4),
 * and Complete Booking Workflow (Question 5).
 */
public class HotelSearchSteps {

    private HotelSearchPage hotelSearchPage;
    private BookingPage bookingPage;
    private LoginPage loginPage;
    private Map<String, Double> hotelPrices;
    private SoftAssert softAssert = new SoftAssert();

    // ========================
    // Hotel Search Steps (Question 3)
    // ========================

    @Given("user is on the hotel search page")
    public void user_is_on_hotel_search_page() {
        hotelSearchPage = new HotelSearchPage();
        hotelSearchPage.navigateToHotels();
        ExtentReportManager.getTest().info("Navigated to Hotel Search page.");
    }

    @When("user enters destination {string}")
    public void user_enters_destination(String destination) {
        hotelSearchPage.enterDestination(destination);
        ExtentReportManager.getTest().info("Entered destination: " + destination);
    }

    @And("user selects check-in date {string} and check-out date {string}")
    public void user_selects_dates(String checkIn, String checkOut) {
        hotelSearchPage.setCheckInDate(checkIn);
        hotelSearchPage.setCheckOutDate(checkOut);
        ExtentReportManager.getTest().info("Check-in: " + checkIn + " | Check-out: " + checkOut);
    }

    @And("user selects {int} travellers")
    public void user_selects_travellers(int count) {
        hotelSearchPage.selectTravellersCount(count);
        ExtentReportManager.getTest().info("Travellers count: " + count);
    }

    @And("user clicks search button")
    public void user_clicks_search() {
        hotelSearchPage.clickSearch();
        ExtentReportManager.getTest().info("Search button clicked.");
    }

    @Then("hotel search results should be displayed")
    public void hotel_results_should_be_displayed() {
        boolean displayed = hotelSearchPage.areResultsDisplayed();
        Assert.assertTrue(displayed, "Hotel search results should be displayed.");
        ExtentReportManager.getTest().pass("Hotel results displayed successfully.");
    }

    @And("available hotels count should be greater than {int}")
    public void available_hotels_count_greater_than(int minCount) {
        int count = hotelSearchPage.getHotelCount();
        Assert.assertTrue(count > minCount,
            "Expected more than " + minCount + " hotels but found: " + count);
        ExtentReportManager.getTest().pass("Hotels found: " + count);
    }

    // ========================
    // Price Validation Steps (Question 4)
    // ========================

    @When("user fetches all hotel prices")
    public void user_fetches_all_hotel_prices() {
        hotelPrices = hotelSearchPage.getAllHotelPrices();
        ExtentReportManager.getTest().info("Total hotels with prices fetched: " + hotelPrices.size());
        for (Map.Entry<String, Double> entry : hotelPrices.entrySet()) {
            ExtentReportManager.getTest().info("Hotel: " + entry.getKey() + " | Price: " + entry.getValue());
        }
    }

    @Then("validate the highest hotel price")
    public void validate_highest_price() {
        double highest = hotelSearchPage.getHighestPrice(hotelPrices);
        Assert.assertTrue(highest > 0, "Highest price should be greater than 0");
        ExtentReportManager.getTest().pass("Highest Hotel Price: " + highest);
        System.out.println(">>> Highest Hotel Price: " + highest);
    }

    @Then("validate the lowest hotel price")
    public void validate_lowest_price() {
        double lowest = hotelSearchPage.getLowestPrice(hotelPrices);
        Assert.assertTrue(lowest > 0, "Lowest price should be greater than 0");
        ExtentReportManager.getTest().pass("Lowest Hotel Price: " + lowest);
        System.out.println(">>> Lowest Hotel Price: " + lowest);
    }

    @Then("validate the average hotel price")
    public void validate_average_price() {
        double average = hotelSearchPage.getAveragePrice(hotelPrices);
        Assert.assertTrue(average > 0, "Average price should be greater than 0");
        ExtentReportManager.getTest().pass("Average Hotel Price: " + average);
        System.out.println(">>> Average Hotel Price: " + average);
    }

    @Then("check for duplicate hotel names")
    public void check_for_duplicate_hotel_names() {
        List<String> duplicates = hotelSearchPage.getDuplicateHotelNames();
        if (duplicates.isEmpty()) {
            ExtentReportManager.getTest().pass("No duplicate hotel names found.");
        } else {
            ExtentReportManager.getTest().warning("Duplicate hotel names: " + duplicates.toString());
        }
        System.out.println("Duplicate Hotels: " + duplicates);
    }

    // ========================
    // Booking Workflow Steps (Question 5)
    // ========================

    @Given("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginPage = new LoginPage();
        loginPage.navigateToLogin();
        loginPage.login("user@phptravels.com", "demouser");
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login should be successful before booking.");
        ExtentReportManager.getTest().pass("User logged in successfully.");
    }

    @When("user selects a hotel to book")
    public void user_selects_a_hotel_to_book() {
        bookingPage = new BookingPage();
        bookingPage.selectFirstHotel();
        ExtentReportManager.getTest().info("First available hotel selected.");
    }

    @And("user enters traveller details")
    public void user_enters_traveller_details() {
        bookingPage.enterTravellerDetails(
            "Test", "User",
            "testbooking@phptravels.com",
            "9876543210",
            "India"
        );
        ExtentReportManager.getTest().info("Traveller details entered.");
    }

    @And("user confirms the booking")
    public void user_confirms_the_booking() {
        bookingPage.confirmBooking();
        ExtentReportManager.getTest().info("Booking confirmation clicked.");
    }

    @Then("booking confirmation message should be displayed")
    public void booking_confirmation_should_be_displayed() {
        // Question 15 – Hard Assert on booking confirmation
        Assert.assertTrue(bookingPage.isBookingConfirmed(),
            "Booking confirmation message should be displayed.");

        // Question 15 – Soft Assert on confirmation message text
        softAssert.assertTrue(
            bookingPage.getConfirmationMessage().length() > 0,
            "Confirmation message should not be empty"
        );
        softAssert.assertAll();

        ExtentReportManager.getTest().pass("Booking confirmed! Message: " + bookingPage.getConfirmationMessage());
    }

    @And("user logs out")
    public void user_logs_out() {
        bookingPage.logout();
        ExtentReportManager.getTest().info("User logged out successfully.");
    }
}
