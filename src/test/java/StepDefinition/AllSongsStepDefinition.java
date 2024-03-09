package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.AllSongsPage;

public class AllSongsStepDefinition {
    AllSongsPage allSongsPage = new AllSongsPage(BaseDefinition.SHARED_DRIVER);

    @When("I navigate to All Songs page")
    public void navigateToAllSongsPage() {
        allSongsPage.goToAllSongsPage();
    }


    @And("I play {int} out of {int} songs")
    public void playSongs(int numberOfPlayedSongs, int totalNumberOfSongs) {
        allSongsPage.playSongInAllSongsPage(numberOfPlayedSongs, totalNumberOfSongs);
    }

    @And("I play {int} out of {int} songs in All Songs Page")
    public void playSongsInAllSongsPage(int numberOfPlayedSongs, int totalNumberOfSongs) {
        navigateToAllSongsPage();
        playSongs(numberOfPlayedSongs, totalNumberOfSongs);
    }
}
