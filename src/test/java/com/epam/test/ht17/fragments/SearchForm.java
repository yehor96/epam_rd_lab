package com.epam.test.ht17.fragments;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(id = "searchmain")
public class SearchForm extends HtmlElement {
    @FindBy(css = ".clearbox.rel input")
    private TextInput searchField;

    @FindBy(id = "submit-searchmain")
    private Button submitButton;

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
}
