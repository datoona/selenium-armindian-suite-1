package listerners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SuiteListener implements ITestListener {
    public static final Logger LOG = Logger.getLogger(SuiteListener.class);
    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("Started -----> " + result.getMethod().getQualifiedName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("PASSED -----> " + result.getMethod().getQualifiedName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("FAILED -----> " + result.getMethod().getQualifiedName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOG.info("SKIPPED -----> " + result.getMethod().getQualifiedName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
