package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.AlbumsPage;
import pages.ArtistsPage;

public class ArtistsStepDefinition {
    ArtistsPage artistsPage = new ArtistsPage(BaseDefinition.SHARED_DRIVER);

    @When("I navigate to Artists page")
    public void navigateToAllSongsPage() {
        artistsPage.goToArtistsPage();
    }

    @And("I play {int} artist in Artists page")
    public void playArtist(int numberOfPlayedArtist) {
        artistsPage.playArtists(numberOfPlayedArtist);
    }
}
