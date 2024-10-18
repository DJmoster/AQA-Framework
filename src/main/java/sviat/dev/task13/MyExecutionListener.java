package sviat.dev.task13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IExecutionListener;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MyExecutionListener implements ISuiteListener, IExecutionListener, IInvokedMethodListener {
    protected final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
        logger.info(suite.getName());
    }

    @Override
    public void onExecutionFinish() {
        IExecutionListener.super.onExecutionFinish();
        logger.info("Execution finished");
    }
}
