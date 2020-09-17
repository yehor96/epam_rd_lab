package com.epam.test.ht17.fragments;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(id = "lastwrapper")
public class Footer extends HtmlElement {
    @FindBy(xpath = "//a[contains(@href,\"olxgroup\")]")
    private Button CareersAtOlxGroupButton;

    public void clickOnCareersAtOlxGroupButton(){
        CareersAtOlxGroupButton.click();
    }
}
