package com.epam.test.ht20.pages;

import com.epam.test.ht20.fragments.Footer;
import com.epam.test.ht20.fragments.Header;
import com.epam.test.ht20.fragments.SearchForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

public class HomePage extends BasePage {
    @FindBy(id = "searchmain")
    private SearchForm searchForm;

    @FindBy(css = ".navi")
    private Header header;

    @FindBy(id = "lastwrapper")
    private Footer footer;

    @FindBy(id = "homeShowAllAds")
    private Button showAll;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isRegionsListDisplayed(){
        return searchForm.isRegionsListDisplayed();
    }

    public void clickOnRegionsList(){
        searchForm.clickOnRegionsListButton();
    }

    public SearchResultPage clickOnSearchButton(){
        searchForm.clickSubmitButton();
        return new SearchResultPage(driver);
    }

    public String getCurrentLanguage(){
        return header.getMyProfileText().equals("Мій профіль") ? "Ukrainian" : "Russian";
    }

    public void setLanguage(String language){
        if(language.contains("Russian")){
            header.setRussianLanguage();
        }
        if(language.contains("Ukrainian")){
            header.setUkrainianLanguage();
        }
    }

    public void clickOnNewPostButton(){
        header.clickOnNewPostRequestButton();
    }

    public SearchResultPage searchInfo(String query) {
        searchForm.inputTextInSearchField(query);
        searchForm.clickSubmitButton();
        return new SearchResultPage(driver);
    }

    public SearchResultPage searchInfoByAllRegions(String query) {
        searchForm.inputTextInSearchField(query);
        searchForm.chooseAllRegions();
        searchForm.clickSubmitButton();
        return new SearchResultPage(driver);
    }

    public SignInPage clickOnMyProfileButton(){
        header.clickMyProfileButton();
        return new SignInPage(driver);
    }

    public void clickOnCareersButton(){
        footer.clickOnCareersAtOlxGroupButton();
    }

    public SearchResultPage clickOnShowAllButton(){
        showAll.click();
        return new SearchResultPage(driver);
    }
}
