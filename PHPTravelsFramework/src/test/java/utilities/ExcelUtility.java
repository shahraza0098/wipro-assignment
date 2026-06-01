package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Apache POI-based Excel Data Reader.
 * Supports reading credentials, test data for DDT (Data Driven Testing).
 */
public class ExcelUtility {

    private Workbook workbook;
    private String filePath;

    public ExcelUtility(String filePath) {
        this.filePath = filePath;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            this.workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException("Excel file not found at: " + filePath + " | " + e.getMessage());
        }
    }

    /**
     * Returns cell value as String (handles different cell types).
     */
    public String getCellData(String sheetName, int rowIndex, int colIndex) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel.");

        Row row = sheet.getRow(rowIndex);
        if (row == null) return "";

        Cell cell = row.getCell(colIndex);
        if (cell == null) return "";

        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell).trim();
    }

    /**
     * Returns total number of rows with data in a sheet.
     */
    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) throw new RuntimeException("Sheet '" + sheetName + "' not found.");
        return sheet.getLastRowNum();
    }

    /**
     * Returns total number of columns in a row.
     */
    public int getColumnCount(String sheetName, int rowIndex) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowIndex);
        return (row == null) ? 0 : row.getLastCellNum();
    }

    /**
     * Returns all login data as a List of String arrays [username, password].
     */
    public List<String[]> getLoginData(String sheetName) {
        List<String[]> data = new ArrayList<>();
        int rows = getRowCount(sheetName);
        for (int i = 1; i <= rows; i++) { // Start from 1 to skip header row
            String username = getCellData(sheetName, i, 0);
            String password = getCellData(sheetName, i, 1);
            data.add(new String[]{username, password});
        }
        return data;
    }

    /**
     * Returns sheet data as List of Maps (column header -> cell value).
     */
    public List<Map<String, String>> getSheetDataAsMap(String sheetName) {
        List<Map<String, String>> dataList = new ArrayList<>();
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) throw new RuntimeException("Sheet not found: " + sheetName);

        Row headerRow = sheet.getRow(0);
        int colCount = headerRow.getLastCellNum();

        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;
            Map<String, String> rowMap = new HashMap<>();
            for (int c = 0; c < colCount; c++) {
                String header = headerRow.getCell(c).getStringCellValue().trim();
                String value = getCellData(sheetName, r, c);
                rowMap.put(header, value);
            }
            dataList.add(rowMap);
        }
        return dataList;
    }

    public void close() {
        try {
            if (workbook != null) workbook.close();
        } catch (IOException e) {
            System.err.println("Failed to close workbook: " + e.getMessage());
        }
    }
}
