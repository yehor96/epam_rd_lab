package com.epam.test.ht18.pages;

import static com.codeborne.selenide.Selenide.$;

public class SeleniumDevMainPage extends BasePage {
    private static final String BANNER_TEXT = ".hero.homepage h1";

    public String getBannerText(){
        return $(BANNER_TEXT).getText();
    }
}
