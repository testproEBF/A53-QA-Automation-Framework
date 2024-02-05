Feature: Logout feature

  Scenario: Logout Successful
    Given I am Loggedin using "enrile.fuentes@testpro.io" and "@mEi99LqzLc5NH8n"
    When I click the logout button
    And I press enter
    Then I am not logged in