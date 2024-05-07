#noinspection SpellCheckingInspection
@regression @smoke @login
Feature: User Authentication
  As a user
  I want to be able to log in to Koel
  So that I can access my account and use the application

  Background:
    Given I open Login Page

  Scenario: Successful Login
    When I enter email "enrile.fuentes@testpro.io"
    And I enter password "26Pz2$g^GEXUPLaC"
    And I click submit
    Then I am logged in

  Scenario Outline: Unsuccessful Login
    When I enter email "<username>"
    And I enter password "<password>"
    And I click submit
    Then I am not logged in
#    And the message "<message>" is displayed

    Examples:
      | username                  | password         | message
      | enrile.fuentes@testpro.io | 26Pz2$g^GEXUPL26 | Password is incorrect.
      | enrile.fuentes@testpro.io |                  | Please fill out this field.
      | enrile@testpro.io         |                  | Please fill out this field.
      | enrile@testpro.io         | 26Pz2$g^GEXUPL26 | ""
      | enrile@testpro.io         | 26Pz2$g^GEXUPLaC | ""
      |                           | 26Pz2$g^GEXUPLaC | Please fill out this field.
      |                           |                  | Please fill out this field.

