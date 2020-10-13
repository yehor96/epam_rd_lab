package com.epam.test.ht16.task2.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TodoPage extends BasePage {
    private static final String TODO_FIELD = "//input[@class='new-todo']";
    private static final String TODO_CHECKBOX = "//input[@class='toggle']";
    private static final String TODO_COMPLETED_ITEM = "//ul[@class='todo-list']/li[@class='completed']//label";

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    public void addItem(String item) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(TODO_FIELD)));

        WebElement field = driver.findElement(By.xpath(TODO_FIELD));

        field.click();
        field.sendKeys(item);
        field.sendKeys(Keys.ENTER);
    }

    public void markAllItemsComplete() {
        try {
            for (var each : driver.findElements(By.xpath(TODO_CHECKBOX))) {
                each.click();
            }
        } catch (NoSuchElementException e){
            System.out.println("There are no items to complete.");
        }
    }

    public int getHowManyItemsAreCompleted(){
        try {
            return driver.findElements(By.xpath(TODO_COMPLETED_ITEM)).size();
        } catch (NoSuchElementException e){
            return 0;
        }
    }
}
