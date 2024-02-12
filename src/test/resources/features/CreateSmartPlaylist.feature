Feature: Create Smart Playlist feature

  Background:
    Given I am LoggedIn using "enrile.fuentes@testpro.io" and "@mEi99LqzLc5NH8n"
    And I am on New Smart Playlist Form

  Scenario: Create smart playlist with one rule
    And I input a 1-char playlist name in the name text field
    And I make a rule with value "Frantic"
    And I click on the Save button
    Then a notification that says the smart playlist has been created will pop up
    And I will see the created playlist with an asterisk icon and with the correct name under PLAYLISTS
    And I will see the song "Frantic" in the playlist

  Scenario: Create smart playlist with two rules
    And I input a 2-char playlist name in the name text field
    And I make 2 rules with value "Frantic"
    And I click on the Save button
    Then a notification that says the smart playlist has been created will pop up
    And I will see the created playlist with an asterisk icon and with the correct name under PLAYLISTS
    And I will see the song "Frantic" in the playlist

  Scenario: Create smart playlist with twenty rules
    And I input a 5-char playlist name in the name text field
    And I make 20 rules with value "123"
    And I click on the Save button
    Then a notification that says the smart playlist has been created will pop up
    And I will see the created playlist with an asterisk icon and with the correct name under PLAYLISTS
    And I will see empty playlist

  Scenario: Create smart playlist with two groups
    And I input a 8-char playlist name in the name text field
    And I make 2 groups with value "Frantic"
    And I click on the Save button
    Then a notification that says the smart playlist has been created will pop up
    And I will see the created playlist with an asterisk icon and with the correct name under PLAYLISTS
    And I will see the song "Frantic" in the playlist

  Scenario: Create smart playlist with twenty groups
    And I input a 10-char playlist name in the name text field
    And I make 20 groups with value "123"
    And I click on the Save button
    Then a notification that says the smart playlist has been created will pop up
    And I will see the created playlist with an asterisk icon and with the correct name under PLAYLISTS
    And I will see empty playlist

  Scenario: Create smart playlist with empty name
    And I input "" in the name text field
    And I make a rule with value "Frantic"
    And I click on the Save button
    Then I stay in the New Smart Playlist Form

  Scenario: Create smart playlist with 256-character name
    And I input a 256-char playlist name in the name text field
    And I make a rule with value "Frantic"
    And I click on the Save button
    Then a notification that says the smart playlist has been created will pop up
    And I will see the created playlist with an asterisk icon and with the correct name under PLAYLISTS
    And I will see the song "Frantic" in the playlist

  Scenario: Create smart playlist with 257-character name
    And I input a 257-char playlist name in the name text field
    And I make a rule with value "Frantic"
    And I click on the Save button
    Then I stay in the New Smart Playlist Form
    And playlist is not created

  Scenario: Cannot create a Smart playlist when "Cancel" is clicked
    And I input a 5-char playlist name in the name text field
    And I make a rule with value "Frantic"
    And I click on the Cancel button
    And I click on the OK button
    Then playlist is not created

  Scenario: Can cancel to discard changes when creating a smart playlist
    And I input a 5-char playlist name in the name text field
    And I make a rule with value "Frantic"
    And I click on the Cancel button
    And I click on the Cancel discard button
    Then I stay in the New Smart Playlist Form


