package com.epam.test.ht21.steps;

import cucumber.api.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class JuniorDigestPageStepDefs extends BaseStepDefs {
    @Then("Value of hired juniors by EPAM is more than {string}")
    public void valueOfHiredJuniorsByEPAMIsMoreThan(String number) {
        int actualNumberOfJuniors = juniorDigestPage.getJuniorsByCompany();

        assertThat(actualNumberOfJuniors).isGreaterThanOrEqualTo(Integer.parseInt(number));
    }
}
