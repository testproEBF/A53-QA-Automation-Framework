package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavoritesPage extends BasePage{

    public FavoritesPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath = "//*[@class=\"playlist favorites\"]")
    private WebElement favorites;
    By favoritesLocator = By.xpath("//*[@class=\"song-list-wrap main-scroll-wrap favorites\"]//*[@class=\"song-item\"]");

    public void goToFavoritesPage() {
        favorites.click();
    }

    public void playSongInFavoritesPage(int numberOfSongsPlayed) {
        String favoritesLocatorFormat = "(//*[@class=\"song-list-wrap main-scroll-wrap favorites\"]//*[@class=\"song-item\"])[%s]";
        String message = "The total number of songs in Favorites Page is ";
        playSong(numberOfSongsPlayed, message, favoritesLocatorFormat, favoritesLocator);
    }
}
