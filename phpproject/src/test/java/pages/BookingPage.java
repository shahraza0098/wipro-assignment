package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingPage {

    WebDriver driver;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }

    By roomSelect =
            By.xpath("//button[contains(.,'Book Now')]");

    By firstName =
            By.xpath("(//input[contains(@placeholder,'First Name')])[1]");

    By lastName =
            By.xpath("(//input[contains(@placeholder,'Last Name')])[1]");

    By terms =
            By.xpath("//input[@type='checkbox']");

    By confirmBooking =
            By.xpath("//button[contains(.,'Confirm Booking')]");

    public void completeBooking(
            String fn,
            String ln) {

        driver.findElement(firstName)
              .sendKeys(fn);

        driver.findElement(lastName)
              .sendKeys(ln);

        driver.findElement(terms).click();

        driver.findElement(confirmBooking)
              .click();
    }
}