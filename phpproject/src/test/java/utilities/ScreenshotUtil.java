package utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class ScreenshotUtil {

    public static String capture(
            WebDriver driver,
            String name) {

        try {

            File src =
            ((TakesScreenshot)driver)
            .getScreenshotAs(OutputType.FILE);

            String path =
            "screenshots/"
            +name+"_"
            +System.currentTimeMillis()
            +".png";

            FileUtils.copyFile(src,
            new File(path));

            return path;

        } catch(Exception e) {

            return null;
        }
    }
}