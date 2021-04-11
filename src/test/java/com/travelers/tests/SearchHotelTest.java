package com.travelers.tests;

import com.travelers.BaseSeleniumTest;
import com.travelers.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchHotelTest extends BaseSeleniumTest {


    @Test
    public void searchHotel() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver);
        homePage.addLocation("Dubai");
        homePage.addDate("01/12/2021", "05/12/5021");
        homePage.addPerson(1, 3);
        //Thread.sleep(5005);
        List<String> hotelName = homePage.getHotels();
        List<String> prices = homePage.getPrices();

        List<String> orginalNames = new ArrayList<>();
        orginalNames.add("Jumeirah Beach Hotel");
        orginalNames.add("Oasis Beach Tower");
        orginalNames.add("Rose Rayhaan Rotana");
        orginalNames.add("Hyatt Regency Perth");
        Assert.assertEquals(orginalNames,hotelName);

        List<String> orginalPrices = new ArrayList<>();
        orginalPrices.add("USD $22");
        orginalPrices.add("USD $50");
        orginalPrices.add("USD $80");
        orginalPrices.add("USD $150");
        Assert.assertEquals(orginalPrices,prices);

    }


}
