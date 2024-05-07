@regression
Feature: Play artists' songs
  As a user
  I want to be able to open Artists page to see all the available artists and play the artists' songs

  Background:
    Given I open Login Page
    And I am logged in using "enrile.fuentes@testpro.io" and "26Pz2$g^GEXUPLaC"

  @smoke
  Scenario: Validate user is able to see artists in app
    When I navigate to Artists page
    Then Artists page will be displayed
    And I will see the artists in thumbnail view
    When I click the View as list button on the top right of the page
    Then I will see the artists in a list view
    When I click the View as thumbnails button beside the View as list button
    Then I will see the artists in thumbnail view

  Scenario: Validate user is able to find artists using search field
    When I search for the artist "Lobo Loco" using the search bar
    Then I will see "Lobo Loco" under the Artists section of the search results

  Scenario: Validate selected artist's song/s automatically play from thumbnail view
    When I navigate to Artists page
    And I click "Till Paradiso" artist's thumbnail in "Thumbnail" view
    Then I will be navigated to Current Queue page
    And the selected "Till Paradiso" artist's songs will be added to the queue
    And the artist's songs will automatically play

  Scenario: Validate user is able to play a song of the selected artist from thumbnail view
    When I navigate to Artists page
    And I click artist's name in "Thumbnail" view
    Then I will be navigated to the artist's page
    And I will be able to play a song
#
  Scenario: Validate selected artist's song/s automatically play from list view
    When I navigate to Artists page
    And I click the View as list button on the top right of the page
    And I click "Dan Brasco" artist's thumbnail in "List" view
    Then I will be navigated to Current Queue page
    And the selected "Dan Brasco" artist's songs will be added to the queue
    And the artist's songs will automatically play

  Scenario: Validate user is able to play a song of the selected artist from list view
    When I navigate to Artists page
    And I click the View as list button on the top right of the page
    And I click artist's name in "List" view
    Then I will be navigated to the artist's page
    And I will be able to play a song