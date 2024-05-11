package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecentlyPlayedPage extends BasePage{

    public RecentlyPlayedPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath = "//*[@class=\"playlist recently-played\"]")
    private WebElement recentlyPlayed;
    By recentlyPlayedLocator = By.xpath("//*[@class=\"song-list-wrap main-scroll-wrap recently-played\"]//*[@class=\"song-item\"]");

    public void goToRecentlyPlayedPage() {
        recentlyPlayed.click();
    }

    public void playSongInRecentlyPlayedPage(int numberOfSongsPlayed) {
        String recentlyPlayedLocatorFormat = "(//*[@class=\"song-list-wrap main-scroll-wrap recently-played\"]//*[@class=\"song-item\"])[%s]";
        String message = "The total number of songs in Recently Played Page is ";
        playSong(numberOfSongsPlayed, message, recentlyPlayedLocatorFormat, recentlyPlayedLocator);
    }

}
