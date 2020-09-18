package com.epam.test.ht17.pages;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class BasePage {
    protected WebDriver driver;
    public static final String BASE_URL = "https://www.olx.ua/";

    public BasePage(WebDriver driver){
        HtmlElementLoader.populate(this, driver);
        this.driver = driver;
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }
}
