package com.epam.test.ht15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DouTest {
    private static final String BASE_URL = "https://google.com";

    private static WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().browserVersion("85").setup();
        driver = new ChromeDriver();

        driver.get(BASE_URL);
    }

    @Test
    void ImpossibleToLogInWithoutTermsAgreement(){



    }

    @AfterEach
    void destroy(){
        driver.close();
    }
}
