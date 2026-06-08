package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    private Sheet sheet;
    private Workbook workbook;
    private String filePath;

    public ExcelUtil(String filePath, String sheetName) {

        try {

            FileInputStream fis = new FileInputStream(filePath);

             workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet(sheetName);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public Object[][] getSheetData() {
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {
            Row row = sheet.getRow(i);

            // Skip null rows (e.g. trailing empty rows in Excel)
            if (row == null) continue;

            for (int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j);

                // Return empty string instead of crashing on null cell
                data[i - 1][j] = (cell == null) ? "" : cell.toString();
            }
        }
        return data;
    }
    
    
    //to write data in excel:
    public void setCellData(int rowNum, int colNum, String value) {

        try {

            Row row = sheet.getRow(rowNum);

            if(row == null)
                row = sheet.createRow(rowNum);

            Cell cell = row.getCell(colNum);

            if(cell == null)
                cell = row.createCell(colNum);

            cell.setCellValue(value);

            FileOutputStream fos = new FileOutputStream(filePath);

            workbook.write(fos);

            fos.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}