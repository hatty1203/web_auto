package com.lemon.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestngRetry implements IRetryAnalyzer {
    public int maxRetryCount = 2;
    public int currentRetryCount = 0;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentRetryCount < maxRetryCount) {
            currentRetryCount++;
            return true;
        } else {
            return false;
        }
    }
}
