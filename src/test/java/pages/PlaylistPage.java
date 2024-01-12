package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PlaylistPage extends BasePage {
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By editOption = By.cssSelector("li[data-testid*=\"playlist-context-menu-edit\"]");
    By editPlaylistNameField = By.cssSelector("[name=\"name\"]");


    public void clickEdit(String playlistNewName) {
        findElement(editOption).click();
        findElement(editPlaylistNameField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElement(editPlaylistNameField).sendKeys(playlistNewName);
        findElement(editPlaylistNameField).sendKeys(Keys.RETURN);
    }

}