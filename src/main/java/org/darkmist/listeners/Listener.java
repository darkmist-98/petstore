package org.darkmist.listeners;

import com.aventstack.extentreports.ExtentTest;
import org.darkmist.extentReport.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.initReport();
        String methodName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();
        ExtentManager.startTest(methodName, description != null ? description : "No description");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().pass("Test passes");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getTest().fail("Test failed: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().skip("Test skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flushReport();
    }

}
