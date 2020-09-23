package com.epam.test.ht18.helpers;

import com.codeborne.selenide.Configuration;

public class Configurator {
    public static void setUp(){
        commonSetUp();
    }

    public static void setUp(String browser){
        commonSetUp();
        Configuration.browser = browser;
    }

    private static void commonSetUp(){
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://google.com";
        Configuration.reportsFolder = "additional_files/screenshots";
        Configuration.screenshots = true;
    }
}
