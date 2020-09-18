package com.epam.test.ht17.tests;

import com.epam.test.ht17.DriverHolder;
import com.epam.test.ht17.pages.BasePage;
import com.epam.test.ht17.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    static WebDriver driver;
    HomePage homePage;

    @BeforeClass
    static void beforeAll(){
        DriverHolder.setUpVersion(85);
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void setUp(){
        driver.get(BasePage.BASE_URL);
        homePage = new HomePage(driver);
    }
}
