package com.epam.test.ht14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {
    private static final String SEARCH_FIELD = ".gLFyf.gsfi";
    private static final String PAGE_LINKS = ".TbwUpd.NJjxre";

    private static final String SEARCH_QUERY = "selenium";
    private static final String WEBSITE_URL = "www.selenium.dev";
    private static final String BASE_URL = "https://google.com";
    private static final String EXPECTED_TEXT = "Selenium automates browsers. That's it!";
    private static final String BANNER_TEXT = ".hero.homepage h1";

    private static WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().browserVersion("85").setup();
        driver = new ChromeDriver();
    }

    @Test
    void keywordSearch(){
        driver.get(BASE_URL);

        WebElement SearchFieldElement = driver.findElement(By.cssSelector(SEARCH_FIELD));
        SearchFieldElement.sendKeys(SEARCH_QUERY);
        SearchFieldElement.submit();

        driver.findElements(By.cssSelector(PAGE_LINKS))
                .stream()
                .filter(each -> each.getText().equals(WEBSITE_URL))
                .findFirst().get().click();

        String actualUrl = driver.getCurrentUrl();
        String actualText = driver.findElement(By.cssSelector(BANNER_TEXT)).getText();

        assertTrue(actualUrl.contains(SEARCH_QUERY));
        assertTrue(actualText.equals(EXPECTED_TEXT));
    }

    @AfterEach
    void destroy(){
        driver.close();
    }
}
