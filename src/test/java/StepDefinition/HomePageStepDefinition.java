package StepDefinition;

import io.cucumber.java.en.When;
import pages.BasePage;
import pages.HomePage;

public class HomePageStepDefinition {
    
    HomePage homePage = new HomePage(BaseDefinition.SHARED_DRIVER);
    

    @When("I double-click {int} song under Most Played category")
    public void playASongUnderMostPlayedCategory(int numberOfSongsPlayed) {
        homePage.playSongUnderMostPlayedCategory(numberOfSongsPlayed);
    }

    @When("I double-click {int} song under Recently Played category")
    public void playSongUnderRecentlyPlayedCategory(int numberOfSongsPlayed) {
        homePage.playSongUnderRecentlyPlayedCategory(numberOfSongsPlayed);
    }

    @When("I double-click {int} song under Recently Added category")
    public void playSongUnderRecentlyAddedCategory(int numberOfSongsPlayed) {
        homePage.playSongUnderRecentlyAddedCategory(numberOfSongsPlayed);
    }

    @When("I double-click {int} song under Top Artists category")
    public void playSongUnderTopArtistsCategory(int numberOfSongsPlayed) {
        homePage.playSongUnderTopArtistsCategory(numberOfSongsPlayed);
    }

    @When("I double-click {int} song under Top Albums category")
    public void playSongUnderTopAlbumsCategory(int numberOfSongsPlayed) {
        homePage.playSongUnderTopAlbumsCategory(numberOfSongsPlayed);
    }
}
