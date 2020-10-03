package com.epam.test.ht21.steps;

import com.epam.test.ht21.pages.MainPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions extends BaseStepDefinitions {
    @Given("^Main page is opened$")
    public void mainPageIsOpened() {
        setUpDriver();
        driver.get(BASE_URL);
        mainPage = new MainPage(driver);
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

    @When("Search job search filed by {string} query")
    public void searchJobSearchFiledByQuery(String query) {
        jobSearchPage.searchFieldByQuery(query);
    }

    @Then("Company name in search result is {string}")
    public void companyNameInSearchResultIs(String query) {
        assertThat(jobSearchPage.getCompanyNameFromResults()).contains(query);
    }

    @When("I click on main banner")
    public void iClickOnMainBanner() {
        mainPage.clickOnMainBanner();
    }

    @Then("Current Url contains {string}")
    public void currentUrlContains(String text) {
        assertThat(driver.getCurrentUrl()).contains(text);
    }

    @When("I close main banner")
    public void iCloseMainBanner() {
        mainPage.closeMainBanner();
    }

    @Then("Main banner is not displayed")
    public void mainBannerIsNotDisplayed() {
        assertThat(mainPage.isMainBannerDisplayed()).isEqualTo(false);
    }

    @When("I search jobs by {string} position")
    public void iSearchJobsByPosition(String position_name) {
        jobSearchPage.selectValueFromDropDown(position_name);
    }

    @Then("Search result are in {string} category")
    public void searchResultAreInCategory(String position_name) {
        String actualText = jobSearchPage.getSearchByPositionResults();

        assertThat(actualText).contains(position_name);
    }

    @Given("Junior Digest section is opened")
    public void juniorDigestSectionIsOpened() {
        juniorDigestPage = mainPage.openJuniorDigestForm();
    }

    @Then("Value of hired juniors by EPAM is more than {string}")
    public void valueOfHiredJuniorsByEPAMIsMoreThan(String number) {
        int actualNumberOfJuniors = juniorDigestPage.getJuniorsByCompany();

        assertThat(actualNumberOfJuniors).isGreaterThanOrEqualTo(Integer.parseInt(number));
    }

    @When("I switch to newly open tab")
    public void iSwitchToNewlyOpenTab() {
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
