package testing_practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTesting {
	
	public void readExcelData() throws IOException {
		FileInputStream file=new FileInputStream("C:\\Users\\shahr\\eclipse-workspace\\wipro-assignment\\TestNG_selenium\\testData\\loginData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int noOfRows=sheet.getLastRowNum();
		int noOfCell=sheet.getRow(1).getLastCellNum();
		
		for(int r=0; r<=noOfRows;r++) {
			
			XSSFRow row=sheet.getRow(r);
			for(int c=0; c<noOfCell; c++) {
				XSSFCell cell=row.getCell(c);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
		
	}
	
	
	public void writeDataOnExcel() throws IOException {
		FileOutputStream file=new FileOutputStream("C:\\\\Users\\\\shahr\\\\eclipse-workspace\\\\wipro-assignment\\\\TestNG_selenium\\\\testData\\\\myFile.xlsx");
		
		
		XSSFWorkbook workbook= new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("Mysheet1");
		
		XSSFRow row1=sheet.createRow(0);
		row1.createCell(0).setCellValue("Name");
		row1.createCell(1).setCellValue("Dept");
		row1.createCell(2).setCellValue("Salary");
		
		
		XSSFRow row2=sheet.createRow(0);
		row2.createCell(0).setCellValue("Shahid");
		row2.createCell(1).setCellValue("SDET");
		row2.createCell(2).setCellValue("25000");
		
		
		XSSFRow row3=sheet.createRow(0);
		row3.createCell(0).setCellValue("Raj Aryan");
		row3.createCell(1).setCellValue("Marketing");
		row3.createCell(2).setCellValue("15000");
		
		
		
		
		workbook.write(file);
		workbook.close();
		file.close();
	}
	
	void writeExcelFileUsingLoop() {
		
	}

	public static void main(String[] args) throws IOException {
		
		
	}

}
