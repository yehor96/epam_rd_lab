package com.epam.test.ht20.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralStepDefs extends AbstractStepDefs {
    @Then("Current Url contains {string} string")
    public void currentUrlContainsString(String text) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains(text));

        assertTrue(driver.getCurrentUrl().contains(text));
    }

    @When("I navigate to newly opened page")
    public void iNavigateToNewlyOpenedPage() {
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
