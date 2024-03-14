Feature: I want to be able to open Current Queue page to be able to see all currently played songs

  Background:
    Given I open Login Page
    And I am LoggedIn using "enrile.fuentes@testpro.io" and "26Pz2$g^GEXUPLaC"

  Scenario: Navigated to Current Queue page after double clicking a song on Home page - Most Played
    When I double-click 1 song under Most Played category
    Then I will be navigated to Current Queue page

  Scenario: Navigated to Current Queue page after double clicking a song on Home page - Recently Played
    When I double-click 1 song under Recently Played category
    Then I will be navigated to Current Queue page

  Scenario: Navigated to Current Queue page after double clicking a song on Home page - Recently Added
    When I double-click 1 song under Recently Added category
    Then I will be navigated to Current Queue page

  Scenario: Navigated to Current Queue page after double clicking a song on Home page - Top Artists
    When I double-click 1 song under Top Artists category
    Then I will be navigated to Current Queue page

  Scenario: Navigated to Current Queue page after double clicking a song on Home page - Top Albums
    When I double-click 1 song under Top Albums category
    Then I will be navigated to Current Queue page

  Scenario: Navigated to Current Queue page after double clicking a song on All Songs page
    When I play 1 songs in All Songs Page
    Then I will be navigated to Current Queue page

  Scenario: Navigated to Current Queue page after double clicking a song on Albums page
    When I navigate to Albums page
    And I play 1 album in Albums page
    Then I will be navigated to Current Queue page

  Scenario: Navigated to Current Queue page after double clicking a song on Artists page
    When I navigate to Artists page
    And I play 1 artist in Artists page
    Then I will be navigated to Current Queue page

  Scenario: Navigated to Current Queue page after double clicking a song on Favorites
    When I navigate to Favorites page
    And I play 1 song in Favorites page
    Then I will be navigated to Current Queue page
#
  Scenario: Navigated to Current Queue page after double clicking a song on Recently Played page
    When I navigate to Recently Played page
    And I play 1 song in Recently Played page
    Then I will be navigated to Current Queue page
#
  Scenario: Navigated to Current Queue page after double clicking a song on user's created playlist page
    When I navigate to my playlist page
    And I play 1 song in my playlist page
    Then I will be navigated to Current Queue page
#
  Scenario: Navigated to Current Queue page after double clicking a song on user's created smart playlist page
    When I navigate to my smart playlist page
    And I play 1 song in my smart playlist page
    Then I will be navigated to Current Queue page