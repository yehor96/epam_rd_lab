package com.epam.test.ht17.tests;

import com.epam.test.ht17.pages.HomePage;
import com.epam.test.ht17.pages.SignInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NegativeTests {
    static WebDriver driver;
    static final String BASE_URL = "https://www.olx.ua/";

    @BeforeClass
    static void beforeAll(){
        WebDriverManager.chromedriver().browserVersion("85").setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void setUp(){
        driver.get(BASE_URL);
    }

    @Test
    void testErrorsDisplayedWhenLogInWithBlankFields(){
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickOnMyProfileButton();

        signInPage.clickLoginButton();
        assertTrue(signInPage.areErrorMessagesEmptyDisplayed());
    }

    @Test
    void testErrorAfterInvalidLoginEntry(){
        String value = "test";

        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickOnMyProfileButton();

        signInPage.setLoginField(value);
        signInPage.setPasswordField(value);

        assertTrue(signInPage.IsErrorMessageInvalidLoginDisplayed());
    }

    @Test
    void testNotPossibleToLoginWithInvalidData(){
        String value = "test@Test1.com";

        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickOnMyProfileButton();

        signInPage.setLoginField(value);
        signInPage.setPasswordField(value);

        signInPage.clickLoginButton();

        assertTrue(signInPage.IsErrorMessageInvalidPasswordDisplayed());
    }
}
