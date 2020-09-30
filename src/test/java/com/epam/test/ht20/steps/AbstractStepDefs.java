package com.epam.test.ht20.steps;

import com.epam.test.ht20.pages.*;
import org.openqa.selenium.WebDriver;

import static com.epam.test.ht17.DriverHolder.getDriver;

public abstract class AbstractStepDefs {
    static WebDriver driver;

    HomePage homePage;
    SignInPage signInPage;
    ForgetPasswordPage forgetPasswordPage;
    SearchResultPage searchResultPage;

    void setUp(){
        driver = getDriver();
        driver.get(BasePage.BASE_URL);
        homePage = new HomePage(driver);
    }
}
