package com.travelers;

import com.travelers.helper.DriveFactory;
import com.travelers.helper.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public abstract class BaseSeleniumTest {


    protected static WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = DriveFactory.getDriver(DriverType.CHROME);
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }


}
