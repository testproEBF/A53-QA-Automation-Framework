import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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

    @Test
    @Parameters({"email", "password"})
    public void createPlaylists(String email, String password) {

        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.provideEmail(email)
                .providePassword(password)
                .clickSubmit();
        int x = basePage.countNumberOfPlaylist();
        int y = 20;
        for (int i = 1; i < +x; i++) {
            String newPlaylistName = basePage.generateRandomName();

            basePage.clickPlusButton()
                    .clickNewPlaylist()
                    .enterPlaylistName(newPlaylistName);
        }

        int z = basePage.countNumberOfPlaylist();
        Assert.assertEquals(y,x+y);
    }


    @Test
    @Parameters({"email", "password"})
    public void deleteEmptyPlaylists(String email, String password) throws TimeoutException {
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.login(email, password);

        int x = basePage.countNumberOfPlaylist();
        System.out.println("There are currently " + x + " playlist/s.");

        for (int i = 0; i <= x; i++){
            By locator = By.cssSelector("a[href*=\"playlist\"]");
            basePage.contextClickElement(locator);
            By shuffleAllLocator = By.cssSelector("#playlistWrapper .btn-shuffle-all");

            if (basePage.findNullElement(shuffleAllLocator) == true){
                playlistPage.clickDelete();
            } else {
                Assert.assertTrue(basePage.findElement(shuffleAllLocator).isDisplayed());
            }
        }

    }

}
