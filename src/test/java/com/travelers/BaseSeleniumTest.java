package com.travelers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseSeleniumTest {


        protected static WebDriver driver;

        @BeforeClass
        public void setup() {

            String driverPath = "E://ProjektyzProgramowania//tutorialselenium//src//main//executables//drivers//chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);

            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }

        @AfterClass
        public void tearDown() {

            driver.quit();
        }





}
