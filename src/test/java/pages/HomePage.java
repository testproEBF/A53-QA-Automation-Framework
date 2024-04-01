package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By mostPlayedSongLocator = By.xpath("//*[@class=\"top-song-list\"]//*[@data-test=\"song-card\"]");
    By recentlyPlayedSongLocator = By.xpath("//*[@class=\"recent-song-list\"]//*[@data-test=\"song-card\"]");
    By recentlyAddedSongLocator = By.xpath("//*[@class=\"recently-added-album-list\"]//*[@class=\"item compact\"]");
    By topArtistsSongLocator = By.xpath("//*[@class=\"two-cols top-artist-list\"]//*[@class=\"item compact\"]");
    By topAlbumsSongLocator = By.xpath("//*[@class=\"two-cols top-album-list\"]//*[@class=\"item compact\"]");


    public void playSongUnderMostPlayedCategory(int numberOfSongsPlayed) {
        String mostPlayedLocatorFormat = "(//*[@class=\"top-song-list\"]//*[@data-test=\"song-card\"])[%s]";
        String message = "The number of songs in Most Played Category is ";


        playSong(numberOfSongsPlayed, message, mostPlayedLocatorFormat, mostPlayedSongLocator);
    }

    public void playSongUnderRecentlyPlayedCategory(int numberOfSongsPlayed) {
        String recentlyPlayedLocatorFormat = "(//*[@class=\"recent-song-list\"]//*[@data-test=\"song-card\"])[%s]";
        String message = "The number of songs in Recently Played Category is ";
        playSong(numberOfSongsPlayed, message, recentlyPlayedLocatorFormat, recentlyPlayedSongLocator);
    }

    public void playSongUnderRecentlyAddedCategory(int numberOfSongsPlayed) {
        String recentlyAddedLocatorFormat = "(//*[@class=\"recently-added-album-list\"]//*[@class=\"item compact\"])[%s]";
        String message = "The number of songs in Recently Added Category is ";
        playSong(numberOfSongsPlayed, message, recentlyAddedLocatorFormat, recentlyAddedSongLocator);
    }

    public void playSongUnderTopArtistsCategory(int numberOfSongsPlayed) {
        String topArtistsLocatorFormat = "(//*[@class=\"two-cols top-artist-list\"]//*[@class=\"item compact\"])[%s]";
        String message = "The number of songs in Top Artists Category is ";
        playSong(numberOfSongsPlayed, message, topArtistsLocatorFormat, topArtistsSongLocator);
    }

    public void playSongUnderTopAlbumsCategory(int numberOfSongsPlayed) {
        String topAlbumsLocatorFormat = "(//*[@class=\"two-cols top-album-list\"]//*[@class=\"item compact\"])[%s]";
        String message = "The number of songs in Top Albums Category is ";
        playSong(numberOfSongsPlayed, message, topAlbumsLocatorFormat, topAlbumsSongLocator);
    }
}
