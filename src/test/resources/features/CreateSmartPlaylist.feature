#noinspection SpellCheckingInspection
@regression
Feature: Create Smart Playlist feature

  Background:
    Given I open Login Page
    And I am LoggedIn using "enrile.fuentes@testpro.io" and "26Pz2$g^GEXUPLaC"
    And there are no existing playlists
    And I am on New Smart Playlist Form

  Scenario: Create smart playlist with one rule (Title)
    And I input "1" in the name text field
    And I make 1 rule or rules: "Title" "contains" "Frantic"
    And I click on the Save button
    Then a notification that says the smart playlist "1" has been created will pop up
    And I will see the created playlist "1" with an asterisk icon and with the correct name under PLAYLISTS
    And I will see the song "Frantic" in the playlist "1"
#
  Scenario: Create smart playlist with one rule (Length)
    And I input "a" in the name text field
    And I make 1 rule or rules: "Length" "is" "1"
    And I click on the Save button
    Then a notification that says the smart playlist "a" has been created will pop up
    And I will see the created playlist "a" with an asterisk icon and with the correct name under PLAYLISTS
    And I will see the all the songs in the playlist

  Scenario: Create smart playlist with two rules
    And I input "2 Rules" in the name text field
    And I make 2 rule or rules: "Length" "is greater than" "1"
    And I click on the Save button
    Then a notification that says the smart playlist "2 Rules" has been created will pop up
    And I will see the created playlist "2 Rules" with an asterisk icon and with the correct name under PLAYLISTS
    And I will see the all the songs in the playlist
#
  Scenario: Create smart playlist with 30 rules
    And I input "30 Rules" in the name text field
    And I make 30 rule or rules: "Artist" "is" "xyz"
    And I change rule 5 of Group 1 to "Title" "contains" "qwerty"
    And I click on the Save button
    Then a notification that says the smart playlist "30 Rules" has been created will pop up
    And I will see the created playlist "30 Rules" with an asterisk icon and with the correct name under PLAYLISTS
    And I will see empty "30 Rules" playlist

  Scenario: Create smart playlist with two groups
    And I input "2 Groups" in the name text field
    And I make 2 groups with rule: "Length" "is not" "1"
    And I click on the Save button
    Then a notification that says the smart playlist "2 Groups" has been created will pop up
    And I will see the created playlist "2 Groups" with an asterisk icon and with the correct name under PLAYLISTS
    And I will see the all the songs in the playlist
#
  Scenario: Create smart playlist with 20 groups
    And I input "20 Groups" in the name text field
    And I make 20 groups with rule: "Length" "is" "1"
    And I change rule 1 of Group 7 to "Title" "contains" "qwerty"
    And I click on the Save button
    Then a notification that says the smart playlist "20 Groups" has been created will pop up
    And I will see the created playlist "20 Groups" with an asterisk icon and with the correct name under PLAYLISTS
    And I will see empty "20 Groups" playlist

  Scenario: Create smart playlist with empty name
    And I input "" in the name text field
    And I make 1 rule or rules: "Title" "contains" "Frantic"
    And I click on the Save button
    Then I stay in the New Smart Playlist Form
#
  Scenario: Cannot create smart playlists with same name
    And I input "Same Name" in the name text field
    And I make 1 rule or rules: "Title" "contains" "Frantic"
    And I click on the Save button
    And I am on New Smart Playlist Form
    And I input "Same Name" in the name text field
    And I make 1 rule or rules: "Title" "contains" "Frantic"
    And I click on the Save button
    Then I stay in the New Smart Playlist Form

  Scenario: Create smart playlist with 256-character name
    And I input a 256-char playlist name in the name text field
    And I make 1 rule or rules: "Artist" "is" "Queen"
    And I click on the Save button
    Then a notification that says the smart playlist has been created will pop up
    And I will see the created playlist with an asterisk icon and with the correct name under PLAYLISTS
    And I will see empty playlist

  Scenario: Cannot create smart playlist with 257-character name
    And I input a 257-char playlist name in the name text field
    And I make 1 rule or rules: "Artist" "is" "Queen"
    And I click on the Save button
    Then I stay in the New Smart Playlist Form
    And playlist is not created

  Scenario: Cannot create a smart playlist when discard changes "OK" is clicked
    And I input a 5-char playlist name in the name text field
    And I make 1 rule or rules: "Artist" "is" "Queen"
    And I click on the Cancel button
    And I click on the OK button
    Then playlist is not created

  Scenario: Cannot create a smart playlist when discard changes "CANCEL" is clicked
    And I input a 5-char playlist name in the name text field
    And I make 1 rule or rules: "Artist" "is" "Queen"
    And I click on the Cancel button
    And I click on the Cancel discard button
    Then I stay in the New Smart Playlist Form




