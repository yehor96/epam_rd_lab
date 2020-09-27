package com.epam.test.ht16.task2.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
