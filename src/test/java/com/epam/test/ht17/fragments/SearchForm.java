package com.epam.test.ht17.fragments;

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

    @FindBy(id = "regions-layer")
    private Table regionsList;

    @FindBy(css = ".regionSelectA1")
    private Button allRegions;

    public boolean isAllRegionsDisplayed(String lang){
        return lang.equals("Ukrainian")
                ?
                regionsListButton.getAttribute("defaultval").equals("Вся Україна")
                :
                regionsListButton.getAttribute("defaultval").equals("Вся Украина");
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

    public String getSearchFieldContent(){
        return searchField.getAttribute("value");
    }

    public boolean isRegionsListDisplayed() {
        return regionsList.isDisplayed();
    }
}
