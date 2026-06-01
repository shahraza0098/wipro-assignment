package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;

/**
 * Question 2 – User Registration Page Object
 * Handles dropdown, random email, dynamic XPath, explicit wait.
 */
public class RegistrationPage extends BasePage {

    // ========================
    // Web Elements
    // ========================
    @FindBy(xpath = "//input[@name='first_name'] | //input[@id='first_name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='last_name'] | //input[@id='last_name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='phone'] | //input[@id='phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@name='email'] | //input[@id='email'] | //input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password'] | //input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='password_confirmation'] | //input[@id='password_confirmation']")
    private WebElement confirmPasswordField;

    // Country dropdown (Dynamic XPath – Question 2)
    private final By countryDropdown = By.xpath("//select[@name='country'] | //select[@id='country']");

    @FindBy(xpath = "//button[@type='submit'] | //input[@value='Register'] | //button[contains(text(),'Sign Up')]")
    private WebElement registerButton;

    // ========================
    // Actions
    // ========================

    /**
     * Navigate to registration page.
     */
    public RegistrationPage navigateToRegistration() {
        driver.get(driver.getCurrentUrl().split("/en/")[0] + "/en/user/register");
        return this;
    }

    /**
     * Generates a unique random email using UUID (Question 2).
     */
    public String generateRandomEmail() {
        return "testuser_" + UUID.randomUUID().toString().substring(0, 8) + "@testmail.com";
    }

    /**
     * Fills in all mandatory registration fields.
     * Demonstrates Dynamic XPath and Explicit Wait usage.
     */
    public void fillRegistrationForm(String firstName, String lastName,
                                      String phone, String password, String country) {
        // Wait for form to be visible before interacting
        waitUtil.waitForVisible(By.xpath("//input[@name='first_name'] | //input[@id='first_name']"))
                .sendKeys(firstName);

        waitUtil.waitForVisible(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
        waitUtil.waitForVisible(By.xpath("//input[@name='phone']")).sendKeys(phone);

        // Generate and use random email (Question 2)
        String randomEmail = generateRandomEmail();
        waitUtil.waitForVisible(By.xpath("//input[@type='email']")).sendKeys(randomEmail);

        waitUtil.waitForVisible(By.xpath("//input[@name='password']")).sendKeys(password);
        waitUtil.waitForVisible(By.xpath("//input[@name='password_confirmation']")).sendKeys(password);

        // Country dropdown (Dropdown Handling – Question 2)
        selectCountry(country);
    }

    /**
     * Selects country from dropdown dynamically (Question 2 – Dropdown Handling).
     */
    public void selectCountry(String countryName) {
        try {
            // Try native <select> first
            WebElement dropdown = waitUtil.waitForVisible(countryDropdown);
            Select select = new Select(dropdown);
            select.selectByVisibleText(countryName);
        } catch (Exception e) {
            // Fallback: custom dropdown (e.g. Select2)
            WebElement customDropdown = waitUtil.waitForClickable(
                By.xpath("//span[contains(@class,'select2') and contains(@aria-labelledby,'country')]")
            );
            customDropdown.click();

            WebElement option = waitUtil.waitForVisible(
                By.xpath("//li[contains(@class,'select2-results__option') and text()='" + countryName + "']")
            );
            option.click();
        }
    }

    /**
     * Submits the registration form.
     */
    public void submitRegistration() {
        waitUtil.waitForClickable(registerButton).click();
    }

    /**
     * Validates if registration was successful.
     */
    public boolean isRegistrationSuccessful() {
        try {
            WebElement successMessage = waitUtil.waitForVisible(
                By.xpath("//div[contains(@class,'alert-success')] | //p[contains(text(),'successfully')]")
            );
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
