Feature: Authentication feature

Background:
  Given Home page is opened
  When I click Sign in link in top menu

  Scenario: Authentication - positive flow
    And I provide email address "zielonydaszek@mail.pl"
    And I provide password "prostydrut"
    And I click Sign in button
    Then I am logged in successfully

#  Scenario: Authentication - incorrect login and password
#    And I provide email address "not.excist@mail.pl"
#    And I provide password "111123354"
#    And I click Sign in button
#    Then I see error message "Authentication failed."
#
#  Scenario: Authentication - no email address
#    And I click Sign in button
#    Then I see error message "An email address required."
#
#  Scenario: Authentication - empty password
#    And I provide email address "zielonydaszek@mail.pl"
#    And I provide password ""
#    And I click Sign in button
#    Then I see error message "Password is required."
#
#  Scenario: Authentication - empty email
#    And I provide email address ""
#    And I provide password "24556tt"
#    And I click Sign in button
#    Then I see error message "An email address required."

  Scenario Outline: Authentication - negative flow "<errorMessage>"
    And I provide email address "<email>"
    And I provide password "<password>"
    And I click Sign in button
    Then I see error message "<errorMessage>"
    Examples:
      | email                 | password   | errorMessage               |
      | zielonydaszek@mail.pl | prostydrut | Authentication failed.     |
      | not.exist@mail.pl     | 123456     | Authentication failed.     |
      |                       |            | An email address required  |
      | test@test.pl          |            | Password is required test. |
      | test@test.pl          | 1          | Invalid password.          |
      | invalid               | test       | Invalid email address.     |
      | test.test.pl          | test       | Invalid email address.     |



