package com.epam.test.ht21.steps;

import com.epam.test.ht21.pages.JobSearchPage;
import com.epam.test.ht21.pages.JuniorDigestPage;
import com.epam.test.ht21.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseStepDefinitions {
    public WebDriver driver;
    public static final String BASE_URL = "https://dou.ua/";

    MainPage mainPage;
    JobSearchPage jobSearchPage;
    JuniorDigestPage juniorDigestPage;

    public void setUpDriver(){
        WebDriverManager.chromedriver().browserVersion("85").setup();
        driver = new ChromeDriver();
    }
}
