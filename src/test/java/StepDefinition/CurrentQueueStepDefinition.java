package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AllSongsPage;
import pages.CurrentQueuePage;

public class CurrentQueueStepDefinition {
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(BaseDefinition.SHARED_DRIVER);
    AllSongsPage allSongsPage = new AllSongsPage(BaseDefinition.SHARED_DRIVER);

    @And("I navigate to Current Queue page")
    public void navigateToCurrentQueuePage() {
        currentQueuePage.goToCurrentQueuePage();
    }

    @Then("I will see all {int} songs")
    public void checkPresenceOfSongs(int numberOfSongs) {
        currentQueuePage.checkPresenceOfSongs(numberOfSongs);
    }

    @Then("I will see the {int} total number of songs under the text Current Queue")
    public void checkPresenceOfTotalNumberOfSongs(int numberOfSongs) {
        currentQueuePage.checkTotalNumberOfSongs(numberOfSongs);
    }

    @Then("I will see the total duration of songs under the text Current Queue")
    public void checkPresenceOfTotalDurationOfSongs() {
        currentQueuePage.checkPresenceOfTotalDurationOfSongs();
    }

    @Then("I will be navigated to Current Queue page")
    public void checkIfNavigatedToCurrentQueuePage() {
        currentQueuePage.checkIfNavigatedToCurrentQueuePage();
    }

    @Then("I will see the track numbers of the {int} songs")
    public void checkPresenceOfTrackNumber(int numberOfSong) {
        currentQueuePage.checkPresenceOfTrackNumber(numberOfSong);
    }

    @Then("I will see the titles of the {int} songs")
    public void checkPresenceOfTitle(int numberOfSong) {
        currentQueuePage.checkPresenceOfTitle(numberOfSong);
    }

    @Then("I will see the artists of the {int} songs")
    public void checkPresenceOfArtist(int numberOfSong) {
        currentQueuePage.checkPresenceOfArtist(numberOfSong);
    }

    @Then("I will see the albums of the {int} songs")
    public void checkPresenceOfAlbum(int numberOfSong) {
        currentQueuePage.checkPresenceOfAlbum(numberOfSong);
    }

    @Then("I will see the playtime of the {int} songs")
    public void checkPresenceOfPlaytime(int numberOfSong) {
        currentQueuePage.checkPresenceOfPlaytime(numberOfSong);
    }

    @And("I get the titles of the {int} songs in order")
    public void getSongTitlesInOrder(int numberOfSong) {
        currentQueuePage.getSongTitlesInOrderBeforeShuflle(numberOfSong);
    }

    @And("I click the Shuffle button")
    public void clickShuffleButton() {
        currentQueuePage.clickShuffleButton();
    }

    @And("I get the titles of the {int} songs in order after shuffle")
    public void getSongTitlesInOrderAfterShuffle(int numberOfSong) {
        currentQueuePage.getSongTitlesInOrderAfterShuffle(numberOfSong);
    }

    @Then("the songs will be shuffled")
    public void checkSongsAreShuffled() {
        currentQueuePage.checkSongsAreShuffled();
    }

    @And("I click the Clear button")
    public void clickClearButton() {
        currentQueuePage.clickClearButton();
    }

    @Then("the Current Queue list will be empty")
    public void checkIfCurrentQueueListIsEmpty() {
        currentQueuePage.checkIfCurrentQueueListIsEmpty();
    }

    @And("{string} message will be displayed")
    public void getDisplayedMessage(String emptyQueueMessage) {
        currentQueuePage.getDisplayedMessage(emptyQueueMessage);
    }

    @And("I click {string} hyperlink text")
    public void clickHyperlinkText(String shufflingAllSongsText) {
        currentQueuePage.clickHyperlinkText(shufflingAllSongsText);
    }

    @Then("all the songs in All Songs Page is displayed")
    public void checkAllSongsAreInCurrentQueuePage() {
        currentQueuePage.checkTotalNumberOfSongs(allSongsPage.TOTAL_NUMBER_OF_SONGS);
    }

}
