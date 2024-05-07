package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AllSongsPage;
import pages.CurrentQueuePage;
import pages.LoginPage;

import java.text.ParseException;

public class CurrentQueueStepDefinition {
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(BaseDefinition.getThreadLocal());
    AllSongsPage allSongsPage = new AllSongsPage(BaseDefinition.getThreadLocal());
    LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());

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

    @Then("I will see the total length of the {int} songs under the text Current Queue")
    public void checkPresenceOfTotalLengthOfSongs(int numberOfSongs) throws ParseException {
        currentQueuePage.checkPresenceOfTotalLengthOfSongs(numberOfSongs);
    }


    @Then("I will be navigated to Current Queue page")
    public void checkIfNavigatedToCurrentQueuePage() {
        currentQueuePage.checkIfNavigatedToCurrentQueuePage();
    }

    @Then("I will see the track numbers of the {int} songs")
    public void checkPresenceOfTrackNumber(int numberOfSongs) {
        currentQueuePage.checkPresenceOfTrackNumber(numberOfSongs);
    }

    @Then("I will see the titles of the {int} songs")
    public void checkPresenceOfTitle(int numberOfSongs) {
        currentQueuePage.checkPresenceOfTitle(numberOfSongs);
    }

    @Then("I will see the artists of the {int} songs")
    public void checkPresenceOfArtist(int numberOfSongs) {
        currentQueuePage.checkPresenceOfArtist(numberOfSongs);
    }

    @Then("I will see the albums of the {int} songs")
    public void checkPresenceOfAlbum(int numberOfSongs) {
        currentQueuePage.checkPresenceOfAlbum(numberOfSongs);
    }

    @Then("I will see the total length of the {int} songs")
    public void checkPresenceOfPlaytime(int numberOfSongs) {
        currentQueuePage.checkPresenceOfPlaytime(numberOfSongs);
    }

    @And("I get the titles of the {int} songs in order")
    public void getSongTitlesInOrder(int numberOfSongs) {
        currentQueuePage.getSongTitlesInOrderBeforeShuflle(numberOfSongs);
    }

    @And("I click the Shuffle button")
    public void clickShuffleButton() {
        currentQueuePage.clickShuffleButton();
    }

    @And("I get the titles of the {int} songs in order after shuffle")
    public void getSongTitlesInOrderAfterShuffle(int numberOfSongs) {
        currentQueuePage.getSongTitlesInOrderAfterShuffle(numberOfSongs);
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
    @And("I click shuffling all songs hyperlink text")
    public void clickHyperlinkText() {
            currentQueuePage.clickHyperlinkText();
    }

    @Then("all the songs in All Songs Page is displayed")
    public void checkAllSongsAreInCurrentQueuePage() {
        String expectedNumberOfSongs = allSongsPage.allSongsTotalCountPlaytimeText.getText();
        currentQueuePage.checkTotalNumberOfSongsUnderCurrentQueueText(expectedNumberOfSongs);
    }

}
