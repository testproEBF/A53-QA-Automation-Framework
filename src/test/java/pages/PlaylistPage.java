package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PlaylistPage extends BasePage {
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private final By editOption = By.cssSelector("li[data-testid*=\"playlist-context-menu-edit\"]");
    private final By editPlaylistNameField = By.cssSelector("[name=\"name\"]");


    public void clickEdit() {
        findElement(editOption).click();
    }

    public void enterPlaylistNewName(String playlistNewName) {
        findElement(editPlaylistNameField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElement(editPlaylistNameField).sendKeys(playlistNewName);
        findElement(editPlaylistNameField).sendKeys(Keys.RETURN);
    }

}