package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.UUID;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    @FindBy (css = ".success.show")
    private WebElement actualNotificationText;
    @FindBy(css = "[title=\"Create a new playlist\"]")
    private WebElement playlistPlusButton;
    @FindBy(css = "[data-testid=\"playlist-context-menu-create-simple\"]")
    private WebElement newPlaylistList;
    @FindBy(css = "#playlists [type=\"text\"]")
    private WebElement playlistNameField;

    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);

    }

    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Boolean findNullElement(By locator){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public int countNumberOfPlaylist() {
        return driver.findElements(By.cssSelector("a[href*=\"playlist\"]")).size();
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public String getNotification () {
        return actualNotificationText.getText();
    }

    public BasePage contextClickElement (By locator) {
        actions.contextClick(findElement(locator)).perform();
        return this;
    }

    public BasePage waitForInvisibility(String message){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(message)));
        return this;
    }


    public BasePage clickPlusButton(){
        playlistPlusButton.click();
        return this;
    }

    public BasePage clickNewPlaylist() {
        newPlaylistList.click();
        return this;
    }

    public BasePage enterPlaylistName (String newPlaylistName){
        playlistNameField.click();
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.RETURN);
        return this;
    }
}
