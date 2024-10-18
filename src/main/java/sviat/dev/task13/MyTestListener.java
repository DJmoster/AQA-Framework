package sviat.dev.task13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class MyTestListener implements ITestListener {
    protected final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info(result.getMethod().getMethodName() + " " + result.getMethod().getDescription());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        logger.info(result.getMethod().getMethodName() + " " + result.getMethod().getDescription());
    }
}
