package com.epam.test.ht15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DouTest {
    private static final String BASE_URL = "https://dou.ua/";
    private static final String LOGIN_MENU = "login-link";
    private static final String CHECKBOX = "agree-checkbox";
    private static final String LOGIN_OPTIONS_MENU = ".b-login-dialog.__disabled";
    private static final String JOBS_SECTION = "//a[@href='https://jobs.dou.ua/']";
    private static final String JOB_SEARCH_FIELD = ".job";
    private static final String COMPANY_ICON = ".company";

    private static final String SEARCH_QUERY = "EPAM";

    private static WebDriver driver;

    @BeforeAll
    static void beforeAll(){
        WebDriverManager.chromedriver().browserVersion("85").setup();
    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @Test
    void testImpossibleToLogInWithoutTermsCheckbox(){
        driver.findElement(By.id(LOGIN_MENU)).click();
        driver.findElement(By.id(CHECKBOX)).click();

        assertTrue(driver.findElement(By.cssSelector(LOGIN_OPTIONS_MENU)).isDisplayed());
    }

    @Test
    void testSearchByCompany(){
        driver.findElement(By.xpath(JOBS_SECTION)).click();

        WebElement searchField = driver.findElement(By.cssSelector(JOB_SEARCH_FIELD));
        searchField.click();
        searchField.sendKeys(SEARCH_QUERY);
        searchField.submit();

        String actualCompanyName = driver.findElement(By.cssSelector(COMPANY_ICON)).getText();

        assertTrue(actualCompanyName.contains(SEARCH_QUERY));
    }

    @AfterEach
    void destroy(){
        driver.close();
    }
}
