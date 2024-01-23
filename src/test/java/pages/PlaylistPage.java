package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PlaylistPage extends BasePage {
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy( css = "li[data-testid*=\"playlist-context-menu-edit\"]")
    private WebElement editOption;
    @FindBy(css = "[name=\"name\"]")
    private WebElement editPlaylistNameField;


    public PlaylistPage clickEdit() {
        Assert.assertNotNull(editOption, "`editOption` not found.");
        editOption.click();
        return this;
    }

    public PlaylistPage deletePlaylistName () throws InterruptedException {
        Assert.assertNotNull(editPlaylistNameField, "`editPlaylistNameField` not found.");
        editPlaylistNameField.sendKeys(Keys.chord(Keys.COMMAND, "A"));
        editPlaylistNameField.sendKeys(Keys.DELETE);
        return this;
    }

    public PlaylistPage enterNewPlaylistName (String playlistNewName){
        Assert.assertNotNull(editPlaylistNameField, "`editPlaylistNameField` not found.");
        Assert.assertNotNull(playlistNewName, "`playlistNewName` not found.");
        editPlaylistNameField.sendKeys(playlistNewName);
        editPlaylistNameField.sendKeys(Keys.RETURN);
        return this;
    }

}