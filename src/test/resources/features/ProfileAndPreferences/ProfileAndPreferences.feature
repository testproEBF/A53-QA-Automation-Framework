@regression
Feature: Update password in Profile and Preferences Page

  Background:
    Given I open Login Page
    And I am LoggedIn using "enrile.fuentes@testpro.io" and "26Pz2$g^GEXUPLaC"
    And I navigate to Profile and Preferences Page

  Scenario: Successful Login Using New Password After Password Update
    When I update my password from "26Pz2$g^GEXUPLaC" to "fdsaLKJH%^&567"
    Then a notification "Profile updated." is displayed
    And I click log out button
    And I open Login Page
    And I enter email "enrile.fuentes@testpro.io"
    And I enter password "fdsaLKJH%^&567"
    And I click submit
    Then I am logged in
    And I navigate to Profile and Preferences Page
    And I update my password from "fdsaLKJH%^&567" to "26Pz2$g^GEXUPLaC"

  Scenario: Unsuccessful Login Using New Password After Password Update
    When I update my password from "26Pz2$g^GEXUPLaC" to "fdsaLKJH%^&567"
    Then a notification "Profile updated." is displayed
    And I click log out button
    And I open Login Page
    And I enter email "enrile.fuentes@testpro.io"
    And I enter password "26Pz2$g^GEXUPLaC"
    And I click submit
    Then I am not logged in
    When I am LoggedIn using "enrile.fuentes@testpro.io" and "fdsaLKJH%^&567"
    And I navigate to Profile and Preferences Page
    And I update my password from "fdsaLKJH%^&567" to "26Pz2$g^GEXUPLaC"

  Scenario: Unsuccessful Password Update using Without a Numerical Character Password
    When I update my password from "26Pz2$g^GEXUPLaC" to "FDS%^&*(mnbv"
    Then an error notification "The new password must contain at least one number." is displayed

  Scenario: Unsuccessful Password Update using Without a Special Character Password
    When I update my password from "26Pz2$g^GEXUPLaC" to "FDS56789mnbv"
    Then an error notification "The new password must contain at least one symbol." is displayed

  Scenario: Unsuccessful Password Update using 9-character Password
    When I update my password from "26Pz2$g^GEXUPLaC" to "fdsLKJ%^7"
    Then an error notification "The new password must be at least 10 characters." is displayed

#  Scenario: Unsuccessful Password Update using 16-character Password
#    When I update my password from "26Pz2$g^GEXUPLaC" to "fdsLKJ%^7mnbvcxz"
#    Then an error notification "The new password must not exceed 15 characters." is displayed
#
#  Scenario: Unsuccessful Password Update using Without an Uppercase Letter Password
#    When I update my password from "26Pz2$g^GEXUPLaC" to "fds%^789mnbv"
#    Then an error notification "The new password must contain at least one uppercase letter." is displayed
#
#  Scenario: Unsuccessful Password Update using Without a Lowercase Letter Password
#    When I update my password from "26Pz2$g^GEXUPLaC" to "FDS%^789MNBV"
#    Then an error notification "The new password must contain at least one lowercase letter." is displayed


