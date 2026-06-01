package utilities;

/**
 * ============================================================
 * Question 9 – Advanced XPath Challenge
 * ============================================================
 * All required XPaths are documented here with explanations.
 * They are also used directly in Page classes.
 * ============================================================
 */
public class XPathReference {

    // ============================================================
    // 1. Dynamic Hotel Search Input
    //    Element: <input type="text" id="select2-hotels_city-container">
    // ============================================================

    // Using contains() – matches partial id
    public static final String HOTEL_SEARCH_CONTAINS =
        "//input[contains(@id,'hotels_city')]";

    // Using starts-with() – id starts with 'select2'
    public static final String HOTEL_SEARCH_STARTS_WITH =
        "//input[starts-with(@id,'select2')]";

    // Full match
    public static final String HOTEL_SEARCH_EXACT =
        "//input[@id='select2-hotels_city-container']";


    // ============================================================
    // 2. Search Button
    //    Element: <button id="submit">Search</button>
    // ============================================================

    // Using id
    public static final String SEARCH_BUTTON_BY_ID =
        "//button[@id='submit']";

    // Using starts-with() on id
    public static final String SEARCH_BUTTON_STARTS_WITH =
        "//button[starts-with(@id,'sub')]";

    // Using contains() on text
    public static final String SEARCH_BUTTON_TEXT =
        "//button[contains(text(),'Search')]";


    // ============================================================
    // 3. Hotel Price
    //    Element: <span class="price">₹4500</span>
    // ============================================================

    // Using contains() on class
    public static final String HOTEL_PRICE_CONTAINS =
        "//span[contains(@class,'price')]";

    // Using starts-with() on class
    public static final String HOTEL_PRICE_STARTS_WITH =
        "//span[starts-with(@class,'price')]";

    // Exact class match
    public static final String HOTEL_PRICE_EXACT =
        "//span[@class='price']";


    // ============================================================
    // 4. following-sibling Example
    //    Get the price that comes AFTER the hotel name span
    // ============================================================

    // Get the element following the hotel name label
    public static final String PRICE_FOLLOWING_SIBLING =
        "//span[@class='hotel-name']/following-sibling::span[@class='price']";

    // Get label following a specific type of element
    public static final String FOLLOWING_SIBLING_EXAMPLE =
        "//div[@class='hotel-details']//h4/following-sibling::span[contains(@class,'price')]";


    // ============================================================
    // 5. parent-child traversal
    //    Navigate from parent container to child elements
    // ============================================================

    // From hotel card parent, find child name
    public static final String PARENT_TO_CHILD_NAME =
        "//div[contains(@class,'hotel-item')]//h4[contains(@class,'name')]";

    // From hotel card parent, find child price
    public static final String PARENT_TO_CHILD_PRICE =
        "//div[contains(@class,'hotel-item')]//span[contains(@class,'price')]";

    // Navigate UP to parent then down to sibling (child-parent-sibling)
    public static final String CHILD_PARENT_SIBLING =
        "//span[contains(@class,'hotel-name')]/parent::div//span[contains(@class,'price')]";

    // ============================================================
    // USAGE NOTE:
    // In Page classes, these are used as:
    //   driver.findElement(By.xpath(XPathReference.HOTEL_PRICE_CONTAINS))
    // or inline within @FindBy:
    //   @FindBy(xpath = "//span[contains(@class,'price')]")
    // ============================================================
}
