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
    public void renamePlaylist(String email, String password) throws InterruptedException {

        BasePage basePage = new BasePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.provideEmail(email)
                 .providePassword(password)
                 .clickSubmit();

        String playlistNewName = basePage.generateRandomName();
        String newPlaylistName = basePage.generateRandomName();
        String message = "Created playlist";

        By playlist = By.linkText(newPlaylistName);

        /**
         * Workaround firefox & safari issue:
         *  - Firefox issue: `Element <i class="fa fa-plus-circle create"> is not clickable at point (233,321)
         *  because another element <div id="overlay" class="overlay loading"> obscures it`
         *  - Safari issue: `org.openqa.selenium.NoSuchElementException`
         *
         * The assumption is firefox & safari is slow to load the page.
         */
        Thread.sleep(4000);

        basePage.clickPlusButton()
                .clickNewPlaylist()
                .enterPlaylistName(newPlaylistName)
                .waitForInvisibility(message)
                .contextClickElement(playlist, newPlaylistName);

        /**
         * Workaround firefox issue:
         *  `org.openqa.selenium.NoSuchElementException: Unable to locate element: li[data-testid*="playlist-context-menu-edit"]`
         *
         * The assumption is firefox is slow to update UI after playlist name edit.
         */
        Thread.sleep(4000);

        playlistPage.clickEdit()
                    .deletePlaylistName()
                    .enterNewPlaylistName(playlistNewName);

        /**
         * Workaround firefox issue:
         *  `java.lang.AssertionError: expected [Updated playlist "xxx."] but found []`
         *
         * The assumption is firefox is slow to update UI after playlist name edit.
         */
        Thread.sleep(4000);

        //assertion
        String expectedSuccessMessage = String.format("Updated playlist \"%s.\"", playlistNewName);
        Assert.assertEquals(basePage.getNotification(), expectedSuccessMessage);

    }

    @Test
    @Parameters({"email", "password"})
    public void createPlaylist(String email, String password) {

        BasePage basePage = new BasePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login(email, password);

        String newPlaylistName = basePage.generateRandomName();

        basePage.clickPlusButton()
                .clickNewPlaylist()
                .enterPlaylistName(newPlaylistName);

        String expectedSuccessMessage = String.format("Created playlist \"%s.\"", newPlaylistName);
        Assert.assertEquals(basePage.getNotification(), expectedSuccessMessage);
    }


}
