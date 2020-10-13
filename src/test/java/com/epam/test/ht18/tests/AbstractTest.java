package com.epam.test.ht18.tests;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.epam.test.ht18.helpers.Configurator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;

public abstract class AbstractTest {
    private static final String BROWSER = "opera";

    @RegisterExtension
    static ScreenShooterExtension screenshotAll = new ScreenShooterExtension(true);

    @BeforeAll
    static void setUpAll(){
        Configurator.setUp(BROWSER);
    }
}
