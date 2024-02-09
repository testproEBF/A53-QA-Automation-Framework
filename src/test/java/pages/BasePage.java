package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.UUID;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".success.show")
    private WebElement actualNotificationText;
    @FindBy(css = "[title=\"Create a new playlist\"]")
    private WebElement playlistPlusButton;
    @FindBy(css = "[data-testid=\"playlist-context-menu-create-simple\"]")
    private WebElement newPlaylistList;
    @FindBy(css = "#playlists [type=\"text\"]")
    private WebElement playlistNameField;

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void loggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa.fa-sign-out"))).click();
    }

    public void pressEnter() {
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.RETURN).keyUp(Keys.RETURN).build().perform();
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void clickPlusButton(){
        playlistPlusButton.click();
    }

    public void clickNewPlaylist() {
        newPlaylistList.click();
    }

    public String getNewPlaylistName(){
        String newPlaylistName = generateRandomName();
        return newPlaylistName;
    }

    public void enterPlaylistName (String newPlaylistName){
        playlistNameField.click();
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.RETURN);
    }

    public String getNotification () {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        return element.getText();
    }

}
