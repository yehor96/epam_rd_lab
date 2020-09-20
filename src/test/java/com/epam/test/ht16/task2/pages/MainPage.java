package com.epam.test.ht16.task2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public TodoPage openToDoPage(Pages page){
        driver.findElement(By.xpath(page.getLocator())).click();
        return new TodoPage(driver);
    }
}