package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.PlaylistPage;
import pages.SmartPlaylistPage;

public class PlaylistStepDefinition {

    PlaylistPage playlistPage = new PlaylistPage(BaseDefinition.SHARED_DRIVER);

    @When("I navigate to my playlist page")
    public void goToMyPlaylistPage() {
        playlistPage.goToPlaylistPage();
    }

    @And("I play {int} song in my playlist page")
    public void playSongInPlaylist(int numberOfSongsPlayed) {
        playlistPage.playSongInPlaylist(numberOfSongsPlayed);
    }
}
