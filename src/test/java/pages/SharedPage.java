package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SharedPage extends BasePage {
    public SharedPage (WebDriver givenDriver){
        super (givenDriver);
    }

    By playlistPlusButton = By.cssSelector("[title=\"Create a new playlist\"]");
    By newPlaylistList = By.cssSelector("[data-testid=\"playlist-context-menu-create-simple\"]");
    By playlistNameField = By.cssSelector("#playlists [type=\"text\"]");


    public void clickPlusButton(){
        findElement(playlistPlusButton).click();
    }

    public void clickNewPlaylist(String newPlaylistName){
        findElement(newPlaylistList).click();
        findElement(playlistNameField).click();
        findElement(playlistNameField).sendKeys(newPlaylistName);
        findElement(playlistNameField).sendKeys(Keys.RETURN);
    }

}

