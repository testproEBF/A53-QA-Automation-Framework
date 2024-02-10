package pages;
import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
    @FindBy(css = ".fa.fa-plus-circle.create")
    private WebElement playlistPlusButton;
    @FindBy( css = "li[data-testid=\"playlist-context-menu-create-smart\"]")
    private WebElement newSmartPlaylistOption;
    @FindBy(css = "img.avatar")
    private WebElement avatarIcon;

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void loggedIn() {
        //Assert.assertTrue(avatarIcon.isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public BasePage clickPlusButton(){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa.fa-plus-circle.create"))).click();
        //playlistPlusButton.click();
        return this;
    }

    public BasePage clickNewSmartPlaylist() {
        newSmartPlaylistOption.click();
        return this;
    }

    public BasePage toNewSmartPlaylistForm(){
        clickPlusButton();
        clickNewSmartPlaylist();
        return this;
    }

    public String getNotification () {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        return notification.getText();
    }

    public BasePage playlistCreatedNotification(String name){
        String actualMessage = String.format("Created playlist \"%s.\"", name);
        Assert.assertEquals(getNotification(), actualMessage);
        return this;
    }

    public BasePage clickSmartPlaylist(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(name))).click();
        return this;
    }

    public BasePage checkCreatedSmartPlaylist(String name){
        Assert.assertNotNull(clickSmartPlaylist(name));
        return this;
    }


}
