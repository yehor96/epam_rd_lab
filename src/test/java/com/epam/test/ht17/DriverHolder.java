package com.epam.test.ht17;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverHolder {
    public static void setUpVersion(int version) {
        WebDriverManager.chromedriver().browserVersion(String.valueOf(version)).setup();
    }
}
