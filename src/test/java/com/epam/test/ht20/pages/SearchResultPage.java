package com.epam.test.ht20.pages;

import com.epam.test.ht20.fragments.Header;
import com.epam.test.ht20.fragments.SearchForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {
    private SearchForm searchForm;

    @FindBy(css = ".navi")
    private Header header;

    private final String itemTexts = ".offer-wrapper a strong";

    @FindBy(css = ".offer-wrapper")
    private List<Link> listOfItems;

    @FindBy(css = ".observe2")
    private List<Button> itemFavoritesButton;

    @FindBy(css = "#observed-ads-link .counter")
    private Button favoritesIcon;

    @FindBy(id = "fancybox-close")
    private Button closeModalWindow;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<Link> getListOfItems(){
        return listOfItems;
    }

    public boolean isSearchFieldContainsValue(String value) {
        return searchForm.isSearchFieldContainsValue(value);
    }

    public String getCurrentLanguage(){
        return header.getMyProfileText().equals("Мій профіль") ? "Ukrainian" : "Russian";
    }

    public boolean isAllRegionsDisplayed(){
        return searchForm.isAllRegionsDisplayed(getCurrentLanguage());
    }

    public List<String> getItemTexts() {
        List<WebElement> listOfElements = driver.findElements(By.cssSelector(itemTexts));

        List<String> listOfItemTexts = new ArrayList<>();
        for(var each : listOfElements){
            listOfItemTexts.add(each.getText());
        }

        return listOfItemTexts;
    }

    public void addToFavorites(int numberOfItem) {
        itemFavoritesButton.get(numberOfItem-1).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(closeModalWindow));
        closeModalWindow.click();
    }

    public String getCountOfFavorites() {
        return favoritesIcon.getText();
    }
}
