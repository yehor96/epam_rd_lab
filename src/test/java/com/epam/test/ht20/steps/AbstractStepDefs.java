package com.epam.test.ht20.steps;

import com.epam.test.ht20.pages.ForgetPasswordPage;
import com.epam.test.ht20.pages.HomePage;
import com.epam.test.ht20.pages.SearchResultPage;
import com.epam.test.ht20.pages.SignInPage;

import static com.epam.test.ht20.DriverHolder.getDriver;


public abstract class AbstractStepDefs {
    HomePage homePage = new HomePage(getDriver());
    SignInPage signInPage = new SignInPage(getDriver());
    ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage(getDriver());
    SearchResultPage searchResultPage = new SearchResultPage(getDriver());
}
