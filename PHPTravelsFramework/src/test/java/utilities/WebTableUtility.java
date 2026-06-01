package utilities;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

/**
 * Question 16 – Dynamic Web Table Challenge
 * Fetches complete booking table data dynamically.
 * Validates duplicates, highest/lowest amount, and converts to Map.
 */
public class WebTableUtility {

    /**
     * Converts full web table into a List of Maps.
     * Each row becomes a Map of [columnHeader -> cellValue].
     * @param tableLocator – By locator of the <table> element
     */
    public static List<Map<String, String>> getTableData(By tableLocator) {
        List<Map<String, String>> tableData = new ArrayList<>();
        WebElement table = DriverFactory.getDriver().findElement(tableLocator);

        // Get headers from <thead> or first <tr>
        List<WebElement> headerCells = table.findElements(
            By.xpath(".//thead/tr/th | .//tr[1]/th | .//tr[1]/td")
        );

        List<String> headers = new ArrayList<>();
        for (WebElement header : headerCells) {
            headers.add(header.getText().trim());
        }

        // Get all data rows
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr | .//tr[position()>1]"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.isEmpty()) continue;

            Map<String, String> rowData = new LinkedHashMap<>();
            for (int i = 0; i < cells.size(); i++) {
                String header = (i < headers.size()) ? headers.get(i) : "Column_" + i;
                rowData.put(header, cells.get(i).getText().trim());
            }
            tableData.add(rowData);
        }

        return tableData;
    }

    /**
     * Returns list of duplicate rows from the table.
     * Two rows are duplicates if all their cell values match.
     */
    public static List<Map<String, String>> getDuplicateRows(List<Map<String, String>> tableData) {
        Map<String, Integer> rowCount = new LinkedHashMap<>();

        for (Map<String, String> row : tableData) {
            String key = row.toString();
            rowCount.put(key, rowCount.getOrDefault(key, 0) + 1);
        }

        List<Map<String, String>> duplicates = new ArrayList<>();
        for (Map<String, String> row : tableData) {
            if (rowCount.get(row.toString()) > 1 && !duplicates.contains(row)) {
                duplicates.add(row);
            }
        }
        return duplicates;
    }

    /**
     * Returns the highest booking amount from the table.
     * @param tableData  – parsed table
     * @param amountCol  – column header name for amounts (e.g. "Amount", "Total")
     */
    public static double getHighestAmount(List<Map<String, String>> tableData, String amountCol) {
        double max = Double.MIN_VALUE;
        for (Map<String, String> row : tableData) {
            String val = row.getOrDefault(amountCol, "0").replaceAll("[^0-9.]", "");
            if (!val.isEmpty()) {
                double amount = Double.parseDouble(val);
                if (amount > max) max = amount;
            }
        }
        return (max == Double.MIN_VALUE) ? 0 : max;
    }

    /**
     * Returns the lowest booking amount from the table.
     */
    public static double getLowestAmount(List<Map<String, String>> tableData, String amountCol) {
        double min = Double.MAX_VALUE;
        for (Map<String, String> row : tableData) {
            String val = row.getOrDefault(amountCol, "0").replaceAll("[^0-9.]", "");
            if (!val.isEmpty()) {
                double amount = Double.parseDouble(val);
                if (amount < min) min = amount;
            }
        }
        return (min == Double.MAX_VALUE) ? 0 : min;
    }

    /**
     * Prints the entire table to console for debugging.
     */
    public static void printTable(List<Map<String, String>> tableData) {
        System.out.println("====== TABLE DATA ======");
        for (int i = 0; i < tableData.size(); i++) {
            System.out.println("Row " + (i + 1) + ": " + tableData.get(i));
        }
        System.out.println("========================");
    }
}
