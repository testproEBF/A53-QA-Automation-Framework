package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CurrentQueuePage;

public class CurrentQueueStepDefinition {
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(BaseDefinition.SHARED_DRIVER);

    @And("I navigate to Current Queue page")
    public void navigateToCurrentQueuePage() {
        currentQueuePage.goToCurrentQueuePage();
    }

    @Then("I will see all {int} songs")
    public void checkPresenceOfSongs(int numberOfSongs) {
        currentQueuePage.checkPresenceOfSongs(numberOfSongs);
    }

    @Then("I will see the {int} total number of songs under the text Current Queue")
    public void checkTotalNumberOfSongs(int numberOfSongs) {
        currentQueuePage.checkTotalNumberOfSongs(numberOfSongs);
    }

    @Then("I will be navigated to Current Queue page")
    public void checkIfNavigatedToCurrentQueuePage() {
        currentQueuePage.checkIfNavigatedToCurrentQueuePage();
    }

    @Then("I will see track numbers for the {int} songs")
    public void checkPresenceOfTrackNumber(int songNumber) {
        currentQueuePage.checkPresenceOfTrackNumber(songNumber);
    }
}
