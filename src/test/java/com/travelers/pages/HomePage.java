package com.travelers.pages;

import com.travelers.BaseSeleniumTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseSeleniumTest {

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchSpan;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private List<WebElement> searchCityInput;

    @FindBy(xpath = "//body/div[@id='body-section']/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]")
    private WebElement checkIn;

    @FindBy(name = "checkout")
    private WebElement checkOut;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void addLocation(String location) {



        this.searchSpan.click();
        this.searchCityInput.get(0).sendKeys(location);
        this.searchCityInput.get(0).sendKeys(Keys.ENTER);
        this.checkIn.sendKeys("1/12/2021");
        this.checkIn.sendKeys(Keys.ENTER);


    }



}
