package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaylistPage extends BasePage {

    public PlaylistPage (WebDriver givenDriver){
        super (givenDriver);
    }

    @FindBy( css = "li[data-testid*=\"playlist-context-menu-edit\"]")
    private WebElement editOption;
    @FindBy( css = "li[data-testid*=\"playlist-context-menu-delete\"]")
    private WebElement deleteOption;
    @FindBy(css = "[name=\"name\"]")
    private WebElement editPlaylistNameField;


    public PlaylistPage clickEdit() {
        editOption.click();
        return this;
    }

    public PlaylistPage clickDelete() {
        deleteOption.click();
        return this;
    }

    public PlaylistPage deletePlaylistName () {
        editPlaylistNameField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        return this;
    }

    public PlaylistPage enterNewPlaylistName (String playlistNewName){
        editPlaylistNameField.sendKeys(playlistNewName);
        editPlaylistNameField.sendKeys(Keys.RETURN);
        return this;
    }
}