import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {

    public WebDriver driver;
    public String url = "";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void launchBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        url = BaseURL;
        navigateToUrl();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void provideEmail (String email){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword (String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    void clickSubmit(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }

    public void navigateToUrl(){
        driver.get(url);
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void createNewPlaylist(String newPlaylistName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement newPlaylistList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid=\"playlist-context-menu-create-simple\"]")));
        newPlaylistList.click();

        WebElement playlistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists [type=\"text\"]")));
        playlistNameField.click();
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.RETURN);
    }

    public void selectPlaylist(String newPlaylistName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(newPlaylistName)));
        playlist.click();
    }

    public void clickPlusButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playlistPlusButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title=\"Create a new playlist\"]")));
        playlistPlusButton.click();
    }

    public String getNotification (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actualNotificationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        return actualNotificationText.getText();
    }
}