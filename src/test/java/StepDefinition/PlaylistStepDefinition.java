package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BasePage;

public class PlaylistStepDefinition {
    String newPlaylistName = BasePage.generateRandomName();

    @When("^I click the plus button")
    public void clickPlusButton() {
        BasePage.clickPlusButton();
    }

    @And("I click New Playlist")
    public void clickNewPlaylist() {
        BasePage.clickNewPlaylist();
    }

    
    @And("I enter playlist name")
    public void enterPlaylistName() {
        BasePage.enterPlaylistName(newPlaylistName);
    }

    @Then("I created a playlist")
    public void createdPlaylist() {
        String expectedSuccessMessage = String.format("Created playlist \"%s.\"", newPlaylistName);
        Assert.assertEquals(BasePage.getNotification(), expectedSuccessMessage);
    }
}
