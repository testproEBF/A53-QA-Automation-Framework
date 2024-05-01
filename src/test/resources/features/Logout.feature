#noinspection SpellCheckingInspection
@regression
Feature: Logout Validation
  As a user
  I want to successfully log out of my account to keep my account safe

  Background:
    Given I open Login Page
    And I am LoggedIn using "enrile.fuentes@testpro.io" and "26Pz2$g^GEXUPLaC"

  @smoke
  Scenario: Successful Logout
    When I click log out button
    Then I am not logged in

  @update
  Scenario: Successful Logout After Email Update
    When I navigate to Profile and Preferences Page
    And I update my email to "enrile.fuentes+9@testpro.io" using password "26Pz2$g^GEXUPLaC"
    And I click log out button
    Then I am not logged in
    And I open Login Page
    And I am LoggedIn using "enrile.fuentes+9@testpro.io" and "26Pz2$g^GEXUPLaC"
    And I navigate to Profile and Preferences Page
    And I update my email to "enrile.fuentes@testpro.io" using password "26Pz2$g^GEXUPLaC"

  @update
  Scenario: Successful Logout After Password Update
    When I navigate to Profile and Preferences Page
    And I update my password from "26Pz2$g^GEXUPLaC" to "uragonKA@123"
    And I click log out button
    Then I am not logged in
    And I open Login Page
    And I am LoggedIn using "enrile.fuentes@testpro.io" and "uragonKA@123"
    And I navigate to Profile and Preferences Page
    And I update my password from "uragonKA@123" to "26Pz2$g^GEXUPLaC"