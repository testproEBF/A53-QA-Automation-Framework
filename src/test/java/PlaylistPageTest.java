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

        loginPage.provideEmail(email)
                 .providePassword(password)
                 .clickSubmit();

        String playlistNewName = basePage.generateRandomName();
        String newPlaylistName = basePage.generateRandomName();
        String message = "Created playlist";

        By playlist = By.linkText(newPlaylistName);


        basePage.clickPlusButton()
                .clickNewPlaylist()
                .enterPlaylistName(newPlaylistName)
                .waitForInvisibility(message)
                .contextClickElement(playlist);

        playlistPage.clickEdit()
                    .deletePlaylistName()
                    .enterNewPlaylistName(playlistNewName);

        //assertion
        String expectedSuccessMessage = String.format("Updated playlist \"%s.\"", playlistNewName);
        Assert.assertEquals(basePage.getNotification(), expectedSuccessMessage);

    }

}
