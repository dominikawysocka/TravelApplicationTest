package com.travelers.tests;

import com.travelers.BaseSeleniumTest;
import com.travelers.pages.HomePage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchHotelTest extends BaseSeleniumTest {


@Test
public void searchHotel(){

    driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
    driver.get("http://www.kurs-selenium.pl/demo/");
    HomePage homePage = new HomePage(driver);
    homePage.addLocation("Dubai");

}


}
