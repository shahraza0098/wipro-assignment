package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {

    WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    By hotelNames =
            By.xpath("//h5");

    By hotelPrices =
            By.xpath("//strong[contains(text(),'USD')]");

    public int getHotelCount() {

        List<WebElement> hotels =
                driver.findElements(hotelNames);

        return hotels.size();
    }
}