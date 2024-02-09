package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaylistPage extends BasePage {

    public PlaylistPage (WebDriver givenDriver){
        super (givenDriver);
    }

    @FindBy( css = "li[data-testid=\"playlist-context-menu-create-smart\"]")
    private WebElement newSmartPlaylistOption;


    public PlaylistPage clickNewSmartPlaylist() {
        newSmartPlaylistOption.click();
        return this;
    }

}