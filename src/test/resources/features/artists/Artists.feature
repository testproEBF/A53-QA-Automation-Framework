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

  Scenario Outline: Validate user is able to find artist "<Artist's Name>" using search field
    When I search for the existing artist "<Artist's Name>" using the search bar
    Then I will see "<Artist's Name>" under the Artists section of the search results

    Examples:
    | Artist's Name    |
    | Origami Repetika |
    | REW<<            |
    | Unknown Artist   |

  Scenario Outline: Validate "<Artist>" artist's song/s automatically play in "<View Mode>" view
    When I navigate to Artists page
    And I click the View as "<View Mode Button>" button on the top right of the page
    And I click "<Artist>" artist's thumbnail in "<View Mode>" view
    Then I will be navigated to Current Queue page
    And the selected "<Artist>" artist's songs will be added to the queue
    And the artist's songs will automatically play

    Examples:
      | View Mode Button | Artist       | View Mode |
      | List             | Chad Crouch  | List      |
      | List             | Makaih Beats | List      |
      | List             | Xylo-Ziko    | List      |
      | Thumbnail        | Chad Crouch  | Thumbnail |
      | Thumbnail        | Makaih Beats | Thumbnail |
      | Thumbnail        | Xylo-Ziko    | Thumbnail |

  Scenario Outline: Validate user is able to play a song of the randomly selected artist in "<View Mode>" View
    When I navigate to Artists page
    And I click the View as list button on the top right of the page
    And I click the View as "<View Mode Button>" button on the top right of the page
    And I click artist's name in "<View Mode>" view
    Then I will be navigated to the artist's page
    And I will be able to play a song

    Examples:
      | View Mode Button | View Mode |
      | List             | List      |
      | Thumbnail        | Thumbnail |




#  Scenario: Validate user is able to play a song of the selected artist from thumbnail view
#    When I navigate to Artists page
#    And I click artist's name in "Thumbnail" view
#    Then I will be navigated to the artist's page
#    And I will be able to play a song