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

    @Test
    @Parameters({"email", "password"})
    public void createPlaylist(String email, String password) {

        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.provideEmail(email)
                .providePassword(password)
                .clickSubmit();

        int x = basePage.countNumberOfPlaylist();
        System.out.println("There is/are currently " + x + " playlist/s.");
        int y = 10;
        for (int i = 1; i <= +y; i++) {
            String newPlaylistName = basePage.generateRandomName();

            basePage.clickPlusButton()
                    .clickNewPlaylist()
                    .enterPlaylistName(newPlaylistName);
            System.out.println("Added " + i + " playlist/s.");
        }
        int z = basePage.countNumberOfPlaylist();
        System.out.println("There are now " + x + " playlist/s.");
        Assert.assertEquals(z,x+y);
    }


    @Test
    @Parameters({"email", "password"})
    public void deleteEmptyPlaylist(String email, String password) throws TimeoutException{
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.login(email, password);

        int x = basePage.countNumberOfPlaylist();
        System.out.println("There is/are currently " + x + " playlist/s.");

        for (int i = 0; i <= x; i++){
            By locator = By.cssSelector("a[href*=\"playlist\"]");
            basePage.contextClickElement(locator);
            By shuffleAllLocator = By.cssSelector("#playlistWrapper .btn-shuffle-all");

            if (basePage.findNullElement(shuffleAllLocator) == true){
                playlistPage.clickDelete();
            } else {
                int y = basePage.countNumberOfPlaylist();
                System.out.println("There are remaining " + y + " playlist/s.");
                Assert.assertTrue(basePage.findElement(shuffleAllLocator).isDisplayed());
            }
        }

    }

}
