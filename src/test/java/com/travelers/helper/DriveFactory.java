package com.travelers.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import java.io.File;

public class DriveFactory {

    private static WebDriver driverInstance;

    public static WebDriver getDriver(DriverType driverType) throws NoSuchDriverException {
        if (driverInstance == null) {

            driverInstance = specificDriver(driverType);
            driverInstance.manage().window().maximize();
        }
        return driverInstance;
    }

    private static WebDriver specificDriver(DriverType driverType) throws NoSuchDriverException {

        switch (driverType) {

            case FIREFOX:
                File driverExeFirefox = new File("src//main//executables//drivers//geckodriver.exe");
                GeckoDriverService firefoxService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(driverExeFirefox)
                        .usingAnyFreePort().build();
                driverInstance = new FirefoxDriver(firefoxService);
                break;
            case CHROME:
                File driverExeChrome = new File("src///main//executables//drivers//chromedriver.exe");
                ChromeDriverService chromeService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(driverExeChrome)
                        .usingAnyFreePort().build();
                driverInstance = new ChromeDriver(chromeService);
                break;
            case IE:
                File driverExeIE = new File("src//main//executables//drivers//IEDriverServer.exe");
                InternetExplorerDriverService IEService = new InternetExplorerDriverService.Builder()
                        .usingDriverExecutable(driverExeIE)
                        .usingAnyFreePort().build();
                driverInstance = new InternetExplorerDriver(IEService);
                break;

            default:
                System.out.println("Nieznany typ drivera");
                throw new NoSuchDriverException();

        }
        return driverInstance;
    }

    public static void resetDriver() {
        driverInstance = null;
    }
}

