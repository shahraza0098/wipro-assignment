package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelSearchPage {

    WebDriver driver;

    public HotelSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By staysTab =
            By.xpath("//button[contains(.,'Stays')]");

    By destination =
            By.xpath("//input[contains(@placeholder,'City')]");

    By checkIn =
            By.xpath("//input[contains(@placeholder,'Check-in')]");

    By checkOut =
            By.xpath("//input[contains(@placeholder,'Check-out')]");

    By guests =
            By.xpath("//div[contains(text(),'Guests')]");

    By nationality =
            By.xpath("//select");

    By searchBtn =
            By.xpath("//button[contains(.,'Search Hotels')]");

    public void searchHotel(String city) {

        driver.findElement(staysTab).click();

        driver.findElement(destination)
              .sendKeys(city);

        driver.findElement(searchBtn)
              .click();
    }
}