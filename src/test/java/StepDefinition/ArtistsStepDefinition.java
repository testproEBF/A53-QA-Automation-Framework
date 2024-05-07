package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ArtistsPage;

public class ArtistsStepDefinition {
    ArtistsPage artistsPage = new ArtistsPage(BaseDefinition.getThreadLocal());

    @When("I navigate to Artists page")
    public void navigateToAllSongsPage() {
        artistsPage.goToArtistsPage();
    }

    @And("I play {int} artist in Artists page")
    public void playArtist(int numberOfPlayedArtist) {
        artistsPage.playArtists(numberOfPlayedArtist);
    }

    @Then("Artists page will be displayed")
    public void displayArtistsPage() {
        artistsPage.displayArtistsPage();
    }

    @And("I will see the artists in thumbnail view")
    public void displayArtistsInThumbnailViewInAlphabeticalOrder() {
        artistsPage.displayArtistsInThumbnailView();
    }

    @When("I click the View as list button on the top right of the page")
    public void clickArtistViewAsListButton() {
        artistsPage.clickArtistViewAsListButton();
    }

    @Then("I will see the artists in a list view")
    public void displayArtistsInAListViewInAlphabeticalOrder() {
        artistsPage.displayArtistsInAListView();
    }

    @When("I click the View as thumbnails button beside the View as list button")
    public void clickArtistsViewAsThumbnailsButton() {
        artistsPage.clickArtistsViewAsThumbnailsButton();
    }

    @And("I click {string} artist's thumbnail in {string} view")
    public void clickArtistSThumbnail(String artistName, String viewMode) {
        artistsPage.clickArtistsThumbnail(artistName, viewMode);
    }

    @And("the selected {string} artist's songs will be added to the queue")
    public void checkArtistSSongsAreAddedToCurrentQueue(String artistName) {
        artistsPage.checkArtistSSongsAreAddedToCurrentQueue(artistName);
    }

    @And("the artist's songs will automatically play")
    public void checkArtistSSongSAutomaticallyPlay() {
        artistsPage.checkArtistSSongSAutomaticallyPlay();
    }

    @And("I click artist's name in {string} view")
    public void clickArtistSName(String viewMode){
        artistsPage.clickArtistSName(viewMode);
    }

    @Then("I will be navigated to the artist's page")
    public void navigatedToArtistSPage() {
        artistsPage.navigatedToArtistSPage();
    }

    @And("I will be able to play a song")
    public void playArtistSSongs(){
        artistsPage.playArtistSSongs();
    }

}

