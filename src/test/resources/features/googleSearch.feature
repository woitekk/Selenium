Feature: Google Search feature

  Background:
    Given Google page is opened.
    When I click accept all button.

#  Scenario: First google search
#    And I search for phrase "Cucumber".
#    Then I see search results.
#
#  Scenario: Second google search
#    And I search for phrase "Selenium".
#    Then I see search results.

  Scenario Outline: Search in google - outline scenario
    And I search for phrase "<searchPhrase>".
    Then I see search results.
    Examples:
      | searchPhrase    |
      | Cucumber        |
      | SDA             |
      | Selenium        |
      | Test Automation |

  Scenario: Search in google - nothing found
    #And I search for phrase "".
    And I press enter button
    Then I don't see search results.