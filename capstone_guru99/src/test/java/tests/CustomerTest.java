package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CustomerPage;
import utilities.ExcelUtil;

public class CustomerTest extends BaseTest  {
	CustomerPage customerPage;
	
	@DataProvider(name="customerData")
	public Object[][] getCustomerData(){

	    ExcelUtil excel =
	        new ExcelUtil(
	        "src/test/resources/testdata/CustomerData.xlsx",
	        "CustomerData");

	    return excel.getSheetData();
	}
	
	
	@Test(dataProvider="customerData")
	public void addCustomerTest(
	        String tcId,
	        String name,
	        String dob,
	        String address,
	        String city,
	        String state,
	        String pin,
	        String phone,
	        String email,
	        String password,
	        String customerId,
	        String executionStatus) {

	    customerPage.clickNewCustomer();

	    String uniqueEmail =
	            System.currentTimeMillis()
	            + email;

	    customerPage.addCustomer(
	            name,
	            dob,
	            address,
	            city,
	            state,
	            pin,
	            phone,
	            uniqueEmail,
	            password);

	    String generatedCustomerId =
	            customerPage.getCustomerId();

	    Assert.assertFalse(
	            generatedCustomerId.isEmpty());

	    ExcelUtil excel =
	            new ExcelUtil(
	            "src/test/resources/testdata/Guru99Data.xlsx",
	            "CustomerData");

	    int rowNumber =
	            excel.findRow(tcId);

	    excel.setCellData(
	            rowNumber,
	            10,
	            generatedCustomerId);

	    excel.setCellData(
	            rowNumber,
	            11,
	            "CREATED");
	}
}
