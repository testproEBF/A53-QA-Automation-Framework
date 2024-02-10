package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.PlaylistPage;

public class CreateSmartPlaylistStepDefinition {

    BasePage basePage = new BasePage(BaseDefinition.SHARED_DRIVER);
    PlaylistPage playlistPage = new PlaylistPage(BaseDefinition.SHARED_DRIVER);;

    @When("I click on the + button under PLAYLISTS on the main menu")
    public void clickPlusButton() {
        playlistPage.clickPlusButton();

    }

    @And("I click on New Smart Playlist")
    public void clickNewSmartPlaylist() {
        basePage.clickNewSmartPlaylist();
    }

    @And("I input {string} on the name text field")
    public void inputAOneCharacterName(String name) {
        playlistPage.inputOneCharName(name);
    }

    @And("I make a rule {string}")
    public void makeARule(String sec) {
        playlistPage.makeARule(sec);
    }

    @And("I click on the Save button")
    public void clickSaveButton() {
        playlistPage.clickSaveButton();
    }

    @Then("a notification that says the smart playlist {string} has been created will pop up")
    public void playlistCreatedNotification(String name) {
        basePage.playlistCreatedNotification(name);
    }

    @And("I will see the created playlist {string} with an asterisk icon and with the correct name under PLAYLISTS")
    public void checkCreatedSmartPlaylist(String name) {
        basePage.checkCreatedSmartPlaylist(name);
    }


    @And("I will see the song {string} in the playlist {string}")
    public void checkSongsInSmartPlaylist(String song, String name) {
        playlistPage.checkSongsInSmartPlaylist(song, name);
    }

    @And("I am on New Smart Playlist Form")
    public void toNewSmartPlaylistForm() {
        basePage.toNewSmartPlaylistForm();
    }
}