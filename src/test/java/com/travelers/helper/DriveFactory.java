package com.travelers.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriveFactory {

    private static WebDriver driverInstance;

    public static WebDriver getDriver() {
        if (driverInstance == null) {
            String driverPath = "E://ProjektyzProgramowania//tutorialselenium//src//main//executables//drivers//chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);

            driverInstance = new ChromeDriver();
            driverInstance.manage().window().maximize();

        }
        return driverInstance;
    }
}

