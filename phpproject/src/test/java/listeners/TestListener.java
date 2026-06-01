package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println(
                "Started : "
                + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println(
                "Passed : "
                + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println(
                "Failed : "
                + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println(
                "Execution Completed");
    }
}