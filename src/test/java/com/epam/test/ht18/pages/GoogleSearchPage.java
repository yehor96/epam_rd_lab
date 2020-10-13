package com.epam.test.ht18.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleSearchPage extends BasePage {
    private static final String SEARCH_FIELD = ".gLFyf.gsfi";
    private static final String PAGE_LINKS = ".TbwUpd.NJjxre";

    public void openMainPage(){
        Selenide.open("/");
    }

    public void searchFoValue(String value){
        $(SEARCH_FIELD).setValue(value).submit();
    }

    public void openLinkWithUrl(String url){
        $$(PAGE_LINKS)
                .stream()
                .filter(each -> each.getText().equals(url))
                .findFirst().get().click();
    }
}
