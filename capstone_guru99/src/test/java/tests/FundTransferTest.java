package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountPage;
import pages.FundTransferPage;
import utilities.ExcelUtil;

public class FundTransferTest extends BaseTest {

    FundTransferPage fundTransferPage;
    
    @BeforeClass
    public void accountSetup() {

    	  fundTransferPage =
                  new FundTransferPage(driver);
    	  loginToApplication(); 
    }

   

    @DataProvider(name = "fundTransferData")
    public Object[][] getFundTransferData() {

        ExcelUtil excel =
                new ExcelUtil(
                        "src/test/resources/testdata/FundTrafer.xlsx",
                        "fundTransferData");

        return excel.getSheetData();
    }

    @Test(dataProvider = "fundTransferData")
    public void fundTransferTest(
         
            String payerAcc,
            String payeeAcc,
            String transferAmount,
            String description,
            String status) {

        fundTransferPage.clickFundTransfer();

        try {

            fundTransferPage.transferFunds(
                    payerAcc,
                    payeeAcc,
                    transferAmount,
                    description);

            if (status.equalsIgnoreCase("valid")) {

                Assert.assertTrue(
                        fundTransferPage.isTransferSuccessful());

        

            } else {

            	 try {

            	        if (payerAcc.equalsIgnoreCase(payeeAcc) 
            	                && !payerAcc.isEmpty()) {
            	            fundTransferPage.acceptAccountNumSame();

            	        } else if (payerAcc.isEmpty() 
            	                || payeeAcc.isEmpty() 
            	                || transferAmount.isEmpty() 
            	                || description.isEmpty()) {
            	        	if(description.isEmpty()) {
            	        		fundTransferPage.clickTrasferSubmitBtn();
            	        	}
            	            fundTransferPage.acceptMissField();

            	        } else if (!transferAmount.isEmpty()) {
            	            double amount = Double.parseDouble(transferAmount);
            	            if (amount > 100000) {
            	                fundTransferPage.acceptLowBal();
            	            }
            	        }
            	 
            	 
             }catch(Exception e) {

     	        Assert.fail("Expected alert not displayed");
     	    }
            }

        } catch (Exception e) {

        	Assert.fail("Expected alert not displayed");
        }
    }

}