package com.travelers.tests;

import annotation.TestListener;
import com.travelers.BaseSeleniumTest;
import com.travelers.pages.HomePage;
import com.travelers.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Listeners(TestListener.class)
public class SearchHotelTest extends BaseSeleniumTest {


    @Test
    public void searchHotel() throws IOException {

        // driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver);
        homePage.addLocation("Dubai")
                .addDate("01/12/2021", "05/12/5021")
                .addPerson(1, 3);
        // homePage.addDate("01/12/2021", "05/12/5021");
        //homePage.addPerson(1, 3);

        ResultPage result = new ResultPage(driver);
        List<String> hotelName = result.getHotels();
        //SeleniumHelper.takeScreenshot(driver);
        List<String> prices = result.getPrices();


        List<String> orginalNames = new ArrayList<>();
        orginalNames.add("Jumeirah Beach Hotel");
        orginalNames.add("Oasis Beach Tower");
        orginalNames.add("Rose Rayhaan Rotana");
        orginalNames.add("Hyatt Regency Perth");
        Assert.assertEquals(hotelName, orginalNames);

        List<String> orginalPrices = new ArrayList<>();
        orginalPrices.add("USD $22");
        orginalPrices.add("USD $50");
        orginalPrices.add("USD $80");
        orginalPrices.add("USD $150");
        Assert.assertEquals(prices, orginalPrices);

    }


}
