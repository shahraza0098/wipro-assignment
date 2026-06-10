package utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static List<String[]> getLoginData(
            String filePath,
            String sheetName) {

        List<String[]> data = new ArrayList<>();

        try {

            FileInputStream fis =
                    new FileInputStream(filePath);

            XSSFWorkbook workbook =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet =
                    workbook.getSheet(sheetName);

            int lastRow =
                    sheet.getLastRowNum();

            for (int i = 1; i <= lastRow; i++) {

                String username =
                        sheet.getRow(i)
                             .getCell(0)
                             .toString();

                String password =
                        sheet.getRow(i)
                             .getCell(1)
                             .toString();

                data.add(
                        new String[] {
                                username,
                                password
                        });
            }

            workbook.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return data;
    }
}