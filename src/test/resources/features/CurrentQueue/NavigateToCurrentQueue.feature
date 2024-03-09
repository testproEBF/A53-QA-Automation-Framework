Feature: I want to be able to open Current Queue page to be able to see all currently played songs

  Acceptance Criteria:

  Background:
    Given I open Login Page
    And I am LoggedIn using "enrile.fuentes@testpro.io" and "26Pz2$g^GEXUPLaC"

  Scenario: Currently played songs are displayed in the Current Queue page
    When I navigate to All Songs page
    And I play 3 out of 66 songs
    And I navigate to Current Queue page
    Then I will see all 3 songs

  Scenario: Navigated to Current Queue page after double clicking a song on Home page
  Scenario: Navigated to Current Queue page after double clicking a song on All Songs page
  Scenario: Navigated to Current Queue page after double clicking a song on Albums page
  Scenario: Navigated to Current Queue page after double clicking a song on Artists page
  Scenario: Navigated to Current Queue page after double clicking a song on Favorites
  Scenario: Navigated to Current Queue page after double clicking a song on Recently Played page
  Scenario: Navigated to Current Queue page after double clicking a song on user's created playlist page
  Scenario: Navigated to Current Queue page after double clicking a song on user's created smart playlist page