package StepDefinition;

import io.cucumber.java.en.Then;
import pages.SearchResultsPage;

import javax.naming.directory.SearchResult;

public class SearchResultsStepDefinition {

    SearchResultsPage searchResultsPage = new SearchResultsPage(BaseDefinition.getThreadLocal());

    @Then("I will see {string} under the Artists section of the search results")
    public void displayArtistUnderArtistsInSearchResults(String artistName) {
        searchResultsPage.displayArtistUnderArtistsInSearchResults(artistName);
    }
}
