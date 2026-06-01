package utilities;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

/**
 * ============================================================
 * Question 20 – Debugging Round: Find and Fix Errors
 * ============================================================
 * All four problems from the assignment are documented below
 * with the ORIGINAL broken code and the FIXED version.
 */
public class DebuggingAnswers {

    public void demonstrateAllFixes() {

        WebDriver driver = DriverFactory.getDriver();

        // ============================================================
        // PROBLEM 1
        // ============================================================
        // BUG: .click is a method reference (missing parentheses)
        //      It does NOT execute the click – just references the method.
        //
        // BROKEN:
        //   driver.findElement(By.id("login")).click;
        //
        // FIXED: Add () to actually invoke the method
        driver.findElement(By.id("login")).click();   // ← Added ()
        // ============================================================


        // ============================================================
        // PROBLEM 2
        // ============================================================
        // BUG: Assert.assertEquals(actual, expected) – arguments are reversed.
        //      TestNG convention is assertEquals(actual, expected).
        //      assertEquals(true, false) will ALWAYS fail.
        //      If the intent was to assert something is true, use assertTrue().
        //
        // BROKEN:
        //   Assert.assertEquals(true, false);
        //
        // FIX OPTION A – if you need to assert a condition is true:
        boolean loginVisible = driver.findElement(By.id("login")).isDisplayed();
        Assert.assertTrue(loginVisible, "Login element should be visible");  // ← Correct

        // FIX OPTION B – if you need to compare two values:
        String actualTitle   = driver.getTitle();
        String expectedTitle = "Login - PHPTRAVELS";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");  // ← (actual, expected)
        // ============================================================


        // ============================================================
        // PROBLEM 3
        // ============================================================
        // BUG: Missing "Scenario:" keyword in the feature file.
        //      Cucumber requires the "Scenario:" keyword before the name.
        //
        // BROKEN (in .feature file):
        //   Login Validation
        //   Given user launches browser
        //   ...
        //
        // FIXED:
        //   Scenario: Login Validation          ← Added "Scenario:" keyword
        //   Given user launches browser
        //   When user enters credentials
        //   ...
        //
        // Note: This is a .feature file syntax fix, not Java code.
        System.out.println("Problem 3 is a .feature file fix: add 'Scenario:' keyword before the scenario name.");
        // ============================================================


        // ============================================================
        // PROBLEM 4
        // ============================================================
        // BUG: Selenium 4 changed WebDriverWait constructor.
        //      Old Selenium 3 syntax used a raw int for timeout.
        //      Selenium 4 requires Duration.ofSeconds().
        //
        // BROKEN (Selenium 3 style):
        //   WebDriverWait wait = new WebDriverWait(driver, 10);
        //
        // FIXED (Selenium 4 style):
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // ← Duration.ofSeconds()
        //
        // The raw int constructor is deprecated and removed in Selenium 4.
        // Always use Duration from java.time.Duration.
        System.out.println("Problem 4 fixed: WebDriverWait now uses Duration.ofSeconds(10)");
        // ============================================================
    }
}
