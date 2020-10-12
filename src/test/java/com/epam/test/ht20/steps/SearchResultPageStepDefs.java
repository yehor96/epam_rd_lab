package com.epam.test.ht20.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchResultPageStepDefs extends AbstractStepDefs {
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
}
