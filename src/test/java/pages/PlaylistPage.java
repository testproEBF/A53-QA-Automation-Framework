package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaylistPage extends BasePage{

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By playlistLocator = By.xpath("//*[@class=\"playlist playlist\"]");
    By playlistSongLocator = By.xpath("//*[@class=\"song-list-wrap main-scroll-wrap playlist\"]//*[@class=\"song-item\"]");


    public void goToPlaylistPage() {
        String playlistLocatorFormat = "(//*[@class=\"playlist playlist\"])[%s]";
        String message = "The total number of playlist/s is/are ";
        selectPlaylist (message, playlistLocatorFormat, playlistLocator);
    }

    public void playSongInPlaylist(int numberOfPlayedSongs) {
        String playlistSongLocatorFormat = "(//*[@class=\"song-list-wrap main-scroll-wrap playlist\"]//*[@class=\"song-item\"])[%s]";
        String message = "The total number of songs in Playlist " + playlistName + " is ";
        playSong(numberOfPlayedSongs, message, playlistSongLocatorFormat, playlistSongLocator);
    }

}
