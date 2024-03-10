package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.AlbumsPage;

public class AlbumsStepDefinition {
    AlbumsPage albumsPage = new AlbumsPage(BaseDefinition.SHARED_DRIVER);

    @When("I navigate to Albums page")
    public void navigateToAlbumsPage() {
        albumsPage.goToAlbumsPage();
    }

    @And("I play {int} out of {int} albums")
    public void playAlbum(int numberOfPlayedAlbums, int totalNumberOfAlbums) {
        albumsPage.playAlbum(numberOfPlayedAlbums, totalNumberOfAlbums);
    }
}
