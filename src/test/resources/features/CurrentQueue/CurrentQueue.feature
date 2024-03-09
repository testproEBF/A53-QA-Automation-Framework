Feature: I want to be able to open Current Queue page to be able to see all currently played songs

  Acceptance Criteria:

  Background:
    Given I open Login Page
    And I am LoggedIn using "enrile.fuentes@testpro.io" and "26Pz2$g^GEXUPLaC"
    And I play 3 out of 66 songs in All Songs Page

  Scenario: Currently played songs are displayed in the Current Queue page
    When I navigate to Current Queue page
    Then I will see all 3 songs

  Scenario: Total count of currently played songs is displayed
    When I navigate to Current Queue page
    Then I will see the 3 total number of songs under the text Current Queue

  Scenario: Total duration of currently played songs is displayed
  Scenario: ID of currently played song is displayed
  Scenario: Title of currently played song is displayed
  Scenario: Artist of currently played song is displayed
  Scenario: Album of currently played song is displayed
  Scenario: Song Length of currently played song is displayed
  Scenario: 'Shuffle All' button in Current Queue page shuffles songs
  Scenario: Current Queue page is empty after clicking 'Clear' button
  Scenario: All songs are displayed on the Current Queue page when 'shuffling all songs' is clicked