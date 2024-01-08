import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19 extends BaseTest{

    @Test
    @Parameters({"email", "password"})
    public void deletePlaylist(String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickSubmit();

        //create playlist
        String newPlaylistName = generateRandomName();
        clickPlusButton();
        createNewPlaylist(newPlaylistName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("Created playlist")));

        //delete playlist
        deleteEmptyPlaylist(newPlaylistName);

        //Assertion
        String expectedSuccessMessage = String.format("Deleted playlist \"%s.\"", newPlaylistName);
        Assert.assertEquals(getNotification(), expectedSuccessMessage);

    }

    public void clickPlusButton() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playlistPlusButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title=\"Create a new playlist\"]")));
        playlistPlusButton.click();
    }

    public void createNewPlaylist(String newPlaylistName) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement newPlaylistList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid=\"playlist-context-menu-create-simple\"]")));
        newPlaylistList.click();

        WebElement playlistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists [type=\"text\"]")));
        playlistNameField.click();
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.RETURN);
    }

    public void selectPlaylist(String newPlaylistName) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(newPlaylistName)));
        playlist.click();
    }

    public void clickDeletePlaylistButton(String newPlaylistName) throws InterruptedException{
        selectPlaylist(newPlaylistName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".del.btn-delete-playlist")));
        deletePlaylistButton.click();
    }

    public void deleteEmptyPlaylist(String newPlaylistName) throws InterruptedException{
        clickDeletePlaylistButton(newPlaylistName);
    }

    public String getNotification (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actualNotificationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        return actualNotificationText.getText();
    }
}
