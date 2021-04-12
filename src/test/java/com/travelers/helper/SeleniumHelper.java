package com.travelers.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class SeleniumHelper {

    private WebDriver driver;

    public SeleniumHelper(WebDriver driver) {
        this.driver = driver;
    }

    public FluentWait<WebDriver> configureFluentWait(int withTimeout, int duration) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(withTimeout))
                .pollingEvery(Duration.ofMillis(duration))
                .ignoring(NoSuchElementException.class);
        return wait;
    }

    public void waitForElementToBeDisplayed(By locator) {
        FluentWait<WebDriver> wait = this.configureFluentWait(15, 1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeDisplayed(WebElement element) {
        FluentWait<WebDriver> wait = this.configureFluentWait(15, 1000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForListSize(List<WebElement> elementList) {
        FluentWait<WebDriver> wait = this.configureFluentWait(20, 10000);
        Boolean until = wait.until(driver1 ->
                elementList.size() > 0);
    }

    public static void takeScreenshot(WebDriver driver) throws IOException {

        TakesScreenshot screen = (TakesScreenshot) driver;
        File screenFile = screen.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("src/test/java/com/travelers/screenshot/" + LocalTime.now().getNano() + ".png");
        Files.copy(screenFile.toPath(),destinationFile.toPath());

    }

}
