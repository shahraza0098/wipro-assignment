package listeners;

import java.nio.file.FileSystemNotFoundException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;

public class TestListener
        implements ITestListener {

    ExtentReports extent =
            ExtentManager.getInstance();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test =
            extent.createTest(
                result.getMethod().getMethodName());
        System.out.println("test start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	System.out.println("test success");
        test.pass("Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}