package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtil {

    public static String getCellData(
            String sheetName,
            int row,
            int col) {

        try {

            FileInputStream fis =
                    new FileInputStream(
                    "src/test/resources/testdata/TestData.xlsx");

            XSSFWorkbook workbook =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet =
                    workbook.getSheet(sheetName);

            String data =
                    sheet.getRow(row)
                         .getCell(col)
                         .toString();

            workbook.close();

            return data;

        } catch(Exception e) {

            e.printStackTrace();
            return "";
        }
    }
}