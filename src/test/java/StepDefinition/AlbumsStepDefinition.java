package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.AlbumsPage;

public class AlbumsStepDefinition {
    AlbumsPage albumsPage = new AlbumsPage(BaseDefinition.getThreadLocal());

    @When("I navigate to Albums page")
    public void navigateToAlbumsPage() {
        albumsPage.goToAlbumsPage();
    }

    @And("I play {int} album in Albums page")
    public void playAlbum(int numberOfPlayedAlbums) {
        albumsPage.playAlbum(numberOfPlayedAlbums);
    }


}
