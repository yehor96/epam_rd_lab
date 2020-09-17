package com.epam.test.ht17.tests;

import com.epam.test.ht17.pages.HomePage;
import com.epam.test.ht17.pages.SearchResultPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTests {
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
    void testSearchByQuery(){
        String query = "Java";

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.searchInfo(query);

        searchResultPage.getItemTexts()
                .forEach(text -> assertTrue(
                        text.contains(query) ||
                                text.contains(query.toLowerCase())));
    }

    @Test
    void testNewPostRequest(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnNewPostButton();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("account"));

        assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    void testChangeLanguage(){
        String uaLang = "Ukrainian";
        String ruLang = "Russian";
        HomePage homePage = new HomePage(driver);

        homePage.setLanguage(uaLang);
        assertEquals(homePage.getCurrentLanguage(), uaLang);

        homePage.setLanguage(ruLang);
        assertEquals(homePage.getCurrentLanguage(), ruLang);
    }

    /**
     * I do not know why this test fails. It throws NoSuchElementException
     * but the element is visible.
     */
    @Test
    void testQueryTextDisplayAfterSearching(){
        String query = "Java";

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.searchInfo(query);

        String displayedText = searchResultPage.getSearchFieldContent();
        assertEquals(displayedText, query);
    }

    @Test
    void testGetOlxCareers(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCareersButton();

        ArrayList<String> windows = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("olxgroup"));
        assertTrue(driver.getCurrentUrl().contains("olxgroup"));
    }

    @Test
    void testShowAllAds(){
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.clickOnShowAllButton();

        assertTrue(searchResultPage.getListOfItems().size() > 30);
    }
}
