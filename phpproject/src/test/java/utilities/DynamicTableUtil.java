package utilities;

import java.util.*;

import org.openqa.selenium.*;

public class DynamicTableUtil {

    public static Map<String,String>
    getTableData(WebDriver driver) {

        Map<String,String> map =
                new HashMap<>();

        List<WebElement> rows =
                driver.findElements(
                        By.xpath("//table/tbody/tr"));

        for(WebElement row : rows) {

            String col1 =
                    row.findElement(
                            By.xpath("./td[1]"))
                            .getText();

            String col2 =
                    row.findElement(
                            By.xpath("./td[2]"))
                            .getText();

            map.put(col1,col2);
        }

        return map;
    }
}