package com.epam.test.ht20.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageStepDefs extends PageInitializer {
    @Given("Main page is opened")
    public void mainPageIsOpened() {
        homePage.open();
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
}
