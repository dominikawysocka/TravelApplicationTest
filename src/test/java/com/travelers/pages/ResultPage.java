package com.travelers.pages;

import com.travelers.helper.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultPage {

    private SeleniumHelper helper;

    private WebDriver driver;

    @FindBy(xpath = "//table[@class='bgwhite table table-striped']")
    private WebElement hotelList;

    @FindBy(xpath = "//h4//b")
    private WebElement results;

    public ResultPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.helper = new SeleniumHelper(driver);
    }


    public List<String> getHotels() {
        helper.waitForElementToBeDisplayed(By.xpath("//h4//b"));
        List<WebElement> hotelName = hotelList.findElements(By.xpath("//h4//b"));
        List<String> hotelNames = new ArrayList<>();
        helper.waitForListSize(hotelName);
        for (WebElement element : hotelName) {
            hotelNames.add(element.getText());
        }
        return hotelNames;

    }

    public List<String> getPrices() {

        List<WebElement> price = hotelList.findElements(By.xpath("//div[@class='fs26 text-center']"));
        helper.waitForListSize(price);
        List<String> prices = new ArrayList<>();
        for (WebElement element : price) {
            prices.add(element.getText());
        }

        return prices;
    }
}
