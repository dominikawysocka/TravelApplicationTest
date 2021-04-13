package com.travelers.helper;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult iTestResult){
        try {
            SeleniumHelper.takeScreenshot(DriveFactory.getDriver(DriverType.CHROME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
