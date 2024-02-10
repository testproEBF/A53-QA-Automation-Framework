Feature: Create Smart Playlist feature

  Background:
    Given I am LoggedIn using "enrile.fuentes@testpro.io" and "@mEi99LqzLc5NH8n"
    And I am on New Smart Playlist Form

  Scenario: Create smart playlist with one rule
#    When I click on the + button under PLAYLISTS on the main menu
#    And I click on New Smart Playlist
    And I input "1" on the name text field
    And I make a rule "Frantic"
    And I click on the Save button
    Then a notification that says the smart playlist "1" has been created will pop up
    And I will see the created playlist "1" with an asterisk icon and with the correct name under PLAYLISTS
#    And I will see the song "Frantic" in the playlist "1"

#  Scenario: Create smart playlist with two rules
#    And I input "2" on the name text field
#    And I make 2 rules
#    And I click on the Save button
#    Then a notification that says the smart playlist "2" has been created will pop up
#    And I will see the created playlist "2" with an asterisk icon and with the correct name under PLAYLISTS
##    And I will see the song "Frantic" in the playlist "A"
#
#  Scenario: Create smart playlist with twenty rules
#    And I input "20" on the name text field
#    And I make 20 rules
#    And I click on the Save button
#    Then a notification that says the smart playlist "20" has been created will pop up
#    And I will see the created playlist "20" with an asterisk icon and with the correct name under PLAYLISTS
##    And I will see empty playlist "20"
#
#  Scenario: Create smart playlist with two groups
#    And I input "2 Groups" on the name text field
#    And I make 2 groups
#    And I click on the Save button
#    Then a notification that says the smart playlist "2 Groups" has been created will pop up
#    And I will see the created playlist "2 Groups" with an asterisk icon and with the correct name under PLAYLISTS
##    And I will see the song "Frantic" in the playlist "2 Groups"
#
#  Scenario: Create smart playlist with twenty groups
#    And I input "20 Groups" on the name text field
#    And I make 20 groups
#    And I click on the Save button
#    Then a notification that says the smart playlist "20 Groups" has been created will pop up
#    And I will see the created playlist "20 Groups" with an asterisk icon and with the correct name under PLAYLISTS
##    And I will see the song "Frantic" in the playlist "20 Groups"
#
#  Scenario: Create smart playlist with empty name
#    And I input "" on the name text field
#    And I make a rule "Frantic"
#    And I click on the Save button
#    Then I stay in the New Smart Playlist Form
#    And a notification to fill out name field appears
#
#  Scenario: Create smart playlist with 257-character name
#    And I input "" on the name text field
#    Then
#
#  Scenario: Cannot create a Smart playlist when "Cancel" is clicked
#    And I input "Cancel" on the name text field
#    And I make a rule "Frantic"
#    And I click on the Cancel button
#    And I click on the OK button
#    Then playlist is not created
#
#  Scenario: Can cancel to discard changes when creating a smart playlist
#    And I input "Cancel Discard" on the name text field
#    And I make a rule "Frantic"
#    And I click on the Cancel button
#    And I click on the Cancel discard button
#    Then I stay in the New Smart Playlist Form


