@Negative
Feature: Main

  Background:
    Given Main page is opened

  Scenario: Error is displayed when attempting to log in with empty fields
    When I click on My Profile button
    And I click on Login button
    Then Error messages about empty fields are displayed

  Scenario: Error is displayed when entering invalid credentials
    When I click on My Profile button
    And I log in with "test" login and "test" password
    Then Error message about invalid login is displayed

  Scenario: It is not possible to log in with invalid data
    When I click on My Profile button
    And I log in with "test@Test1.com" login and "test@Test1.com" password
    And I click on Login button
    Then Error message about invalid password is displayed