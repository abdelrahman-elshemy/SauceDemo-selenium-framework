package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * RetryAnalyzer automatically re-executes failed test cases to mitigate
 * flaky test results caused by environmental issues or network latency.
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    private int currentAttempt = 0;
    private final int maxRetryLimit = 1;

    // Determines if a failed test should be executed again based on the retry limit
    @Override
    public boolean retry(ITestResult result) {
        if (currentAttempt < maxRetryLimit) {
            currentAttempt++;
            System.out.println("🔄 [RETRY] Retrying test: " + result.getName() + " | Attempt " + currentAttempt + " of " + maxRetryLimit);
            return true;
        }
        return false;
    }
}