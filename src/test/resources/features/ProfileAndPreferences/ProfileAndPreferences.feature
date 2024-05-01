@regression @update
Feature: Password and Email Update Validation
  As a user
  I want to update my email and/or password and be able to access my account after update

  Background:
    Given I open Login Page
    And I am LoggedIn using "enrile.fuentes+0@testpro.io" and "M4DBkwT5Mp$Y!6"
    And I navigate to Profile and Preferences Page

  @smoke
  Scenario: Successful Login using New Email After Successful Email Update
    When I update my email to "enrile.fuentes+9@testpro.io" using password "M4DBkwT5Mp$Y!6"
    Then a notification "Profile updated." is displayed
    And I click log out button
    And I open Login Page
    And I enter email "enrile.fuentes+9@testpro.io"
    And I enter password "M4DBkwT5Mp$Y!6"
    And I click submit
    Then I am logged in
    And I navigate to Profile and Preferences Page
    When I update my email to "enrile.fuentes+0@testpro.io" using password "M4DBkwT5Mp$Y!6"

  Scenario: Unsuccessful Login using Old Email After Successful Email Update
    When I update my email to "enrile.fuentes+9@testpro.io" using password "M4DBkwT5Mp$Y!6"
    Then a notification "Profile updated." is displayed
    And I click log out button
    And I open Login Page
    And I enter email "enrile.fuentes+0@testpro.io"
    And I enter password "M4DBkwT5Mp$Y!6"
    And I click submit
    Then I am not logged in
    When I am LoggedIn using "enrile.fuentes+9@testpro.io" and "M4DBkwT5Mp$Y!6"
    And I navigate to Profile and Preferences Page
    And I update my email to "enrile.fuentes+0@testpro.io" using password "M4DBkwT5Mp$Y!6"

  @smoke
  Scenario: Successful Login Using New Password After Successful Password Update
    When I update my password from "M4DBkwT5Mp$Y!6" to "fdsaLKJH%^&567"
    Then a notification "Profile updated." is displayed
    And I click log out button
    And I open Login Page
    And I enter email "enrile.fuentes+0@testpro.io"
    And I enter password "fdsaLKJH%^&567"
    And I click submit
    Then I am logged in
    And I navigate to Profile and Preferences Page
    And I update my password from "fdsaLKJH%^&567" to "M4DBkwT5Mp$Y!6"

  Scenario: Unsuccessful Login Using Old Password After Successful Password Update
    When I update my password from "M4DBkwT5Mp$Y!6" to "fdsaLKJH%^&567"
    Then a notification "Profile updated." is displayed
    And I click log out button
    And I open Login Page
    And I enter email "enrile.fuentes+0@testpro.io"
    And I enter password "M4DBkwT5Mp$Y!6"
    And I click submit
    Then I am not logged in
    When I am LoggedIn using "enrile.fuentes+0@testpro.io" and "fdsaLKJH%^&567"
    And I navigate to Profile and Preferences Page
    And I update my password from "fdsaLKJH%^&567" to "M4DBkwT5Mp$Y!6"

  Scenario Outline: Unsuccessful Password Update
    When I update my password from "<current password>" to "<new password>"
    Then an error notification "<message>" is displayed

  Examples:
    | current password | new password     | message                                                      |
    | M4DBkwT5Mp$Y!6   | FDS%^&*(mnbv     | The new password must contain at least one number.           |
    | M4DBkwT5Mp$Y!6   | FDS56789mnbv     | The new password must contain at least one symbol.           |
    | M4DBkwT5Mp$Y!6   | fdsLKJ%^7        | The new password must be at least 10 characters.             |
#    | M4DBkwT5Mp$Y!6   | fdsLKJ%^7mnbvcxz | The new password must not exceed 15 characters.              |
#    | M4DBkwT5Mp$Y!6   | fds%^789mnbv     | The new password must contain at least one uppercase letter. |
#    | M4DBkwT5Mp$Y!6   | FDS%^789MNBV     | The new password must contain at least one lowercase letter. |



