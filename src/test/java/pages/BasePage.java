package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.UUID;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

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

    public void contextClick(String playlistName) {
        By playlist = By.linkText(playlistName);
        Assert.assertNotNull(playlist, "Playlist empty.");
        findElement(playlist).click();
        actions.contextClick(findElement(playlist)).perform();
    }
}
