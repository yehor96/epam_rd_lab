package com.epam.test.ht21.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.epam.test.ht15.Locators.COMPANY_ICON;

public class JobSearchPage extends BasePage {
    private static final String JOB_SEARCH_FIELD = ".job";
    private static final String JOB_SEARCH_DROPDOWN = ".b-jobs-search select";
    private static final String JOB_SEARCH_RESULT = ".b-inner-page-header h1";

    public JobSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFieldByQuery(String query) {
        WebElement searchField = driver.findElement(By.cssSelector(JOB_SEARCH_FIELD));

        searchField.click();
        searchField.sendKeys(query);
        searchField.submit();
    }

    public String getCompanyNameFromResults() {
        return driver.findElement(By.cssSelector(COMPANY_ICON)).getText();
    }

    public void selectValueFromDropDown(String position_name) {
        Select dropDown = new Select(driver.findElement(By.cssSelector(JOB_SEARCH_DROPDOWN)));

        dropDown.selectByVisibleText(position_name);
    }

    public String getSearchByPositionResults() {
        return driver.findElement(By.cssSelector(JOB_SEARCH_RESULT)).getText();
    }
}
