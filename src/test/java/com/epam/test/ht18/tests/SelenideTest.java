package com.epam.test.ht18.tests;

import com.epam.test.ht18.pages.GoogleSearchPage;
import com.epam.test.ht18.pages.SeleniumDevMainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelenideTest extends AbstractTest {
    private static final String SEARCH_QUERY = "selenium";
    private static final String WEBSITE_URL = "www.selenium.dev";
    private static final String EXPECTED_TEXT = "Selenium automates browsers. That's it!";

    @Test
    void testKeywordSearch(){
        //GIVEN
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.openMainPage();

        //WHEN
        googleSearchPage.searchFoValue(SEARCH_QUERY);
        googleSearchPage.openLinkWithUrl(WEBSITE_URL);

        SeleniumDevMainPage seleniumDevMainPage = new SeleniumDevMainPage();
        String actualUrl = seleniumDevMainPage.getCurrentUrl();
        String actualText = seleniumDevMainPage.getBannerText();

        //THEN
        assertTrue(actualUrl.contains(SEARCH_QUERY));
        assertEquals(actualText, EXPECTED_TEXT);
    }
}
