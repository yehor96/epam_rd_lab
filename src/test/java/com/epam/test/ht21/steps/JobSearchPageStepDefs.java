package com.epam.test.ht21.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class JobSearchPageStepDefs extends BaseStepDefs {
    @When("Search job search filed by {string} query")
    public void searchJobSearchFiledByQuery(String query) {
        jobSearchPage.searchFieldByQuery(query);
    }

    @Then("Company name in search result is {string}")
    public void companyNameInSearchResultIs(String query) {
        assertThat(jobSearchPage.getCompanyNameFromResults()).contains(query);
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
}
