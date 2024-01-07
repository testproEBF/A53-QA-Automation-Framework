import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    @Parameters({"email", "password"})
    public void deletePlaylist(String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        Thread.sleep(2000);

        //create playlist
        String newPlaylistName = generateRandomName();
        clickPlusButton();
        createNewPlaylist(newPlaylistName);

        //delete playlist
        deleteEmptyPlaylist(newPlaylistName);

        //Assertion
        String expectedSuccessMessage = String.format("Deleted playlist \"%s.\"", newPlaylistName);
        Assert.assertEquals(getNotification(), expectedSuccessMessage);

    }

    public void clickPlusButton() throws InterruptedException{
        WebElement playlistPlusButton = driver.findElement(By.cssSelector("[title=\"Create a new playlist\"]"));
        playlistPlusButton.click();
        Thread.sleep(2000);
    }

    public void createNewPlaylist(String newPlaylistName) throws InterruptedException{
        WebElement newPlaylistList = driver.findElement(By.cssSelector("[data-testid=\"playlist-context-menu-create-simple\"]"));
        newPlaylistList.click();
        Thread.sleep(2000);

        WebElement playlistNameField = driver.findElement(By.cssSelector("#playlists [type=\"text\"]"));
        playlistNameField.click();
        playlistNameField.sendKeys(newPlaylistName);
        Thread.sleep(2000);
        playlistNameField.sendKeys(Keys.RETURN);

        Thread.sleep(2000);
    }

    public void selectPlaylist(String newPlaylistName) throws InterruptedException{
        WebElement playlist = driver.findElement(By.linkText(newPlaylistName));
        Assert.assertNotNull(playlist);
        playlist.click();

        Thread.sleep(2000);
    }

    public void clickDeletePlaylistButton(String newPlaylistName) throws InterruptedException{
        selectPlaylist(newPlaylistName);
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        deletePlaylistButton.click();
        Thread.sleep(2000);
    }

    public void deleteEmptyPlaylist(String newPlaylistName) throws InterruptedException{
        clickDeletePlaylistButton(newPlaylistName);
    }

    public String getNotification (){
        WebElement actualNotificationText = driver.findElement(By.cssSelector(".success.show"));
        return actualNotificationText.getText();
    }
}
