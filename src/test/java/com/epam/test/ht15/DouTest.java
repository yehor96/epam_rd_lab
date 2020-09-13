package com.epam.test.ht15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.test.ht15.Locators.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DouTest {
    private static final String BASE_URL = "https://dou.ua/";
    private static WebDriver driver;

    @BeforeAll
    static void beforeAll(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().browserVersion("85").setup();
    }

    @BeforeEach
    void setUp(){
        driver.get(BASE_URL);
    }

    @Test
    void testLoginOptionsDisabledWithoutTermsCheckbox(){
        driver.findElement(By.id(LOGIN_MENU)).click();
        driver.findElement(By.id(CHECKBOX)).click();

        assertTrue(driver.findElement(By.cssSelector(LOGIN_OPTIONS_MENU)).isDisplayed());
    }

    @Test
    void testSearchByCompany(){
        final String SEARCH_QUERY = "EPAM";

        driver.findElement(By.xpath(JOBS_SECTION)).click();

        WebElement searchField = driver.findElement(By.cssSelector(JOB_SEARCH_FIELD));
        searchField.click();
        searchField.sendKeys(SEARCH_QUERY);
        searchField.submit();

        String actualCompanyName = driver.findElement(By.cssSelector(COMPANY_ICON)).getText();

        assertTrue(actualCompanyName.contains(SEARCH_QUERY));
    }

    @Test
    void testQAFestLinkOnBanner(){
        final String EXTERNAL_LINK_TEXT = "qafest";

        driver.findElement(By.cssSelector(HEADER_BANNER_LINK)).click();

        assertTrue(driver.getCurrentUrl().contains(EXTERNAL_LINK_TEXT));
    }

    @Test
    void testItIsPossibleToCloseHeaderBanner(){
        WebElement banner = driver.findElement(By.cssSelector(HEADER_BANNER));
        driver.findElement(By.cssSelector(HEADER_BANNER_CLOSING_BUTTON)).click();

        new WebDriverWait(driver, 5)
        .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(HEADER_BANNER)));

        assertFalse(banner.isDisplayed());
    }

    @Test
    void testItIsPossibleToSearchJobsByPosition(){
        final String SEARCH_LANG = "Java";

        driver.findElement(By.xpath(JOBS_SECTION)).click();

        Select dropDown = new Select(driver.findElement(By.cssSelector(JOB_SEARCH_DROPDOWN)));
        dropDown.selectByVisibleText(SEARCH_LANG);

        String actualText = driver.findElement(By.cssSelector(JOB_SEARCH_RESULT)).getText();

        assertTrue(actualText.contains(SEARCH_LANG));
    }

    @Test
    void testEpamHiresALotOfJuniors(){
        driver.findElement(By.xpath(JUNIOR_DIGEST_SECTION)).click();

        int actualValue = Integer.parseInt(driver.findElement(By.xpath(EPAM_TABLE_VALUE)).getText());

        assertTrue(actualValue > 500);
    }
}
