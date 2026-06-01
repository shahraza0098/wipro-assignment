package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Manages the Extent Report instance.
 * Uses ThreadLocal<ExtentTest> to make test logging thread-safe for parallel execution.
 */
public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    /**
     * Initializes ExtentReports with Spark (HTML) reporter.
     * Called once before all tests.
     */
    public static synchronized ExtentReports getInstance() {
        if (extentReports == null) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = System.getProperty("user.dir")
                    + "/reports/ExtentReport_" + timestamp + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("PHPTravels Automation Report");
            sparkReporter.config().setReportName("PHPTravels Test Execution Report");
            sparkReporter.config().setTimelineEnabled(true);

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
            extentReports.setSystemInfo("Application", "PHPTravels");
            extentReports.setSystemInfo("Environment", "Demo");
            extentReports.setSystemInfo("OS", System.getProperty("os.name"));
            extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        }
        return extentReports;
    }

    /**
     * Creates and sets a test entry for the current thread.
     */
    public static void createTest(String testName, String description) {
        ExtentTest test = getInstance().createTest(testName, description);
        extentTest.set(test);
    }

    /**
     * Returns the ExtentTest instance for the current thread.
     */
    public static ExtentTest getTest() {
        return extentTest.get();
    }

    /**
     * Flushes the report - must be called after all tests complete.
     */
    public static synchronized void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
