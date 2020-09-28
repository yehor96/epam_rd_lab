package com.epam.test.ht17.tests;

import com.epam.test.ht17.pages.BasePage;
import com.epam.test.ht17.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.epam.test.ht17.DriverHolder.getDriver;

public class BaseTest {
    static WebDriver driver;
    HomePage homePage;

    @BeforeClass
    static void beforeAll(){
        driver = getDriver();
    }

    @BeforeMethod
    void setUp(){
        driver.get(BasePage.BASE_URL);
        homePage = new HomePage(driver);
    }

    @AfterClass
    static void afterAll(){
        driver.close();
    }
}
