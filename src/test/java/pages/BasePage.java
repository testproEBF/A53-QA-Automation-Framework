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
    @FindBy(css = ".fa.fa-plus-circle.create")
    private WebElement playlistPlusButton;

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void loggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void clickPlusButton(){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']"))).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa.fa-plus-circle.create"))).click();
        playlistPlusButton.click();
    }

    public String getNotification () {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        return element.getText();
    }

}
