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

    @And("I input {string} in the name text field")
    public void inputName(String name) {
        playlistPage.inputName(name);
    }

    @And("I make a rule with value {string}")
    public void makeARule(String value) {
        playlistPage.makeARule(value);
    }

    @And("I click on the Save button")
    public void clickSaveButton() {
        playlistPage.clickSaveButton();
    }

    @Then("a notification that says the smart playlist has been created will pop up")
    public void playlistCreatedNotification() {
        playlistPage.playlistCreatedNotification();
    }


    @And("I will see the created playlist {string} with an asterisk icon and with the correct name under PLAYLISTS")
    public void checkCreatedSmartPlaylist(String name) {
        basePage.checkCreatedSmartPlaylist(name);
    }

    @And("I will see the created playlist with an asterisk icon and with the correct name under PLAYLISTS")
    public void checkCreatedSmartPlaylistRandomName() {
        playlistPage.checkCreatedSmartPlaylistRandomName();
    }


    @And("I will see the song {string} in the playlist {string}")
    public void checkSongsInSmartPlaylist(String song, String name) {
        playlistPage.checkSongsInSmartPlaylist(song, name);
    }

    @And("I am on New Smart Playlist Form")
    public void toNewSmartPlaylistForm() {
        basePage.toNewSmartPlaylistForm();
    }

    @And("I make {int} rules with value {string}")
    public void makeMultipleRules(int numOfRules, String value) {
        playlistPage.makeMultipleRules(numOfRules, value);
    }

    @And("I will see empty playlist")
    public void seeEmptyPlaylist() {
        playlistPage.seeEmptyPlaylist();
    }

    @And("I make {int} groups with value {string}")
    public void makeMultipleGroups(int numOfGroups, String value) {
        playlistPage.makeMultipleGroups(numOfGroups, value);
    }


    @Then("I stay in the New Smart Playlist Form")
    public void stillInNewSmartPlaylistForm() {
        playlistPage.stillInNewSmartPlaylistForm();
    }

    @And("I click on the Cancel button")
    public void clickCancelButton() {
        playlistPage.clickCancelButton();
    }

    @And("I click on the OK button")
    public void clickOKDiscardButton() {
        playlistPage.clickOKDiscardButton();
    }

    @Then("playlist is not created")
    public void playlistNotCreated() {
        playlistPage.elementNotFound();
    }

    @And("I click on the Cancel discard button")
    public void clickCancelDiscardButton() {
        playlistPage.clickCancelDiscardButton();
    }


    @And("I input a {int}-char playlist name in the name text field")
    public void iInputACharInTheNameTextField(int length) {
        playlistPage.inputRandomName(length);
    }

    @And("I will see the song {string} in the playlist")
    public void checkSongsInSmartPlaylist(String song) {
        playlistPage.checkSongsInSmartPlaylistRandomName(song);
    }
}