package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.UUID;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    private final By playlistPlusButton = By.cssSelector("[title=\"Create a new playlist\"]");
    private final By newPlaylistList = By.cssSelector("[data-testid=\"playlist-context-menu-create-simple\"]");
    private final By playlistNameField = By.cssSelector("#playlists [type=\"text\"]");

    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public String getNotification () {
        By actualNotificationText = By.cssSelector(".success.show");
        return findElement(actualNotificationText).getText();
    }

    public void waitForInvisibility(String message){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(message)));
    }

    public void contextClickElement (By locator) {
        actions.contextClick(findElement(locator)).perform();
    }


    public void clickPlusButton(){
        findElement(playlistPlusButton).click();
    }

    public void clickNewPlaylist(String newPlaylistName){
        findElement(newPlaylistList).click();
        findElement(playlistNameField).click();
        findElement(playlistNameField).sendKeys(newPlaylistName);
        findElement(playlistNameField).sendKeys(Keys.RETURN);
    }
}
