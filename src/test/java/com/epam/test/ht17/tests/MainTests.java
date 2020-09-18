package com.epam.test.ht17.tests;

import com.epam.test.ht17.pages.ForgetPasswordPage;
import com.epam.test.ht17.pages.SearchResultPage;
import com.epam.test.ht17.pages.SignInPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTests extends BaseTest {
    @Test
    void testForgetPassword(){
        String value = "test@email.com";

        SignInPage signInPage = homePage.clickOnMyProfileButton();

        ForgetPasswordPage forgetPasswordPage = signInPage.clickForgetPasswordButton();
        forgetPasswordPage.fillOutLoginField(value);
        forgetPasswordPage.clickChangeButton();

        assertTrue(forgetPasswordPage.isNewPassLabelDisplayed());
    }

    /**
     * Failing
     */
    @Test
    void testSearchByQuery(){
        String query = "Java";

        SearchResultPage searchResultPage = homePage.searchInfo(query);

        searchResultPage.getItemTexts()
                .forEach(text -> assertTrue(
                        text.contains(query) ||
                                text.contains(query.toLowerCase())));
    }

    @Test
    void testNewPostRequest(){
        homePage.clickOnNewPostButton();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("account"));

        assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    void testChangeLanguage(){
        String uaLang = "Ukrainian";
        String ruLang = "Russian";

        homePage.setLanguage(uaLang);
        assertEquals(homePage.getCurrentLanguage(), uaLang);

        homePage.setLanguage(ruLang);
        assertEquals(homePage.getCurrentLanguage(), ruLang);
    }

    /**
     * Failing
     */
    @Test
    void testQueryTextDisplayAfterSearching(){
        String query = "Java";

        SearchResultPage searchResultPage = homePage.searchInfo(query);

        String displayedText = searchResultPage.getSearchFieldContent();
        assertEquals(displayedText, query);
    }

    @Test
    void testGetOlxCareers(){
        homePage.clickOnCareersButton();

        ArrayList<String> windows = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("olxgroup"));
        assertTrue(driver.getCurrentUrl().contains("olxgroup"));
    }

    @Test
    void testShowAllAds(){
        SearchResultPage searchResultPage = homePage.clickOnShowAllButton();

        assertTrue(searchResultPage.getListOfItems().size() > 30);
    }

    @Test
    void testRegionsListDisplay(){
        homePage.clickOnRegionsList();

        assertTrue(homePage.isRegionsListDisplayed());
    }

    /**
     * Failing
     */
    @Test
    void testSearchByAllRegions(){
        String value = "Java";

        SearchResultPage searchResultPage = homePage.searchInfoByAllRegions(value);
        assertTrue(searchResultPage.isAllRegionsDisplayed());
    }

    @Test
    void testSearchByEmptyQuery(){
        SearchResultPage searchResultPage = homePage.clickOnSearchButton();

        assertTrue(searchResultPage.getListOfItems().size() > 30);
    }

    /**
     * Failing
     */
    @Test
    void testAddToFavorites() {
        SearchResultPage searchResultPage = homePage.clickOnSearchButton();

        searchResultPage.addToFavorites(1);
        searchResultPage.refreshPage();

        assertEquals("1", searchResultPage.getCountOfFavorites());
    }
}
