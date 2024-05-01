#noinspection SpellCheckingInspection
@smoke @regression
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

  Scenario: Successful Login using New Email After Email Update
    When I am LoggedIn using "enrile.fuentes@testpro.io" and "26Pz2$g^GEXUPLaC"
    And I navigate to Profile and Preferences Page
    And I update my email to "enrile.fuentes+9@testpro.io" using password "26Pz2$g^GEXUPLaC"
    Then a notification "Profile updated." is displayed
    And I click log out button
    And I open Login Page
    And I enter email "enrile.fuentes+9@testpro.io"
    And I enter password "26Pz2$g^GEXUPLaC"
    And I click submit
    Then I am logged in
    And I navigate to Profile and Preferences Page
    When I update my email to "enrile.fuentes@testpro.io" using password "26Pz2$g^GEXUPLaC"

  Scenario: Unsuccessful Login using Old Email After Email Update
    When I am LoggedIn using "enrile.fuentes@testpro.io" and "26Pz2$g^GEXUPLaC"
    And I navigate to Profile and Preferences Page
    And I update my email to "enrile.fuentes+9@testpro.io" using password "26Pz2$g^GEXUPLaC"
    Then a notification "Profile updated." is displayed
    And I click log out button
    And I open Login Page
    And I enter email "enrile.fuentes@testpro.io"
    And I enter password "26Pz2$g^GEXUPLaC"
    And I click submit
    Then I am not logged in
    When I am LoggedIn using "enrile.fuentes+9@testpro.io" and "26Pz2$g^GEXUPLaC"
    And I navigate to Profile and Preferences Page
    And I update my email to "enrile.fuentes@testpro.io" using password "26Pz2$g^GEXUPLaC"

  Scenario: Successful Login using New Password After Password Update
    When I am LoggedIn using "enrile.fuentes@testpro.io" and "26Pz2$g^GEXUPLaC"
    And I navigate to Profile and Preferences Page
    And I update my password from "26Pz2$g^GEXUPLaC" to "uragonKA@123"
    Then a notification "Profile updated." is displayed
    And I click log out button
    And I open Login Page
    And I enter email "enrile.fuentes@testpro.io"
    And I enter password "uragonKA@123"
    And I click submit
    Then I am logged in
    And I navigate to Profile and Preferences Page
    And I update my password from "uragonKA@123" to "26Pz2$g^GEXUPLaC"

  Scenario: Unsuccessful Login using Old Password After Password Update
    When I am LoggedIn using "enrile.fuentes@testpro.io" and "26Pz2$g^GEXUPLaC"
    And I navigate to Profile and Preferences Page
    And I update my password from "26Pz2$g^GEXUPLaC" to "uragonKA@123"
    Then a notification "Profile updated." is displayed
    And I click log out button
    And I open Login Page
    And I enter email "enrile.fuentes@testpro.io"
    And I enter password "26Pz2$g^GEXUPLaC"
    And I click submit
    Then I am not logged in
    When I am LoggedIn using "enrile.fuentes@testpro.io" and "uragonKA@123"
    And I navigate to Profile and Preferences Page
    And I update my password from "uragonKA@123" to "26Pz2$g^GEXUPLaC"
