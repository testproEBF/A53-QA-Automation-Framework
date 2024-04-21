#noinspection SpellCheckingInspection
Feature: Login feature

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

    Examples:
      | username | password |
      | enrile.fuentes@testpro.io | 26Pz2$g^GEXUPL26 |
      | enrile.fuentes@testpro.io |                  |
      | enrile@testpro.io | 26Pz2$g^GEXUPL26         |
      | enrile@testpro.io | 26Pz2$g^GEXUPLaC         |
      |                   | 26Pz2$g^GEXUPLaC         |
      |                   |                          |

