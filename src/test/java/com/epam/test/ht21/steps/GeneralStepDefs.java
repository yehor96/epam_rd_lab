package com.epam.test.ht21.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralStepDefs extends BaseStepDefs {
    @Then("Current Url does not contain {string}")
    public void currentUrlContains(String text) {
        assertThat(driver.getCurrentUrl()).doesNotContain(text);
    }

    @When("I switch to newly open tab")
    public void iSwitchToNewlyOpenTab() {
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
    }
}
