package com.epam.test.ht21.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public static final String BASE_URL = "https://dou.ua/";
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
