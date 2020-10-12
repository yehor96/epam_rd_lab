package com.epam.test.ht20.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Table;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(id = "searchmain")
public class SearchForm extends HtmlElement {
    @FindBy(css = ".clearbox.rel input")
    private TextInput searchField;

    @FindBy(id = "submit-searchmain")
    private Button submitButton;

    @FindBy(id = "cityField")
    private TextInput regionsListButton;

    @FindBy(xpath = "//input[@id='cityField' and @defaultval='Вся Україна']")
    private TextInput allRegionsUAButton;

    @FindBy(xpath = "//input[@id='cityField' and @defaultval='Вся Украина']")
    private TextInput allRegionsRUButton;

    @FindBy(id = "regions-layer")
    private Table regionsList;

    @FindBy(css = ".regionSelectA1")
    private Button allRegions;

    public boolean isAllRegionsDisplayed(String lang){
        return lang.equals("Ukrainian")
                ?
                allRegionsUAButton.isDisplayed()
                :
                allRegionsRUButton.isDisplayed();
    }

    public void clickOnRegionsListButton(){
        regionsListButton.click();
    }

    public void chooseAllRegions(){
        regionsListButton.click();
        allRegions.click();
    }

    public void inputTextInSearchField(String text){
        searchField.clear();
        searchField.sendKeys(text);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public boolean isSearchFieldContainsValue(String value){
        return findElement(By.xpath("//input[@id='search-text' and @value='" + value + "']")).isDisplayed();
    }

    public boolean isRegionsListDisplayed() {
        return regionsList.isDisplayed();
    }
}
