package com.epam.test.ht17.pages;

import com.epam.test.ht17.fragments.SearchForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {
    private SearchForm searchForm;

    private final String itemTexts = ".offer-wrapper a strong";

    @FindBy(css = ".offer-wrapper")
    private List<Link> listOfItems;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<Link> getListOfItems(){
        return listOfItems;
    }

    public String getSearchFieldContent() {
        return searchForm.getSearchFieldContent();
    }

    public List<String> getItemTexts() {
        List<WebElement> listOfElements = driver.findElements(By.cssSelector(itemTexts));

        List<String> listOfItemTexts = new ArrayList<>();
        for(var each : listOfElements){
            listOfItemTexts.add(each.getText());
        }

        return listOfItemTexts;
    }
}
