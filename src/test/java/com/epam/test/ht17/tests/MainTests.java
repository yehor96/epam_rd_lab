package com.epam.test.ht17.tests;

import com.epam.test.ht17.pages.HomePage;
import com.epam.test.ht17.pages.SearchResultPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    void testSearchByDefaultLocation(){
        String query = "Java";

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.searchInfo(query);

        searchResultPage.getItemTexts()
                .forEach(text -> assertTrue(text.contains(query)));
    }

    @Test
    void testSearchByCustomLocation(){
        String query = "Java";
        String location = "Lviv";

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.searchInfo(query, location);

        searchResultPage.getItemTexts()
                .forEach(text -> assertTrue(text.contains(query)));
        searchResultPage.getItemLocationTexts()
                .forEach(text -> assertTrue(text.contains(location)));
    }

    @Test
    void testSearchWithEmptyQuery(){

    }

    @Test
    void testQueryTextDisplayAfterSearching(){
        String query = "Java";

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.searchInfo(query);

        String displayedText = searchResultPage.getSearchFieldContent();
        assertEquals(displayedText, query);
    }
}
