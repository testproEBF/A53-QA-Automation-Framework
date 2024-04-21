#noinspection SpellCheckingInspection
Feature: Login feature

  Background:
    Given I open Login Page

  Scenario: Successful Login
    When I enter email "enrile.fuentes@testpro.io"
    And I enter password "26Pz2$g^GEXUPLaC"
    And I click submit
    Then I am logged in

  Scenario: Unsuccessful Login using Wrong Email and Wrong Password
    When I enter email "enrile@testpro.io"
    And I enter password "26Pz2$g^GEXUPL26"
    And I click submit
    Then I am not logged in

  Scenario: Unsuccessful Login using Empty Email and Password
    When I enter email ""
    And I enter password ""
    And I click submit
    Then I am not logged in

  Scenario: Unsuccessful Login using Wrong Password
    When I enter email "enrile.fuentes@testpro.io"
    And I enter password "26Pz2$g^GEXUPL26"
    And I click submit
    Then I am not logged in
    And "Password is incorrect." message is displayed

  Scenario: Unsuccessful Login using Wrong Email
    When I enter email "enrile@testpro.io"
    And I enter password "26Pz2$g^GEXUPLaC"
    And I click submit
    Then I am not logged in

  Scenario: Unsuccessful Login using Empty Email
    When I enter email ""
    And I enter password "26Pz2$g^GEXUPLaC"
    And I click submit
    Then I am not logged in

  Scenario: Unsuccessful Login using Empty Password
    When I enter email "enrile.fuentes@testpro.io"
    And I enter password ""
    And I click submit
    Then I am not logged in

