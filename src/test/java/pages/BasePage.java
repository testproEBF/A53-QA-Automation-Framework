package pages;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    //@FindBy(css = ".fa.fa-plus-circle.create")
    @FindBy(xpath = "//*[@title=\"Create a new playlist\"]")
    private WebElement playlistPlusButton;
    @FindBy(xpath = "//*[text()=\"New Smart Playlist\"]")
    private WebElement newSmartPlaylistOption;
    @FindBy( css = "li[data-testid*=\"playlist-context-menu-delete\"]")
    private WebElement deleteOption;

    String recentAddedSmartPlaylistName;

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    //PlaylistPage playlistPage = new PlaylistPage(driver);
    public void loggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    public void clickPlusButton(){
        WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(playlistPlusButton));
        actions.moveToElement(plusButton).click().perform();
//        playlistPlusButton.click();
    }

    public void clickNewSmartPlaylist() {
        newSmartPlaylistOption.click();
    }

    public void toNewSmartPlaylistForm(){
        clickPlusButton();
        clickNewSmartPlaylist();
    }

    public String getNotification () {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        return notification.getText();
    }


    public BasePage clickSmartPlaylist(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(name))).click();
        return this;
    }

    public void checkCreatedSmartPlaylist(String name){
        Assert.assertNotNull(clickSmartPlaylist(name));
    }

    public void checkCreatedSmartPlaylistRandomName(){
        Assert.assertNotNull(clickSmartPlaylist(recentAddedSmartPlaylistName));
    }

    public void playlistCreatedNotification(){
        String actualMessage = String.format("Created playlist \"%s.\"", recentAddedSmartPlaylistName);
        Assert.assertEquals(getNotification(), actualMessage);
    }

    public void elementNotFound() {
        try{
            Assert.assertNull(clickSmartPlaylist(recentAddedSmartPlaylistName));
        } catch (TimeoutException e){
            Assert.assertEquals(driver.findElements(By.linkText(recentAddedSmartPlaylistName)).size(), 0);
        }

    }

    public String randomStrGenerator (int length){
        String ALPHABETIC_UPPERCASE_SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ALPHABETIC_LOWERCASE_SYMBOLS = "abcdefghijklmnopqrstuvwxyz";
        String NUMERIC_SYMBOLS = "0123456789";
        String SPECIAL_SYMBOLS = "~!@#$%^&*()_+-={}|:<>?[];',./'";
        String ALPHANUMERIC_AND_SPECIAL_SYMBOLS =
                ALPHABETIC_UPPERCASE_SYMBOLS +
                ALPHABETIC_LOWERCASE_SYMBOLS +
                NUMERIC_SYMBOLS +
                SPECIAL_SYMBOLS;

        List<Character> chars = new ArrayList<>(length);
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        for (int i = 0; i < length; i++) {

            if (!hasUpper) {
                chars.add(ALPHABETIC_UPPERCASE_SYMBOLS.charAt(RandomUtils.nextInt(0, ALPHABETIC_UPPERCASE_SYMBOLS.length())));
                hasUpper = true;
            } else if (!hasLower) {
                chars.add(ALPHABETIC_LOWERCASE_SYMBOLS.charAt(RandomUtils.nextInt(0, ALPHABETIC_LOWERCASE_SYMBOLS.length())));
                hasLower = true;
            } else if (!hasNumber) {
                chars.add(NUMERIC_SYMBOLS.charAt(RandomUtils.nextInt(0, NUMERIC_SYMBOLS.length())));
                hasNumber = true;
            } else if (!hasSpecial) {
                chars.add(SPECIAL_SYMBOLS.charAt(RandomUtils.nextInt(0, SPECIAL_SYMBOLS.length())));
                hasSpecial = true;
            } else {
                chars.add(ALPHANUMERIC_AND_SPECIAL_SYMBOLS.charAt(RandomUtils.nextInt(0, ALPHANUMERIC_AND_SPECIAL_SYMBOLS.length())));
            }
        }

        Collections.shuffle(chars);

        return StringUtils.join(chars, "");
    }

    public void inputRandomName(int length) {
        String name = randomStrGenerator(length);
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-row input[name='name']")));
        nameField.click();
        nameField.sendKeys(name);
        recentAddedSmartPlaylistName = name;
    }

    public int countNumberOfPlaylist(){
        return driver.findElements(By.cssSelector("a[href*=\"playlist\"]")).size();
    }

    public BasePage contextClickElement (By locator) {
        actions.contextClick(findElement(locator)).perform();
        return this;
    }

    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public BasePage clickDelete() {
        deleteOption.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid*=\"playlist-context-menu-delete\"]")));
        return this;
    }

    public void deleteAllPlaylists() {
        int x = countNumberOfPlaylist();
        System.out.println("There is/are currently " + x + " playlist/s.");

        for (int i = 0; i <= x; i++) {
            By locator = By.cssSelector("a[href*=\"playlist\"]");
            contextClickElement(locator);
            clickDelete();

        }

        int y = countNumberOfPlaylist();
        System.out.println("There is/are now " + y + " playlist/s.");
    }
}


