package com.karpuk.clashtrack.core.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static Logger logger = LogManager.getLogger();

    @Override
    public synchronized void onStart(ITestContext context) {
        logInfo("Extent Reports Version 3 Test Suite started!");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        logInfo(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        logInfo((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        test.set(extentTest);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        logInfo((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        logInfo((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable());
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        logInfo((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logInfo(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }

    public static synchronized void logInfo(String data) {
        if (test.get() != null) {
            test.get().info(data);
        }
        logger.info(data);
    }

    public static synchronized void logWarn(String data) {
        if (test.get() != null) {
            test.get().warning(data);
        }
        logger.warn(data);
    }

    public static synchronized void logError(String data) {
        if (test.get() != null) {
            test.get().error(data);
        }
        logger.error(data);
    }

    public static synchronized void logDebug(String data) {
        if (test.get() != null) {
            test.get().debug(data);
        }
        logger.debug(data);
    }

}
