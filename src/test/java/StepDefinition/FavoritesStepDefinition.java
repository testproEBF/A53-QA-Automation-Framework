package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.FavoritesPage;

public class FavoritesStepDefinition {

    FavoritesPage favoritesPage = new FavoritesPage (BaseDefinition.getThreadLocal());

    @When("I navigate to Favorites page")
    public void gooFavoritesPage() {
        favoritesPage.goToFavoritesPage();
    }

    @And("I play {int} song in Favorites page")
    public void playSongInFavoritesPage(int numberOfSongsPlayed) {
        favoritesPage.playSongInFavoritesPage(numberOfSongsPlayed);
    }
}
