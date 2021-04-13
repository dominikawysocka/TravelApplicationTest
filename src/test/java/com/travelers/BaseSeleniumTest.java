package com.travelers;

import com.travelers.helper.DriveFactory;
import com.travelers.helper.DriverType;
import com.travelers.helper.NoSuchDriverException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public abstract class BaseSeleniumTest {


    protected static WebDriver driver;

    @BeforeClass
    public void setup() throws NoSuchDriverException {
        driver = DriveFactory.getDriver(DriverType.FIREFOX);
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }


}
