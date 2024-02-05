Feature: Create Playlist feature

  Scenario: Create playlist Successful
    Given I am Loggedin using "enrile.fuentes@testpro.io" and "@mEi99LqzLc5NH8n"
    When I click the plus button
    And I click New Playlist
    And I enter playlist name
    Then I created a playlist