package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.RecentlyPlayedPage;

public class RecentlyPlayedStepDefinition {

    RecentlyPlayedPage recentlyPlayedPage = new RecentlyPlayedPage(BaseDefinition.SHARED_DRIVER);

    @When("I navigate to Recently Played page")
    public void goToRecentlyPlayedPage() {
        recentlyPlayedPage.goToRecentlyPlayedPage();
    }

    @And("I play {int} song in Recently Played page")
    public void playSongInRecentlyPlayedPage(int numberOfSongsPlayed) {
        recentlyPlayedPage.playSongInRecentlyPlayedPage(numberOfSongsPlayed);
    }
}
