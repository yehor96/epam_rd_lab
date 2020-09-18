package com.epam.test.ht17.tests;

import com.epam.test.ht17.pages.SignInPage;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NegativeTests extends BaseTest {
    @Test
    void testErrorsDisplayedWhenLogInWithBlankFields(){
        SignInPage signInPage = homePage.clickOnMyProfileButton();

        signInPage.clickLoginButton();
        assertTrue(signInPage.areErrorMessagesEmptyDisplayed());
    }

    @Test
    void testErrorAfterInvalidLoginEntry(){
        String value = "test";

        SignInPage signInPage = homePage.clickOnMyProfileButton();

        signInPage.setLoginField(value);
        signInPage.setPasswordField(value);

        assertTrue(signInPage.IsErrorMessageInvalidLoginDisplayed());
    }

    @Test
    void testNotPossibleToLoginWithInvalidData(){
        String value = "test@Test1.com";

        SignInPage signInPage = homePage.clickOnMyProfileButton();

        signInPage.setLoginField(value);
        signInPage.setPasswordField(value);

        signInPage.clickLoginButton();

        assertTrue(signInPage.IsErrorMessageInvalidPasswordDisplayed());
    }
}
