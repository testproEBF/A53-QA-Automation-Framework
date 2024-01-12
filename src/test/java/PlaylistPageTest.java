import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PlaylistPage;
import pages.SharedPage;
import java.time.Duration;

public class PlaylistPageTest extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    public void renamePlaylist(String email, String password) {

        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SharedPage sharedPage = new SharedPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickSubmit();

        String playlistNewName = basePage.generateRandomName();
        String newPlaylistName = basePage.generateRandomName();


        sharedPage.clickPlusButton();
        sharedPage.clickNewPlaylist(newPlaylistName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("Created playlist")));

        //right-click Playlist
        basePage.contextClick(newPlaylistName);

        //choose Edit
        playlistPage.clickEdit(playlistNewName);

        //assertion
        String expectedSuccessMessage = String.format("Updated playlist \"%s.\"", playlistNewName);
        Assert.assertEquals(basePage.getNotification(), expectedSuccessMessage);

    }

}
