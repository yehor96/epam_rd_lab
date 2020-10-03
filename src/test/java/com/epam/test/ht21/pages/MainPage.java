package com.epam.test.ht21.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {
    private static final String LOGIN_MENU = "login-link";
    private static final String LOGIN_OPTIONS_MENU = ".b-login-dialog.__disabled";
    private static final String CHECKBOX = "agree-checkbox";
    private static final String JOBS_SECTION = "//a[@href='https://jobs.dou.ua/']";
    private static final String MAIN_BANNER = "#max-header-adv-id > a[href]";
    private static final String CLOSE_BANNER_BUTTON = "#max-header-adv-id > #max-header-close-id";
    private static final String JUNIOR_DIGEST_SECTION = "//a[@href='https://dou.ua/lenta/articles/juniors-2019/?from=doufp']";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openSignInForm(){
        driver.findElement(By.id(LOGIN_MENU)).click();
    }

    public void clickTermsAndConditionsCheckbox(){
        driver.findElement(By.id(CHECKBOX)).click();
    }

    public boolean getVisibilityOfSignInButton(){
        return driver.findElement(By.cssSelector(LOGIN_OPTIONS_MENU)).isDisplayed();
    }

    public JobSearchPage openJobSection() {
        driver.findElement(By.xpath(JOBS_SECTION)).click();
        return new JobSearchPage(driver);
    }

    public void clickOnMainBanner() {
        driver.findElement(By.cssSelector(MAIN_BANNER)).click();
    }

    public void closeMainBanner() {
        driver.findElement(By.cssSelector(CLOSE_BANNER_BUTTON)).click();
    }

    public boolean isMainBannerDisplayed() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(MAIN_BANNER)));

        return driver.findElement(By.cssSelector(MAIN_BANNER)).isDisplayed();
    }

    public JuniorDigestPage openJuniorDigestForm() {
        driver.findElement(By.xpath(JUNIOR_DIGEST_SECTION)).click();

        return new JuniorDigestPage(driver);
    }
}
