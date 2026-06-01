package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReportManager;
import utilities.ScreenshotUtility;

/**
 * TestNG Listener for test lifecycle events.
 * Integrates with Extent Reports.
 */
public class CustomTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("=== TEST STARTED: " + result.getMethod().getMethodName() + " ===");
        ExtentReportManager.createTest(
            result.getMethod().getMethodName(),
            result.getMethod().getDescription()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("=== TEST PASSED: " + result.getMethod().getMethodName() + " ===");
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().pass("Test Passed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("=== TEST FAILED: " + result.getMethod().getMethodName() + " ===");
        System.out.println("Failure Reason: " + result.getThrowable().getMessage());

        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().fail(result.getThrowable());

            // Capture screenshot on failure
            byte[] screenshot = ScreenshotUtility.captureScreenshotAsBytes();
            if (screenshot != null) {
                try {
                    String base64 = java.util.Base64.getEncoder().encodeToString(screenshot);
                    ExtentReportManager.getTest().fail(
                        com.aventstack.extentreports.MediaEntityBuilder
                            .createScreenCaptureFromBase64String(base64).build()
                    );
                } catch (Exception e) {
                    System.err.println("Could not attach screenshot to report: " + e.getMessage());
                }
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("=== TEST SKIPPED: " + result.getMethod().getMethodName() + " ===");
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().skip("Test Skipped: " + result.getThrowable());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("=== TEST SUITE FINISHED ===");
        System.out.println("Passed: " + context.getPassedTests().size());
        System.out.println("Failed: " + context.getFailedTests().size());
        System.out.println("Skipped: " + context.getSkippedTests().size());
        ExtentReportManager.flushReport();
    }
}
