package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
//onTestStart()
//onTestSuccess()
//onTestFailure()
//onTestSkipped()
//onStart()
//onFinish()
public class MyListener  implements ITestListener{
	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test case started successfully");
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test case successfully completed");
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test case fail due to inturption");
	}
	@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test case skipped execution ");
	}
	
	@Override
	public void onStart(org.testng.ITestContext content)
	{
		System.out.println("Execution started ");
	}
	@Override
	public void onFinish(org.testng.ITestContext content)
	{
		System.out.println("Execution finish ");
	}
}
 