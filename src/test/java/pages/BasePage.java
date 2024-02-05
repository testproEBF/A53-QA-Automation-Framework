package pages;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.UUID;

import static java.sql.DriverManager.getDriver;

public class BasePage {
    static WebDriver driver;
    static WebDriverWait wait;

    @FindBy(css = ".success.show")
    private WebElement actualNotificationText;
    @FindBy(css = "[title=\"Create a new playlist\"]")
    private static WebElement playlistPlusButton;
    @FindBy(css = "[data-testid=\"playlist-context-menu-create-simple\"]")
    private static WebElement newPlaylistList;
    @FindBy(css = "#playlists [type=\"text\"]")
    private static WebElement playlistNameField;

    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void loggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    public static void clickLogoutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa.fa-sign-out"))).click();
    }

    public static void pressEnter() {
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.RETURN).keyUp(Keys.RETURN).build().perform();
    }

    public static String generateRandomName(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void clickPlusButton(){
        playlistPlusButton.click();
    }

    public static void clickNewPlaylist() {
        newPlaylistList.click();
    }

    public String getNewPlaylistName(){
        String newPlaylistName = BasePage.generateRandomName();
        return newPlaylistName;
    }

    public static void enterPlaylistName (String newPlaylistName){
        playlistNameField.click();
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.RETURN);
    }

    public static String getNotification () {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        return element.getText();
    }
}
