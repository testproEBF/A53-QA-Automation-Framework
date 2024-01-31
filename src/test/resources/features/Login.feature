Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "enrile.fuentes@testpro.io"
    And I enter password "@mEi99LqzLc5NH8n"
    And I click submit
    Then I am logged in