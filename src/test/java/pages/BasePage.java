package pages;
import StepDefinition.BaseDefinition;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.*;


public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @FindBy(xpath = "//img[@class=\"avatar\"]")
    protected WebElement avatarIcon;
    @FindBy(xpath = "//div[@class=\"success show\"]")
    protected WebElement notification;
    protected By notificationLocator = By.partialLinkText("Created playlist");
    @FindBy(xpath = "//div[@class=\"error show\"]")
    protected WebElement errorNotification;
    @FindBy(xpath = "//*[@title=\"Create a new playlist\"]")
    private WebElement playlistPlusButton;
    @FindBy(xpath = "//*[text()=\"New Smart Playlist\"]")
    private WebElement newSmartPlaylistOption;
    @FindBy( css = "li[data-testid*=\"playlist-context-menu-delete\"]")
    private WebElement deleteOption;
    @FindBy(xpath = "//i[@class=\"fa fa-sign-out\"]")
    private WebElement logoutButton;

    String recentAddedSmartPlaylistName;
    String playlistName;

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement findElementVisibility (WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement findElementClickable (WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElementWithJavaScript(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected Boolean waitForElementToBeVisible(WebElement element){
        boolean isElementVisible = false;
        try{
            findElementVisibility(element);
            isElementVisible = true;
        } catch (TimeoutException e) {
            System.out.println("Web element is not found.");
            e.printStackTrace();
        }
        return isElementVisible;
    }

    protected Boolean fluentWaitForElement(WebElement webElement) {
        boolean isElementVisible = false;
        try {
            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(webElement));
            isElementVisible = true;
        } catch (TimeoutException e){
            System.out.println("Web element is not found.");
            e.printStackTrace();
        }
        return isElementVisible;

    }


    public int getRandomNumber (int min, int max) {
        int randomNumbers;
        randomNumbers = (int) ((Math.random() * (max - min)) + min);
        return randomNumbers;
    }

    public void moveToElementClick(WebElement element){
        actions.moveToElement(findElementClickable(element)).click().perform();
    }

    public void moveToElementDoubleClick(WebElement element){
        actions.moveToElement(findElementClickable(element)).doubleClick().perform();
    }
//
//    public WebElement waitForInvisibility (WebElement element){
//        return wait.until(ExpectedConditions.invisibilityOf(element))
//    }

    public void loggedIn() {
            Assert.assertTrue(waitForElementToBeVisible(avatarIcon));
    }

    public void clickPlusButton(){
        moveToElementClick(playlistPlusButton);
    }

    public void clickNewSmartPlaylist() {
        newSmartPlaylistOption.click();
    }

    public void toNewSmartPlaylistForm(){
        clickPlusButton();
        clickNewSmartPlaylist();
    }

    public String getNotification () {
        return findElementVisibility(notification).getText();
    }

    public String getErrorNotification(){
        return findElementVisibility(errorNotification).getText();
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

    public void playlistNotFound() {
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

    public void contextClickElement (By locator) {
        actions.contextClick(findElement(locator)).perform();
    }

    public void clickDelete() {
        deleteOption.click();
    }

    public void deleteAllPlaylists() {
        By locator = By.cssSelector("a[href*=\"playlist\"]");
        int x = getSize(locator);
        System.out.println("There is/are currently " + x + " playlist/s.");

        for (int i = 0; i < x; i++) {
            contextClickElement(locator);
            clickDelete();
        }

        int y = getSize(locator);
        System.out.println("There is/are now " + y + " playlist/s.");
        wait.until(ExpectedConditions.invisibilityOf(notification));
    }

    public void clickLogoutButton() {
//        findElementVisibility(logoutButton).click();
        clickElementWithJavaScript(logoutButton);
    }

    public int getSize(By locator){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return driver.findElements(locator).size();
    }

    public int getPopulationSize (By locator, String messageToPrint){
//        int attribute = driver.findElements(By.xpath(locator)).size();
        int attribute = getSize(locator);
        System.out.println(messageToPrint + attribute);
        return attribute;
    }

    public Boolean isElementNotFound(By locator) {
        boolean isNotFound = false;
        try{
//            Assert.assertEquals(driver.findElements(By.xpath(locator)).size(), 0);
            Assert.assertEquals(driver.findElements(locator).size(), 0);
            isNotFound = true;
        } catch (TimeoutException e) {
            System.out.println("Web element is found.");
            e.printStackTrace();
        }
        return isNotFound;
    }

    public void playSong(int numberOfPlayedItems, String message, String locatorFormat, By itemLocator) {

        String FirstItemLocator = String.format(locatorFormat, 1);
        WebElement firstItem = findElement(By.xpath(FirstItemLocator));
        findElementVisibility(firstItem);

        int y = getPopulationSize(itemLocator, message);
        for (int x = 1; x <= numberOfPlayedItems; x++ ){
            int itemNumber = getRandomNumber(1, y);

            String locator = String.format(locatorFormat, itemNumber);
            WebElement item = findElement(By.xpath(locator));
            moveToElementDoubleClick(item);
        }
    }

    public void selectPlaylist (String message, String locatorFormat, By itemLocator) {
        String firstPlaylistLocator = String.format(locatorFormat, 1);
        WebElement firstPlaylist = findElement(By.xpath(firstPlaylistLocator));
        findElementVisibility(firstPlaylist);

        int y = getPopulationSize(itemLocator, message);
        int itemNumber = getRandomNumber(1, y);
        String locator = String.format(locatorFormat, itemNumber);
        WebElement playlist = findElement(By.xpath(locator));
        moveToElementClick(playlist);
        String nameLocator = (locator + "/*[@data-v-e75e0fde=\"\"]");
        playlistName = findElement(By.xpath(nameLocator)).getText();
        System.out.println("The selected playlist is " + playlistName + ".");

    }

    public void goToProfileAndPreferencesPage() {
        clickElementWithJavaScript(avatarIcon);
//        findElementVisibility(avatarIcon).click();
    }
}


