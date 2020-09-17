package com.epam.test.ht17.fragments;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(css = ".navi")
public class Header extends HtmlElement {
    @FindBy(id = "postNewAdLink")
    private Button newPostRequest;

    @FindBy(css = "ul.breaklist > :nth-child(1) .x-normal")
    private Button RuLangButton;

    @FindBy(css = "ul.breaklist > :nth-child(2) .x-normal")
    private Button UaLangButton;

    @FindBy(css = "#topLoginLink strong")
    private Button MyProfile;

    public void clickMyProfileButton(){
        MyProfile.click();
    }

    public String getMyProfileText(){
        return MyProfile.getText();
    }

    public void setRussianLanguage(){
        RuLangButton.click();
    }

    public void setUkrainianLanguage(){
        UaLangButton.click();
    }

    public void clickOnNewPostRequestButton(){
        newPostRequest.click();
    }
}
