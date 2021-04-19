package com.travelers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.travelers.helper.DriveFactory;
import com.travelers.helper.DriverType;
import com.travelers.helper.NoSuchDriverException;
import com.travelers.helper.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;


public abstract class BaseSeleniumTest {


    protected static WebDriver driver;
    protected ExtentHtmlReporter reporter;
    protected ExtentReports reports;

    @BeforeTest
    public void setUpReporter(){
        reporter = new ExtentHtmlReporter("src//main//resources//reports//index.html");
        reports = new ExtentReports();
        reports.attachReporter(reporter);
    }

    @BeforeMethod
    public void setup() throws NoSuchDriverException {
        driver = DriveFactory.getDriver(DriverType.CHROME);
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
        DriveFactory.resetDriver();
    }

    @AfterTest
    public void tearDownReports(){
        reporter.flush();
        reports.flush();
    }

    protected MediaEntityModelProvider getScreenshot() throws IOException {
        return MediaEntityBuilder.createScreenCaptureFromPath(SeleniumHelper.takeScreenshot(driver)).build();
    }

}
