package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Retry Analyzer: Retries failed tests up to MAX_RETRY times.
 * Attached to runners via TestNG listener or @Test(retryAnalyzer = RetryAnalyzer.class)
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY) {
            retryCount++;
            System.out.println(">>> Retrying test [" + result.getName() + "] – Attempt " + retryCount + " of " + MAX_RETRY);
            return true;
        }
        return false;
    }
}
