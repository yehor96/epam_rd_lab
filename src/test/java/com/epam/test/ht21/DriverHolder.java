package com.epam.test.ht21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHolder {
    public static WebDriver driver;

    public static WebDriver setUpDriver(){
        if(driver == null) {
            WebDriverManager.chromedriver().browserVersion("85").setup();
            driver = new ChromeDriver();
        }
        return driver;
    }
}
