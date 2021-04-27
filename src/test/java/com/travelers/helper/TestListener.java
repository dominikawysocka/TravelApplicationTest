package com.travelers.helper;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {

    //Logger log = Logger.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult iTestResult){
      //  log.debug("on test start");
        try {
            SeleniumHelper.takeScreenshot(DriveFactory.getDriver(DriverType.CHROME));
        } catch (IOException e) {
        //    log.error(e.getStackTrace());
        } catch (NoSuchDriverException e) {
            e.printStackTrace();
        }
    }

}
