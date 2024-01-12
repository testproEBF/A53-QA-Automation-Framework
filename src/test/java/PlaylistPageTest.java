import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class PlaylistPageTest extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    public void renamePlaylist(String email, String password) {

        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickSubmit();

        String playlistNewName = basePage.generateRandomName();
        String newPlaylistName = basePage.generateRandomName();


        basePage.clickPlusButton();
        basePage.clickNewPlaylist(newPlaylistName);

        String message = "Created playlist";
        basePage.waitForInvisibility(message);

        //right-click Playlist
        By playlist = By.linkText(newPlaylistName);
        basePage.contextClickElement(playlist);

        //choose Edit
        playlistPage.clickEdit();
        playlistPage.enterPlaylistNewName(playlistNewName);

        //assertion
        String expectedSuccessMessage = String.format("Updated playlist \"%s.\"", playlistNewName);
        Assert.assertEquals(basePage.getNotification(), expectedSuccessMessage);

    }

}
