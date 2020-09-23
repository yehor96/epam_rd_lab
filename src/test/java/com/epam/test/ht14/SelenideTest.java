package com.epam.test.ht14;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelenideTest {
    @RegisterExtension
    static ScreenShooterExtension screenshotAll = new ScreenShooterExtension(true);

    private static final String SEARCH_FIELD = ".gLFyf.gsfi";
    private static final String PAGE_LINKS = ".TbwUpd.NJjxre";
    private static final String BANNER_TEXT = ".hero.homepage h1";

    private static final String SEARCH_QUERY = "selenium";
    private static final String WEBSITE_URL = "www.selenium.dev";
    private static final String EXPECTED_TEXT = "Selenium automates browsers. That's it!";
    private static final String BROWSER = "opera";

    @BeforeAll
    static void setUpAll(){
        Configurator.setUp(BROWSER);
    }

    @Test
    void testKeywordSearch(){
        //GIVEN
        Selenide.open("/");

        //WHEN
        $(SEARCH_FIELD).setValue(SEARCH_QUERY).submit();
        $$(PAGE_LINKS)
                .stream()
                .filter(each -> each.getText().equals(WEBSITE_URL))
                .findFirst().get().click();

        //THEN
        assertTrue(WebDriverRunner.url().contains(SEARCH_QUERY));
        assertTrue($(BANNER_TEXT).getText().equals(EXPECTED_TEXT));
    }
}
