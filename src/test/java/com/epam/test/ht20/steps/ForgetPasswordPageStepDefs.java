package com.epam.test.ht20.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForgetPasswordPageStepDefs extends PageInitializer {
    @When("I complete Forget Password form with {string} value")
    public void iCompleteForgetPasswordFormWithValue(String password) {
        forgetPasswordPage.fillOutLoginField(password);
        forgetPasswordPage.clickChangeButton();
    }

    @Then("New Password label is displayed")
    public void newPasswordLabelIsDisplayed() {
        assertTrue(forgetPasswordPage.isNewPassLabelDisplayed());
    }
}
