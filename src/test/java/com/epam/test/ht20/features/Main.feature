@Main
Feature: Main

  Background:
    Given Main page is opened

  Scenario: It is possible to use Forget Password feature
    When I click on My Profile button
    And I click on Cannot log in button
    And I complete Forget Password form with "test@email.com" value
    Then New Password label is displayed

  Scenario: It is possible to search by query
    When I search "java" value on Home page
    Then All results contain "java" text

  Scenario: Test new post request
     When I click on New Post button
     Then Current Url contains "account" string

  Scenario Outline: Test change of language
    When I set "<Language>" language
    Then Current language is "<Language>"
    Examples:
    | Language  |
    | Ukrainian |
    | Russian   |

  @Broken
  Scenario: Text displayed in search field after searching
    When I search "Java" value on Home page
    Then Search field contains "Java" text

  Scenario: OLX careers can be opened from home page
    When I click on Careers button
    And I navigate to newly opened page
    Then Current Url contains "olxgroup" string

  Scenario: Check display of all ads
    When I click on Show All button
    Then More than "30" items are displayed

  Scenario: Regions list can be displayed
    When I click on Regions list
    Then Regions list is displayed

    @Broken
  Scenario: It is possible to search by all regions
    When I search by all regions with "Java" query
    Then All regions value is displayed in search box

  Scenario: It is possible to search by empty query
    When I click on Search button
    Then More than "30" items are displayed

  Scenario: It is possible to add item to favorites
    When I click on Search button
    And I add "1" item to favorites
    And I refresh the page
    Then Count of items added to favorites is "1"