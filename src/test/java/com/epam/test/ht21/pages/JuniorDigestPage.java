package com.epam.test.ht21.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JuniorDigestPage extends BasePage {
    private static final String EPAM_TABLE_VALUE = "//table/tbody/tr[3]/td[3]";

    public JuniorDigestPage(WebDriver driver) {
        super(driver);
    }

    public int getJuniorsByCompany() {
        return Integer.parseInt(driver.findElement(By.xpath(EPAM_TABLE_VALUE)).getText());
    }
}
