package com.epam.test.ht20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHolder {
    static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null) {
            DriverHolder.setUpVersion(85);
            driver = new ChromeDriver();
        }
        return driver;
    }

    private static void setUpVersion(int version) {
        WebDriverManager.chromedriver().browserVersion(String.valueOf(version)).setup();
    }
}
