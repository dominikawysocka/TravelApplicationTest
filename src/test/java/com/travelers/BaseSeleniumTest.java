package com.travelers;

import com.travelers.helper.DriveFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public abstract class BaseSeleniumTest {


    protected static WebDriver driver;

    @BeforeClass
    public void setup() {

        // String driverPath = "E://ProjektyzProgramowania//tutorialselenium//src//main//executables//drivers//chromedriver.exe";
        //System.setProperty("webdriver.chrome.driver", driverPath);

        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver = DriveFactory.getDriver();
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }


}
