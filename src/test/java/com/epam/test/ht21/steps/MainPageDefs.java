package com.epam.test.ht21.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageDefs extends BaseStepDefs {
    @Given("^Main page is opened$")
    public void mainPageIsOpened() {
        mainPage.open();
    }

    @Given("^Sign In form is opened$")
    public void signInFormIsOpened() {
        mainPage.openSignInForm();
    }

    @When("^I click on Terms And Agreements checkbox$")
    public void iClickOnTermsAndAgreementsCheckbox() {
        mainPage.clickTermsAndConditionsCheckbox();
    }

    @Then("^Login options are disabled$")
    public void loginOptionsAreDisabled() {
        assertThat(mainPage.getVisibilityOfSignInButton()).isEqualTo(true);
    }

    @Given("Jobs section is opened")
    public void sectionIsOpened() {
        jobSearchPage = mainPage.openJobSection();
    }

    @When("I click on main banner")
    public void iClickOnMainBanner() {
        mainPage.clickOnMainBanner();
    }

    @When("I close main banner")
    public void iCloseMainBanner() {
        mainPage.closeMainBanner();
    }

    @Then("Main banner is not displayed")
    public void mainBannerIsNotDisplayed() {
        assertThat(mainPage.isMainBannerDisplayed()).isEqualTo(false);
    }

    @Given("Junior Digest section is opened")
    public void juniorDigestSectionIsOpened() {
        juniorDigestPage = mainPage.openJuniorDigestForm();
    }
}
