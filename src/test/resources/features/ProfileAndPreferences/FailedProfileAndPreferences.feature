@regression @update
Feature: Update password in Profile and Preferences Page

  Background:
    Given I open Login Page

  Scenario: Unsuccessful Password Update using 16-character Password
    And I am LoggedIn using "enrile.fuentes+0@testpro.io" and "M4DBkwT5Mp$Y!6"
    And I navigate to Profile and Preferences Page
    When I update my password from "M4DBkwT5Mp$Y!6" to "fdsLKJ%^7mnbvcxz"
    Then an error notification "The new password must not exceed 15 characters." is displayed

  Scenario: Unsuccessful Password Update using Without an Uppercase Letter Password
    And I am LoggedIn using "enrile.fuentes+0@testpro.io" and "fdsLKJ%^7mnbvcxz"
    And I navigate to Profile and Preferences Page
    When I update my password from "fdsLKJ%^7mnbvcxz" to "fds%^789mnbv"
    Then an error notification "The new password must contain at least one uppercase letter." is displayed

  Scenario: Unsuccessful Password Update using Without a Lowercase Letter Password
    And I am LoggedIn using "enrile.fuentes+0@testpro.io" and "fds%^789mnbv"
    And I navigate to Profile and Preferences Page
    When I update my password from "fds%^789mnbv" to "FDS%^789MNBV"
    Then an error notification "The new password must contain at least one lowercase letter." is displayed

  Scenario: Change Back to Original Password
    And I am LoggedIn using "enrile.fuentes+0@testpro.io" and "FDS%^789MNBV"
    And I navigate to Profile and Preferences Page
    When I update my password from "FDS%^789MNBV" to "26Pz2$g^GEXUPLaC"


