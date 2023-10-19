package Retry;

import org.testng.ITestResult;
import org.testng.IRetryAnalyzer;


public class RetryAnalyzer implements IRetryAnalyzer {
    private int maxRetry = 3;
    private int count = 0;

    public boolean retry (ITestResult iTestResult) {
        if (count<maxRetry){
            count++;
            return true;
        }
        return false;
    }

}
