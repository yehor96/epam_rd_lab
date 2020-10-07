Feature: Main

  Background:
    Given Main page is opened

  Scenario: It is not possible to log in without Terms And Agreements checkbox
    Given Sign In form is opened
    When I click on Terms And Agreements checkbox
    Then Login options are disabled

  Scenario: It is possible to search by company
    Given Jobs section is opened
    When Search job search filed by "EPAM" query
    Then Company name in search result is "EPAM"

  Scenario: It is possible to access partner website via main banner
    When I click on main banner
    And I switch to newly open tab
    Then Current Url does not contain "dou"

  Scenario: It is possible to close main banner
    When I close main banner
    Then Main banner is not displayed

  Scenario: It is possible to search jobs by position
    Given Jobs section is opened
    When I search jobs by "Java" position
    Then Search result are in "Java" category

  Scenario: Check that EPAM hires a lot of juniors
    Given Junior Digest section is opened
    Then Value of hired juniors by EPAM is more than "500"