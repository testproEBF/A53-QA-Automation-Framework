import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class Homework21 extends BaseTest{

    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    @Parameters({"email", "password"})
    public void renamePlaylist(String email, String password){
        provideEmail(email);
        providePassword(password);
        clickSubmit();

        String playlistNewName = generateRandomName();
        String newPlaylistName = generateRandomName();

        clickPlusButton();
        createNewPlaylist(newPlaylistName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("Created playlist")));

        //right-click Playlist
        contextClickPlaylist(newPlaylistName);

        //choose Edit
        chooseEdit();

        //enter new name
        enterPlaylistNewName(playlistNewName);

        //assertion
        String expectedSuccessMessage = String.format("Updated playlist \"%s.\"", playlistNewName);
        Assert.assertEquals(getNotification(), expectedSuccessMessage);

    }

    public void contextClickPlaylist(String newPlaylistName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(newPlaylistName)));
        actions.contextClick(playlist).perform();
    }

    public void chooseEdit(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Actions actions = new Actions(driver);
        WebElement editOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid*=\"playlist-context-menu-edit\"]")));
        actions.click(editOption).perform();
    };

    public void enterPlaylistNewName(String playlistNewName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editPlaylistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name=\"name\"]")));
        editPlaylistNameField.sendKeys(Keys.chord(Keys.COMMAND,"A",Keys.BACK_SPACE));
        editPlaylistNameField.sendKeys(playlistNewName);
        editPlaylistNameField.sendKeys(Keys.ENTER);
    }

}
