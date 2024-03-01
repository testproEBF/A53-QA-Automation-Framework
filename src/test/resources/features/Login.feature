Feature: Login feature

  Background:
    Given I open Login Page

  Scenario: Login Success
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

  Scenario: Successful Login using New Email After Email Update
    When I am LoggedIn using "enrile.fuentes@testpro.io" and "26Pz2$g^GEXUPLaC"
    And I update my email to "enrile.fuentes+0@testpro.io" using password "26Pz2$g^GEXUPLaC"
    And I log out
    And I open Login Page
    And I enter email "enrile.fuentes+0@testpro.io"
    And I enter password "26Pz2$g^GEXUPLaC"
    And I click submit
    Then I am logged in
    When I update my email to "enrile.fuentes@testpro.io" using password "26Pz2$g^GEXUPLaC"
    And I log out

  Scenario: Successful Login using Old Email After Email Update
    When I am LoggedIn using "enrile.fuentes@testpro.io" and "26Pz2$g^GEXUPLaC"
    And I update my email to "enrile.fuentes+0@testpro.io" using password "26Pz2$g^GEXUPLaC"
    And I log out
    And I open Login Page
    And I enter email "enrile.fuentes@testpro.io"
    And I enter password "26Pz2$g^GEXUPLaC"
    And I click submit
    Then I am not logged in
    And I change "enrile.fuentes+0@testpro.io" back to "enrile.fuentes@testpro.io" using "26Pz2$g^GEXUPLaC"
