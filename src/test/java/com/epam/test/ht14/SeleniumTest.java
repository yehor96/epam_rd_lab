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
    private static final String SEARCH_RESULT = ".LC20lb.DKV0Md";

    private static final String SEARCH_QUERY = "Selenium";
    private static final String BASE_URL = "https://google.com";

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

        driver.findElements(By.cssSelector(SEARCH_RESULT)).get(0).click();

        String actualUrl = driver.getCurrentUrl();

        assertTrue(actualUrl.contains(SEARCH_QUERY));
    }

    @AfterEach
    void destroy(){
        driver.close();
    }
}
