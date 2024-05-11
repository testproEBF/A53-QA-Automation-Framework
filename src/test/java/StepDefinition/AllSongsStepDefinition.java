package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.AllSongsPage;

public class AllSongsStepDefinition {
    AllSongsPage allSongsPage = new AllSongsPage(BaseDefinition.getThreadLocal());

    @When("I navigate to All Songs page")
    public void navigateToAllSongsPage() {
        allSongsPage.goToAllSongsPage();
    }


    @And("I play {int} out of {int} songs")
    public void playSongs(int numberOfPlayedSongs) {
        allSongsPage.playSongInAllSongsPage(numberOfPlayedSongs);
    }

    @And("I play {int} songs in All Songs Page")
    public void playSongsInAllSongsPage(int numberOfPlayedSongs) {
        navigateToAllSongsPage();
        playSongs(numberOfPlayedSongs);
    }

}
