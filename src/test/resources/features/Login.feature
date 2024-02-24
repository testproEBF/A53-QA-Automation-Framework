Feature: Login feature

  Background:
    Given I open Login Page

  Scenario: Login Success
    When I enter email "enrile.fuentes@testpro.io"
    And I enter password "26Pz2$g^GEXUPLaC"
    And I click submit
    Then I am logged in

#  Scenario: Login Wrong Password
#    When I enter email "enrile.fuentes@testpro.io"
#    And I enter password "26Pz2$g^GEXUPL26"
#    And I click submit
#    Then I am not logged in
#
#  Scenario: Login Wrong Email
#    When I enter email "enrile@testpro.io"
#    And I enter password "26Pz2$g^GEXUPLaC"
#    And I click submit
#    Then I am not logged in
#
#  Scenario: Login Empty Email
#    When I enter email ""
#    And I enter password "26Pz2$g^GEXUPLaC"
#    And I click submit
#    Then I am not logged in
#
#  Scenario: Login Empty Password
#    When I enter email "enrile.fuentes@testpro.io"
#    And I enter password ""
#    And I click submit
#    Then I am not logged in
#
#  Scenario: Login Empty Email and Password
#    When I enter email ""
#    And I enter password ""
#    And I click submit
#    Then I am not logged in