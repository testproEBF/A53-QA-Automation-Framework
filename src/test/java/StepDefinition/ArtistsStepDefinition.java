package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ArtistsPage;
import pages.MainFooterPage;

public class ArtistsStepDefinition {
    ArtistsPage artistsPage = new ArtistsPage(BaseDefinition.getThreadLocal());
    MainFooterPage mainFooterPage = new MainFooterPage(BaseDefinition.getThreadLocal());

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
        artistsPage.checkArtistsDisplayedInThumbnailView();
    }

    @When("I click the View as list button on the top right of the page")
    public void clickArtistViewAsListButton() {
        artistsPage.clickArtistViewAsListButton();
    }

    @Then("I will see the artists in a list view")
    public void displayArtistsInAListViewInAlphabeticalOrder() {
        artistsPage.checkArtistsDisplayedInListView();
    }

    @When("I click the View as thumbnails button beside the View as list button")
    public void clickArtistSViewAsThumbnailsButton() {
        artistsPage.clickArtistViewAsThumbnailsButton();
    }

    @And("I click the View as {string} button on the top right of the page")
    public void selectArtistsPageViewMode(String viewModeButton) {
        if (viewModeButton.equals("List")){
            artistsPage.clickArtistViewAsListButton();
        } else {
            artistsPage.clickArtistViewAsThumbnailsButton();
        }
    }

    @And("I click {string} artist's thumbnail in {string} view")
    public void clickArtistSThumbnail(String artistName, String viewMode) throws InterruptedException {
        artistsPage.clickArtistSThumbnail(artistName, viewMode);
    }

    @And("the selected {string} artist's songs will be added to the queue")
    public void checkArtistSSongsAreAddedToCurrentQueue(String artistName) {
        artistsPage.checkArtistSSongsAreAddedToCurrentQueue(artistName);
    }

    @And("the artist's songs will automatically play")
    public void checkArtistSSongSAutomaticallyPlay() {
        mainFooterPage.checkArtistSSongIsPlaying();
    }


    @And("I click artist's name in {string} view")
    public void clickArtistSName(String viewMode) throws InterruptedException{
        artistsPage.clickArtistSName(viewMode);
    }

    @Then("I will be navigated to the artist's page")
    public void navigatedToArtistSPage() {
        artistsPage.navigatedToArtistSPage();
    }

    @When("I play any of the artist's songs")
    public void playAnyOfTheArtistSSongs() {
        artistsPage.playArtistSSongs();
    }

    @Then("the song will be played")
    public void theSongWillBePlayed() {
        mainFooterPage.checkArtistSSongIsPlaying();
    }
}

