#noinspection SpellCheckingInspection
Feature: I want to be able to open Current Queue page to be able to see all currently played songs

  Background:
    Given I open Login Page
    And I am LoggedIn using "enrile.fuentes+6@testpro.io" and "26Pz2$g^GEXUPLaC"
    And I play 3 songs in All Songs Page

  Scenario: Currently played songs are displayed in the Current Queue page
    When I navigate to Current Queue page
    Then I will see all 3 songs

  Scenario: Total count of currently played songs is displayed
    When I navigate to Current Queue page
    Then I will see the 3 total number of songs under the text Current Queue

#  Scenario: Total duration of currently played songs is displayed
#    When I navigate to Current Queue page
#    Then I will see the total duration of songs under the text Current Queue

  Scenario: Track number of currently played song is displayed
    When I navigate to Current Queue page
    Then I will see the track numbers of the 3 songs

  Scenario: Title of currently played song is displayed
    When I navigate to Current Queue page
    Then I will see the titles of the 3 songs

  Scenario: Artist of currently played song is displayed
    When I navigate to Current Queue page
    Then I will see the artists of the 3 songs

  Scenario: Album of currently played song is displayed
    When I navigate to Current Queue page
    Then I will see the albums of the 3 songs

  Scenario: Song Length of currently played song is displayed
    When I navigate to Current Queue page
    Then I will see the playtime of the 3 songs

  Scenario: 'Shuffle All' button in Current Queue page shuffles songs
    When I navigate to Current Queue page
    And I get the titles of the 3 songs in order
    And I click the Shuffle button
    And I get the titles of the 3 songs in order after shuffle
    Then the songs will be shuffled

  Scenario: Current Queue page is empty after clicking 'Clear' button
    When I navigate to Current Queue page
    And I click the Clear button
    Then the Current Queue list will be empty
    And "No songs queued. How about shuffling all songs?" message will be displayed

  Scenario: All songs are displayed on the Current Queue page when 'shuffling all songs' is clicked
    When I navigate to Current Queue page
    And I click the Clear button
    And I click shuffling all songs hyperlink text
    Then all the songs in All Songs Page is displayed