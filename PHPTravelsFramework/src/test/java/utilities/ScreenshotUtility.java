package utilities;

import base.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Question 11 – Screenshot Utility Framework
 * Captures screenshots on Pass, Failure, and Skipped scenarios.
 * Screenshots are saved with timestamp in the filename.
 * They are also attached to Extent Reports via Hooks.
 */
public class ScreenshotUtility {

    private static final String SCREENSHOT_DIR = System.getProperty("user.dir")
            + "/src/test/resources/screenshots/";

    /**
     * Captures screenshot and returns absolute file path.
     * @param scenarioName - used to name the file
     * @param status       - PASS / FAIL / SKIP
     */
    public static String captureScreenshot(String scenarioName, String status) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver == null) return null;

        // Create screenshots directory if it doesn't exist
        File dir = new File(SCREENSHOT_DIR);
        if (!dir.exists()) dir.mkdirs();

        // Generate timestamped filename
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String sanitizedName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_");
        String fileName = status + "_" + sanitizedName + "_" + timestamp + ".png";
        String fullPath = SCREENSHOT_DIR + fileName;

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(srcFile.toPath(), Paths.get(fullPath));
            System.out.println("Screenshot saved: " + fullPath);
            return fullPath;
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
            return null;
        }
    }

    /**
     * Returns screenshot as byte array for direct attachment to Extent Reports.
     */
    public static byte[] captureScreenshotAsBytes() {
        WebDriver driver = DriverFactory.getDriver();
        if (driver == null) return null;
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot as bytes: " + e.getMessage());
            return null;
        }
    }
}
