package com.travelers.tests;

import com.aventstack.extentreports.ExtentTest;
import com.travelers.BaseSeleniumTest;
import com.travelers.helper.ExcelHelper;
import com.travelers.helper.TestListener;
import com.travelers.pages.HomePage;
import com.travelers.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Listeners(TestListener.class)
public class SearchHotelTest extends BaseSeleniumTest {


    @Test(dataProvider = "getData")
    void searchHotel(String city, String checkInDate, String checkOutDate, String firstHotel, String firstPrice, String secondHotel, String secondPrice) throws IOException {

        ExtentTest test = reports.createTest("searchHotelTest");
        // driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver);

        test.info("On homePage");

        homePage.addLocation(city)
                .addDate(checkInDate, checkOutDate)
                .addPerson(1, 3);


        test.info(" wpisanie wytycznych + wyszukanie", getScreenshot());

        ResultPage result = new ResultPage(driver);
        List<String> hotelName = result.getHotels();
        //SeleniumHelper.takeScreenshot(driver);
        List<String> prices = result.getPrices();
        test.info("rezultaty wyszukane, zaraz bedzie wykonane sprawdzenie", getScreenshot());

        //List<String> orginalNames = new ArrayList<>();
        // orginalNames.add(firstHotel);
        // orginalNames.add(secondHotel);
        // orginalNames.add("Rose Rayhaan Rotana");
        // orginalNames.add("Hyatt Regency Perth");
        // Assert.assertEquals(hotelName, orginalNames);
        Assert.assertEquals(hotelName.get(0), firstHotel);
        //Assert.assertEquals(hotelName.get(1), secondHotel);
        test.info("juz po asercji nazw hoteli", getScreenshot());
//        List<String> orginalPrices = new ArrayList<>();
//        orginalPrices.add(firstPrice);
//        orginalPrices.add(secondPrice);
//        orginalPrices.add("USD $80");
//        orginalPrices.add("USD $150");
        //Assert.assertEquals(prices, orginalPrices);
        Assert.assertEquals(prices.get(0), firstPrice);
        test.info("juz po asercji cen", getScreenshot());

    }

    @DataProvider
    public Object[][] getData() {

        Object[][] data = null;
        try {
            data = ExcelHelper.readExcelFile(new File("src//main//resources//Files//daneTestowe.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }



}
