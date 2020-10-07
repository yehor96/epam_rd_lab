package com.epam.test.ht20.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignInStepDefs extends PageInitializer {
    @When("I click on Cannot log in button")
    public void iClickOnCannotLogInButton() {
        forgetPasswordPage = signInPage.clickForgetPasswordButton();
    }

    @And("I click on Login button")
    public void iClickOnLoginButton() {
        signInPage.clickLoginButton();
    }

    @Then("Error messages about empty fields are displayed")
    public void errorMessagesAboutEmptyFieldsAreDisplayed() {
        assertTrue(signInPage.areEmptyErrorMessagesDisplayed());
    }

    @And("I log in with {string} login and {string} password")
    public void iLogInWithLoginAndPassword(String login, String password) {
        signInPage.setLoginField(login);
        signInPage.setPasswordField(password);
    }

    @Then("Error message about invalid login is displayed")
    public void errorMessageAboutInvalidLoginIsDisplayed() {
        assertTrue(signInPage.IsErrorMessageInvalidLoginDisplayed());
    }

    @Then("Error message about invalid password is displayed")
    public void errorMessageAboutInvalidPasswordIsDisplayed() {
        assertTrue(signInPage.IsErrorMessageInvalidPasswordDisplayed());
    }
}
