package com.epam.test.ht21.steps;

import com.epam.test.ht21.DriverHolder;
import com.epam.test.ht21.pages.JobSearchPage;
import com.epam.test.ht21.pages.JuniorDigestPage;
import com.epam.test.ht21.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class BaseStepDefs {
    public static WebDriver driver = DriverHolder.setUpDriver();

    MainPage mainPage = new MainPage(DriverHolder.setUpDriver());
    JobSearchPage jobSearchPage = new JobSearchPage(DriverHolder.setUpDriver());
    JuniorDigestPage juniorDigestPage = new JuniorDigestPage(DriverHolder.setUpDriver());
}
