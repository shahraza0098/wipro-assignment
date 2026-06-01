package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

/**
 * Question 3 – Hotel Search Automation
 * Question 4 – Dynamic Price Validation
 * Question 9 – Advanced XPath Challenge
 */
public class HotelSearchPage extends BasePage {

    // ========================
    // Web Elements
    // ========================

    /**
     * Question 9 – Dynamic Hotel Search Input
     * Using contains() for partial id match.
     */
    @FindBy(xpath = "//input[contains(@id,'hotels_city') or contains(@id,'city')]")
    private WebElement destinationInput;

    /**
     * Question 9 – Search Button using id.
     */
    @FindBy(xpath = "//button[@id='submit'] | //button[contains(@class,'btn') and @type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='checkin'] | //input[contains(@name,'checkin')]")
    private WebElement checkInInput;

    @FindBy(xpath = "//input[@id='checkout'] | //input[contains(@name,'checkout')]")
    private WebElement checkOutInput;

    // ========================
    // Hotel Search Actions (Question 3)
    // ========================

    /**
     * Navigate to Hotels tab.
     */
    public HotelSearchPage navigateToHotels() {
        driver.get(driver.getCurrentUrl().split("\\?")[0].replaceAll("/[^/]*$", "") + "/");
        try {
            WebElement hotelsTab = waitUtil.waitForClickable(
                By.xpath("//a[contains(@href,'hotels') or contains(text(),'Hotels')]")
            );
            hotelsTab.click();
        } catch (Exception e) {
            System.out.println("Already on home page with hotel search.");
        }
        return this;
    }

    /**
     * Enter destination in the city input (supports Select2 custom input).
     */
    public HotelSearchPage enterDestination(String destination) {
        try {
            // Handle Select2 input container
            WebElement container = waitUtil.waitForClickable(
                By.xpath("//span[contains(@id,'select2-hotels_city')]")
            );
            container.click();

            WebElement searchInput = waitUtil.waitForVisible(
                By.xpath("//input[@class='select2-search__field']")
            );
            searchInput.sendKeys(destination);

            // Wait for suggestion and select first match
            WebElement firstOption = waitUtil.waitForVisible(
                By.xpath("//li[contains(@class,'select2-results__option') and not(contains(@class,'loading'))]")
            );
            firstOption.click();
        } catch (Exception e) {
            // Fallback for plain input
            waitUtil.waitForVisible(destinationInput).sendKeys(destination);
        }
        return this;
    }

    /**
     * Sets check-in date via JavaScript to bypass date picker constraints.
     */
    public HotelSearchPage setCheckInDate(String date) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement field = waitUtil.waitForPresence(
            By.xpath("//input[@id='checkin' or contains(@name,'checkin')]")
        );
        js.executeScript("arguments[0].removeAttribute('readonly');", field);
        field.clear();
        field.sendKeys(date);
        return this;
    }

    /**
     * Sets check-out date via JavaScript.
     */
    public HotelSearchPage setCheckOutDate(String date) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement field = waitUtil.waitForPresence(
            By.xpath("//input[@id='checkout' or contains(@name,'checkout')]")
        );
        js.executeScript("arguments[0].removeAttribute('readonly');", field);
        field.clear();
        field.sendKeys(date);
        return this;
    }

    /**
     * Selects travellers count.
     */
    public HotelSearchPage selectTravellersCount(int adults) {
        try {
            WebElement adultsField = waitUtil.waitForVisible(
                By.xpath("//input[@id='adults'] | //select[@name='adults']")
            );
            adultsField.clear();
            adultsField.sendKeys(String.valueOf(adults));
        } catch (Exception e) {
            System.out.println("Travellers field not found or already set: " + e.getMessage());
        }
        return this;
    }

    /**
     * Clicks the search button (Question 9 – starts-with XPath).
     */
    public void clickSearch() {
        waitUtil.waitForClickable(
            By.xpath("//button[starts-with(@id,'submit') or @id='submit']")
        ).click();
    }

    // ========================
    // Validation Methods (Question 3)
    // ========================

    /**
     * Returns true if hotel search results are displayed.
     */
    public boolean areResultsDisplayed() {
        try {
            return waitUtil.waitForVisible(
                By.xpath("//div[contains(@class,'hotel-item')] | //div[contains(@class,'col-md-12') and contains(@class,'hotel')]")
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns the count of available hotels.
     */
    public int getHotelCount() {
        try {
            List<WebElement> hotels = driver.findElements(
                By.xpath("//div[contains(@class,'hotel-item')] | //div[@class='col-md-12 HOTEL']")
            );
            return hotels.size();
        } catch (Exception e) {
            return 0;
        }
    }

    // ========================
    // Price Validation (Question 4)
    // ========================

    /**
     * Question 4 – Fetches all hotel prices dynamically.
     * Question 9 – Uses price XPath with contains().
     * @return List of hotel names mapped to their prices
     */
    public Map<String, Double> getAllHotelPrices() {
        Map<String, Double> hotelPriceMap = new LinkedHashMap<>();

        List<WebElement> priceElements = driver.findElements(
            By.xpath("//span[contains(@class,'price')] | //h6[contains(@class,'price')] | //span[starts-with(@class,'price')]")
        );
        List<WebElement> nameElements = driver.findElements(
            By.xpath("//p[contains(@class,'hotel-name')] | //h4[contains(@class,'hotel-title')] | //a[contains(@class,'hotel-name')]")
        );

        for (int i = 0; i < priceElements.size(); i++) {
            String priceText = priceElements.get(i).getText()
                .replaceAll("[^0-9.]", "").trim();
            String hotelName = (i < nameElements.size())
                ? nameElements.get(i).getText().trim()
                : "Hotel_" + (i + 1);

            if (!priceText.isEmpty()) {
                try {
                    double price = Double.parseDouble(priceText);
                    hotelPriceMap.put(hotelName, price);
                } catch (NumberFormatException e) {
                    System.out.println("Could not parse price: " + priceText);
                }
            }
        }
        return hotelPriceMap;
    }

    /**
     * Returns the highest hotel price (Question 4 – using Collections).
     */
    public double getHighestPrice(Map<String, Double> priceMap) {
        if (priceMap.isEmpty()) return 0;
        return Collections.max(priceMap.values());
    }

    /**
     * Returns the lowest hotel price (Question 4 – using Collections).
     */
    public double getLowestPrice(Map<String, Double> priceMap) {
        if (priceMap.isEmpty()) return 0;
        return Collections.min(priceMap.values());
    }

    /**
     * Returns the average hotel price (Question 4 – using loops).
     */
    public double getAveragePrice(Map<String, Double> priceMap) {
        if (priceMap.isEmpty()) return 0;
        double sum = 0;
        for (double price : priceMap.values()) {
            sum += price;
        }
        return sum / priceMap.size();
    }

    /**
     * Detects duplicate hotel names (Question 4 – using HashMap).
     * @return List of hotel names that appear more than once
     */
    public List<String> getDuplicateHotelNames() {
        List<WebElement> hotelNameElements = driver.findElements(
            By.xpath("//p[contains(@class,'hotel-name')] | //h4[contains(@class,'hotel-title')]")
        );

        // HashMap to count occurrences
        HashMap<String, Integer> nameCount = new HashMap<>();
        for (WebElement el : hotelNameElements) {
            String name = el.getText().trim();
            nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
        }

        // Filter duplicates
        List<String> duplicates = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : nameCount.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey() + " (count: " + entry.getValue() + ")");
            }
        }
        return duplicates;
    }

    /**
     * Question 9 – parent-child traversal XPath to get hotel and its price together.
     */
    public Map<String, String> getHotelNameAndPriceUsingParentChild() {
        Map<String, String> result = new LinkedHashMap<>();
        List<WebElement> hotelCards = driver.findElements(
            By.xpath("//div[contains(@class,'hotel-item')] | //div[@class='col-md-12 HOTEL']")
        );
        for (WebElement card : hotelCards) {
            try {
                // parent-child traversal: get name from child of card
                String name = card.findElement(By.xpath(".//h4 | .//p[contains(@class,'name')]")).getText().trim();
                // following-sibling traversal: get price sibling of name
                String price = card.findElement(By.xpath(".//span[contains(@class,'price')]")).getText().trim();
                result.put(name, price);
            } catch (Exception e) {
                // Skip cards with missing data
            }
        }
        return result;
    }
}
