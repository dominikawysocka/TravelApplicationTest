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

    @FindBy(xpath = " //body/div[@id='select2-drop']/ul[1]/li[1]/ul[1]/li[1]/div[1]")
    private WebElement confirmPlace;

    @FindBy(xpath = "//body/div[@id='body-section']/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/input[1]")
    private WebElement checkOut;

    @FindBy(xpath = "//input[@id='travellersInput']")
    private WebElement person;

    @FindBy(xpath = "//body/div[@id='body-section']/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[2]/button[1]/i[1]")
    private WebElement plusJunior;

    @FindBy(xpath = "//button[@id='adultPlusBtn']")
    private WebElement plusAdult;

    @FindBy(xpath = "//button[@id='childMinusBtn']")
    private WebElement minusJunior;

    @FindBy(xpath = "//button[@id='adultMinusBtn']")
    private WebElement minusAdult;

    @FindBy(xpath = "//body/div[@id='body-section']/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/button[1]")
    private WebElement search;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void addLocation(String location) {

        this.searchSpan.click();
        this.searchCityInput.get(0).sendKeys(location);
        this.searchCityInput.get(0).sendKeys(Keys.ENTER);
        confirmPlace.click();
        // this.checkIn.sendKeys("1/12/2021");
        // this.checkOut.sendKeys("5/12/2021");
        // this.person.click();
        // this.plusAdult.click();
        // this.plusJunior.click();
        // search.click();

    }

    public void addDate(String beginDate, String endDate) {
        this.checkIn.sendKeys(beginDate);
        this.checkOut.sendKeys(endDate);
    }

    public void addPerson(Integer adult, Integer junior) {

        this.person.click();
        if (adult < 2) {
            for (int i = 0; i < 2 - adult; i++) {
                minusAdult.click();
            }
        }
        if (adult > 2) {
            for (int i = 0; i < adult - 2; i++) {
                plusAdult.click();
            }
        }

        if (junior > 2) {
            for (int i = 0; i < junior; i++) {
                plusJunior.click();
            }
        }
//        this.plusAdult.click();
//        this.minusAdult.click();
//        this.plusJunior.click();
//        this.minusJunior.click();
        search.click();

    }

}
