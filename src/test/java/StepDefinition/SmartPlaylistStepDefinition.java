package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.SmartPlaylistPage;

public class SmartPlaylistStepDefinition {

    SmartPlaylistPage smartPlaylistPage = new SmartPlaylistPage(BaseDefinition.getThreadLocal());

    @When("I navigate to my smart playlist page")
    public void goToSmartPlaylistPage() {
        smartPlaylistPage.goToSmartPlaylistPage();
    }

    @And("I play {int} song in my smart playlist page")
    public void playSongInSmartPlaylist(int numberOfSongsPlayed) {
        smartPlaylistPage.playSongInSmartPlaylist(numberOfSongsPlayed);
    }
}
