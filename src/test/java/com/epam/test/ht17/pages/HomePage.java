package com.epam.test.ht17.pages;

import com.epam.test.ht17.fragments.SearchForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(id = "searchmain")
    private SearchForm searchForm;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage searchInfo(String query) {
        searchForm.inputTextInSearchField(query);
        searchForm.clickSubmitButton();
        return new SearchResultPage(driver);
    }

    public SearchResultPage searchInfo(String query, String location) {
        searchForm.inputTextInSearchField(query);
        searchForm.inputTextInLocationField(location);
        searchForm.clickSubmitButton();
        return new SearchResultPage(driver);
    }
}
