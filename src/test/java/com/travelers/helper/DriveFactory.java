package com.travelers.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class DriveFactory {

    private static WebDriver driverInstance;

    public static WebDriver getDriver() {
        if (driverInstance == null) {
            File driverExe = new File("src///main//executables//drivers//chromedriver.exe");
            ChromeDriverService driverService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(driverExe)
                    .usingAnyFreePort().build();

            driverInstance = new ChromeDriver(driverService);
            driverInstance.manage().window().maximize();

        }
        return driverInstance;
    }
}

