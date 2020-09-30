package com.epam.test.ht20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHolder {
    public static WebDriver getDriver(){
        DriverHolder.setUpVersion(85);
        return new ChromeDriver();
    }

    private static void setUpVersion(int version) {
        WebDriverManager.chromedriver().browserVersion(String.valueOf(version)).setup();
    }
}
