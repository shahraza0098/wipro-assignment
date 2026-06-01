package hooks;

import base.DriverFactory;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import reports.ExtentReportManager;
import utilities.ScreenshotUtility;

import java.util.Base64;

/**
 * Question 17 – Why Hooks?
 * – Hooks run before/after each scenario automatically.
 * – Used for driver setup, teardown, screenshots, and report logging.
 * – Decouples cross-cutting concerns from step definitions.
 *
 * Question 11 – Screenshot Utility (On Pass / Fail / Skip)
 */
public class Hooks {

    /**
     * Runs before each scenario.
     * Initializes browser and creates Extent Report test entry.
     */
    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("====== Starting Scenario: " + scenario.getName() + " ======");
        DriverFactory.initDriver();
        ExtentReportManager.createTest(scenario.getName(), "Tags: " + scenario.getSourceTagNames());
    }

    /**
     * Runs after each step – logs step result to Extent Report.
     */
    @AfterStep
    public void afterStep(Scenario scenario) {
        if (ExtentReportManager.getTest() == null) return;

        if (scenario.isFailed()) {
            // Capture and attach screenshot on step failure
            byte[] screenshotBytes = ScreenshotUtility.captureScreenshotAsBytes();
            if (screenshotBytes != null) {
                String base64Screenshot = Base64.getEncoder().encodeToString(screenshotBytes);
                ExtentReportManager.getTest().fail("Step Failed",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            }
        }
    }

    /**
     * Runs after each scenario.
     * Captures screenshot, logs result, quits driver.
     */
    @After
    public void afterScenario(Scenario scenario) {
        try {
            String status = scenario.getStatus().name(); // PASSED / FAILED / SKIPPED / PENDING
            System.out.println("====== Scenario: " + scenario.getName() + " | Status: " + status + " ======");

            // Screenshot logic for all statuses (Question 11)
            byte[] screenshotBytes = ScreenshotUtility.captureScreenshotAsBytes();
            String base64Screenshot = (screenshotBytes != null)
                    ? Base64.getEncoder().encodeToString(screenshotBytes) : null;

            if (ExtentReportManager.getTest() != null) {
                switch (status) {
                    case "PASSED":
                        ExtentReportManager.getTest().pass("Scenario Passed");
                        if (base64Screenshot != null) {
                            ExtentReportManager.getTest().pass("Screenshot",
                                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
                        }
                        break;

                    case "FAILED":
                        ExtentReportManager.getTest().fail("Scenario Failed");
                        if (base64Screenshot != null) {
                            ExtentReportManager.getTest().fail("Failure Screenshot",
                                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
                        }
                        // Also attach to Cucumber report
                        if (screenshotBytes != null) {
                            scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");
                        }
                        break;

                    case "SKIPPED":
                    case "PENDING":
                        ExtentReportManager.getTest().log(Status.SKIP, "Scenario Skipped/Pending");
                        if (base64Screenshot != null) {
                            ExtentReportManager.getTest().log(Status.SKIP, "Screenshot",
                                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
                        }
                        break;
                }
            }

            // Save screenshot file with timestamp
            ScreenshotUtility.captureScreenshot(scenario.getName(), status);

        } catch (Exception e) {
            System.err.println("Error in afterScenario hook: " + e.getMessage());
        } finally {
            DriverFactory.quitDriver();
            ExtentReportManager.flushReport();
        }
    }
}
