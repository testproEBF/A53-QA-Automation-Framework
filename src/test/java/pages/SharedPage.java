package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SharedPage extends BasePage {
    public SharedPage (WebDriver givenDriver){
        super (givenDriver);
    }

    @FindBy(css = "[title=\"Create a new playlist\"]")
    WebElement playlistPlusButton;
    @FindBy(css = "[data-testid=\"playlist-context-menu-create-simple\"]")
    WebElement newPlaylistList;
    @FindBy(css = "#playlists [type=\"text\"]")
    WebElement playlistNameField;


    public SharedPage clickPlusButton(){
        playlistPlusButton.click();
        return this;
    }

    public SharedPage clickNewPlaylist() {
        newPlaylistList.click();
        return this;
    }

    public SharedPage enterPlaylistName (String newPlaylistName){
        playlistNameField.click();
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.RETURN);
        return this;
    }

}

