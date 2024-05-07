package StepDefinition;

import io.cucumber.java.en.When;
import pages.SidePanel;

public class SidePanelStepDefinition {

    SidePanel sidePanel = new SidePanel(BaseDefinition.getThreadLocal());

    @When("I search for the artist {string} using the search bar")
    public void searchASongUsingSearchBar(String artistName) {
        sidePanel.searchArtistUsingSearchBar(artistName);
    }
}
