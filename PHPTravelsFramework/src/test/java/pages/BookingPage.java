package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Question 5 – Complete Booking Workflow Page Object
 * Handles: Hotel Selection → Booking Form → Confirmation
 */
public class BookingPage extends BasePage {

    // ========================
    // Web Elements
    // ========================

    @FindBy(xpath = "//a[contains(text(),'Book Now') or contains(@class,'book-now')] | //button[contains(text(),'Book')]")
    private WebElement bookNowButton;

    @FindBy(xpath = "//input[@name='first_name'] | //input[@id='first_name']")
    private WebElement travelerFirstName;

    @FindBy(xpath = "//input[@name='last_name'] | //input[@id='last_name']")
    private WebElement travelerLastName;

    @FindBy(xpath = "//input[@name='email'] | //input[@type='email']")
    private WebElement travelerEmail;

    @FindBy(xpath = "//input[@name='phone'] | //input[@id='phone']")
    private WebElement travelerPhone;

    @FindBy(xpath = "//select[@name='country'] | //select[@id='nationality']")
    private WebElement nationalityDropdown;

    @FindBy(xpath = "//button[@id='confirm'] | //button[contains(text(),'Confirm')] | //input[@value='Confirm Booking']")
    private WebElement confirmButton;

    @FindBy(xpath = "//div[contains(@class,'alert-success')] | //h3[contains(text(),'Booking Confirmed')] | //p[contains(text(),'confirmed')]")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//a[contains(@href,'logout')] | //button[contains(text(),'Logout')]")
    private WebElement logoutButton;

    // ========================
    // Actions
    // ========================

    /**
     * Selects the first available hotel from search results.
     */
    public BookingPage selectFirstHotel() {
        WebElement firstHotel = waitUtil.waitForClickable(
            By.xpath("(//a[contains(@href,'hotel') and contains(@class,'btn')])[1] | (//button[contains(text(),'Book')])[1]")
        );
        firstHotel.click();
        return this;
    }

    /**
     * Clicks Book Now for a specific hotel by name (dynamic XPath – Question 9).
     */
    public BookingPage clickBookNowForHotel(String hotelName) {
        // Dynamic XPath: parent-child – find the button inside the div containing the hotel name
        WebElement btn = waitUtil.waitForClickable(
            By.xpath("//div[.//text()[contains(.,'" + hotelName + "')]]//a[contains(@class,'book') or contains(text(),'Book')]")
        );
        btn.click();
        return this;
    }

    /**
     * Fills traveller details form (Question 5).
     */
    public BookingPage enterTravellerDetails(String firstName, String lastName,
                                              String email, String phone, String nationality) {
        waitUtil.waitForVisible(travelerFirstName).sendKeys(firstName);
        waitUtil.waitForVisible(travelerLastName).sendKeys(lastName);
        waitUtil.waitForVisible(travelerEmail).clear();
        waitUtil.waitForVisible(travelerEmail).sendKeys(email);
        waitUtil.waitForVisible(travelerPhone).sendKeys(phone);

        // Nationality dropdown
        try {
            Select select = new Select(waitUtil.waitForVisible(nationalityDropdown));
            select.selectByVisibleText(nationality);
        } catch (Exception e) {
            System.out.println("Nationality dropdown not standard select: " + e.getMessage());
        }
        return this;
    }

    /**
     * Confirms the booking.
     */
    public BookingPage confirmBooking() {
        waitUtil.waitForClickable(confirmButton).click();
        return this;
    }

    /**
     * Returns the booking confirmation message text.
     */
    public String getConfirmationMessage() {
        try {
            return waitUtil.waitForVisible(By.xpath(
                "//div[contains(@class,'alert-success')] | //h3[contains(text(),'Booking')] | //p[contains(text(),'confirmed')]"
            )).getText().trim();
        } catch (Exception e) {
            return "Confirmation message not found";
        }
    }

    /**
     * Returns true if booking confirmation is displayed.
     */
    public boolean isBookingConfirmed() {
        try {
            return waitUtil.waitForVisible(
                By.xpath("//div[contains(@class,'alert-success')] | //h3[contains(text(),'Booking Confirmed')]")
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Logs out the user (Question 5).
     */
    public void logout() {
        try {
            WebElement userMenu = waitUtil.waitForClickable(
                By.xpath("//li[contains(@class,'user-menu')] | //a[@class='dropdown-toggle']")
            );
            userMenu.click();
            waitUtil.waitForClickable(logoutButton).click();
        } catch (Exception e) {
            // Try direct logout link
            driver.get(driver.getCurrentUrl().replaceAll("/[^/]*$", "") + "/en/user/logout");
        }
    }
}
