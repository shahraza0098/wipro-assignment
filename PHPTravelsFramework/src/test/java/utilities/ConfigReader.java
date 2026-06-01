package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Reads values from src/test/resources/config/config.properties.
 */
public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/config/config.properties"
            );
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException("config.properties file not found: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in config.properties");
        }
        return value;
    }
}
