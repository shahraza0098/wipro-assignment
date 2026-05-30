package utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    public static String getCellData(int row, int col) {

        String path = "src/test/resources/TestData.xlsx";

        try {
            FileInputStream fis = new FileInputStream(path);

            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet("Login");

            String data =
                    sheet.getRow(row)
                    .getCell(col)
                    .toString();

            workbook.close();

            return data;

        } catch (Exception e) {
            return "";
        }
    }
}