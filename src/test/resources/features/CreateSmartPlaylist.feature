Feature: Create Smart Playlist feature

  Scenario: Create smart playlist with one rule
    Given I am LoggedIn using "enrile.fuentes@testpro.io" and "@mEi99LqzLc5NH8n"
    When I click on the + button under PLAYLISTS on the main menu
    And I click on New Smart Playlist
    And I input a one-character name (any character) on the name text field
    And I make a rule
    And I click on the "Save" button
    Then a notification that says the smart playlist has been created will pop up
    And I will see the created playlist with an asterisk icon and with the correct name under "PLAYLISTS"
    And I will see all the songs that belongs to the rule in the playlist



