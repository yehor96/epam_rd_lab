package com.epam.test.ht17.pages;

import com.epam.test.ht17.fragments.SearchForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {
    private SearchForm searchForm;

    @FindBy(css = ".offer-wrapper a strong")
    private List<String> itemTexts;

    @FindBy(css = "//i[@data-icon=\"location-filled\"]\n")
    private List<String> itemLocationTexts;

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public String getSearchFieldContent() {
        return searchForm.getSearchFieldContent();
    }

    public List<String> getItemTexts(){
        return itemTexts;
    }

    public List<String> getItemLocationTexts(){
        return itemLocationTexts;
    }
}
