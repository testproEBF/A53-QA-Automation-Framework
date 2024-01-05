import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException{
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        searchSong("dee");
        Thread.sleep(2000);

        selectFirstSong();
        Thread.sleep(2000);
        clickAddToButton();
        Thread.sleep(2000);
        String newPlaylistName = generateRandomPlaylistName();
        createNewPlaylist(newPlaylistName);
        Thread.sleep(2000);

        //Assertion
        String successMessage = String.format("Created playlist \"%s.\"", newPlaylistName);
        System.out.println(successMessage);
        WebElement actualNotificationText = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertEquals(actualNotificationText.getText(), successMessage);

    }

    public void searchSong(String songTitle){
        WebElement searchField = driver.findElement(By.cssSelector("input[type=\"search\"]"));
        searchField.clear();
        searchField.sendKeys(songTitle);
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test=\"view-all-songs-btn\"]"));
        viewAllButton.click();
    }

    public String generateRandomPlaylistName(){
        return UUID.randomUUID().toString().replace("-", "");
    }
    public void selectFirstSong() {
        WebElement firstSongResult = driver.findElement(By.cssSelector("#songResultsWrapper tr.song-item:nth-child(1)"));
        firstSongResult.click();
    }

    public void clickAddToButton() {
        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToButton.click();
    }

    public void createNewPlaylist(String newPlaylistName){
        WebElement newPlaylistNameField = driver.findElement(By.cssSelector("#songResultsWrapper input[type=\"text\""));
        newPlaylistNameField.click();
        newPlaylistNameField.sendKeys(newPlaylistName);
        WebElement submitButton = driver.findElement(By.cssSelector("#songResultsWrapper button[type=\"submit\""));
        submitButton.click();
    }
}
