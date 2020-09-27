package com.epam.test.ht18.pages;

import com.codeborne.selenide.WebDriverRunner;

public class BasePage {
    public String getCurrentUrl(){
        return WebDriverRunner.url();
    }
}
