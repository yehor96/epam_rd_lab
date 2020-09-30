package com.epam.test.ht20.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllSteps extends AbstractStepDefs {
    //HOME PAGE
    @Given("Main page is opened")
    public void mainPageIsOpened() {
        setUp();
    }

    @When("I click on My Profile button")
    public void iClickOnMyProfileButton() {
        signInPage = homePage.clickOnMyProfileButton();
    }

    @When("I search {string} value on Home page")
    public void iSearchValueOnHomePage(String query) {
        searchResultPage = homePage.searchInfo(query);
    }

    @When("I click on New Post button")
    public void iClickOnNewPostButton() {
        homePage.clickOnNewPostButton();
    }

    @When("I set {string} language")
    public void iSetLanguage(String language) {
        homePage.setLanguage(language);
    }

    @Then("Current language is {string}")
    public void currentLanguageIs(String language) {
        assertEquals(homePage.getCurrentLanguage(), language);
    }

    @When("I click on Careers button")
    public void iClickOnCareersButton() {
        homePage.clickOnCareersButton();
    }

    @When("I click on Show All button")
    public void iClickOnShowAllButton() {
        searchResultPage = homePage.clickOnShowAllButton();
    }

    @When("I click on Regions list")
    public void iClickOnRegionsList() {
        homePage.clickOnRegionsList();
    }

    @Then("Regions list is displayed")
    public void regionsListIsDisplayed() {
        assertTrue(homePage.isRegionsListDisplayed());
    }

    @When("I search by all regions with {string} query")
    public void iSearchByAllRegionsWithQuery(String query) {
        searchResultPage = homePage.searchInfoByAllRegions(query);
    }

    @When("I click on Search button")
    public void iClickOnSearchButton() {
        searchResultPage = homePage.clickOnSearchButton();
    }

    //SEARCH RESULT PAGE
    @Then("All results contain {string} text")
    public void allResultsContainText(String query) {
        searchResultPage.getItemTexts()
                .forEach(text -> assertTrue(text.toLowerCase().contains(query)));
    }

    @Then("Search field contains {string} text")
    public void searchFieldContainsText(String query) {
        assertTrue(searchResultPage.isSearchFieldContainsValue(query));
    }

    @Then("More than {string} items are displayed")
    public void moreThanItemsAreDisplayed(String numberOfItems) {
        assertTrue(searchResultPage.getListOfItems().size() > Integer.parseInt(numberOfItems));
    }

    @Then("All regions value is displayed in search box")
    public void allRegionsValueIsDisplayedInSearchBox() {
        assertTrue(searchResultPage.isAllRegionsDisplayed());
    }

    @And("I add {string} item to favorites")
    public void iAddItemToFavorites(String number) {
        searchResultPage.addToFavorites(Integer.parseInt(number));
    }

    @And("I refresh the page")
    public void iRefreshThePage() {
        searchResultPage.refreshPage();
    }

    @Then("Count of items added to favorites is {string}")
    public void countOfItemsAddedToFavoritesIs(String count) {
        assertEquals(count, searchResultPage.getCountOfFavorites());
    }

    //SIGN IN PAGE
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

    //FORGET PASSWORD PAGE
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
