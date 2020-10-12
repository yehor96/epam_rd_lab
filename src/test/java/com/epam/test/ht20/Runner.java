package com.epam.test.ht20;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/epam/test/ht20/features",
        tags = "(@Main or @Negative) and not @Broken")
public class Runner {}
