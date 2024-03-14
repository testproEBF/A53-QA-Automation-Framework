package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;

public class CurrentQueuePage extends BasePage{

    public CurrentQueuePage (WebDriver givenDriver){
        super (givenDriver);
    }

    private String[] songArray;
    private String[] songAttributeBeforeShuffle;
    private String[] songAttributeAfterShuffle;
    String titleLocatorFormat = "(//td[@class=\"title\"])[%s]";

    @FindBy(xpath = "//a[@class=\"queue\"]")
    private WebElement currentQueue;
    @FindBy(xpath = "//*[@data-test=\"list-meta\"]")
    private WebElement totalCountPlaytimeLocator;
    @FindBy(xpath = "//section[@id=\"queueWrapper\"]//h1")
    private WebElement currentQueueText;
    @FindBy(xpath = "//section[@id=\"queueWrapper\"]//*[@class=\"btn-shuffle-all\"]")
    private WebElement shuffleButton;
    @FindBy(xpath = "//section[@id=\"queueWrapper\"]//*[@class=\"btn-clear-queue\"]")
    private WebElement clearButton;
    @FindBy(xpath = "//section[@id=\"queueWrapper\"]//div[@class=\"text\"]")
    private WebElement emptyQueueMessageLocator;
    @FindBy(xpath = "//*[@class=\"start\"]")
    private WebElement shufflingAllSongsLocator;
    By currentQueueTextLocator = By.xpath("//section[@id=\"queueWrapper\"]//h1");


    public void goToCurrentQueuePage() {
        actions.moveToElement(currentQueue).doubleClick().perform();
    }

    public void checkPresenceOfSongs(int numberOfSongs) {
//        String locator = String.format(".song-list-wrap.main-scroll-wrap.queue tr.song-item:nth-child(%s)", numberOfSongs);
//        WebElement element = findElement(By.cssSelector(locator));
//        Assert.assertTrue(waitForElementToBeVisible(element));
        checkPresenceOfTitle(numberOfSongs);
//        for (int x = 1; x <= numberOfSongs; x++ ){
//            String locator = String.format(".song-list-wrap.main-scroll-wrap.queue tr.song-item:nth-child(%s)", x);
//            WebElement element = findElement(By.cssSelector(locator));
//            Assert.assertTrue(waitForElementToBeVisible(element));
//            findElementVisibility(element).click();
//        }
    }

    public void checkTotalNumberOfSongs(int numberOfSongs) {

        String actualNumberOfSongs = totalCountPlaytimeLocator.getText();
        String totalNumberOfSongs = String.format("%s songs", numberOfSongs);
        System.out.println(actualNumberOfSongs);
        Assert.assertTrue(actualNumberOfSongs.contains(totalNumberOfSongs));

    }

    public void checkPresenceOfTotalDurationOfSongs() {
    }

    public void checkIfNavigatedToCurrentQueuePage() {
//        Assert.assertFalse(isElementNotFound(currentQueueTextLocator));
        Assert.assertTrue(waitForElementToBeVisible(currentQueueText));
    }

    public void checkPresenceOfTrackNumber(int numberOfSong) {
        String trackNumberLocatorFormat = "(//td[@class=\"track-number text-secondary\"])[%s]";
        String songAttribute = "track number";
        checkPresenceOfSongAttribute(trackNumberLocatorFormat, songAttribute, numberOfSong);
    }

    public void checkPresenceOfTitle(int numberOfSong) {
        String titleLocatorFormat = "(//td[@class=\"title\"])[%s]";
        String songAttribute = "title";
        checkPresenceOfSongAttribute(titleLocatorFormat, songAttribute, numberOfSong);
    }

    public void checkPresenceOfArtist(int numberOfSong) {
        String artistLocatorFormat = "(//td[@class=\"artist\"])[%s]";
        String songAttribute = "artist";
        checkPresenceOfSongAttribute(artistLocatorFormat, songAttribute, numberOfSong);
    }

    public void checkPresenceOfAlbum(int numberOfSong) {
        String AlbumLocatorFormat = "(//td[@class=\"album\"])[%s]";
        String songAttribute = "album";
        checkPresenceOfSongAttribute(AlbumLocatorFormat, songAttribute, numberOfSong);
    }

    public void checkPresenceOfPlaytime(int numberOfSong) {
        String PlaytimeLocatorFormat = "(//td[@class=\"time text-secondary\"])[%s]";
        String songAttribute = "playtime";
        checkPresenceOfSongAttribute(PlaytimeLocatorFormat, songAttribute, numberOfSong);
    }

    public void getSongTitlesInOrderBeforeShuflle(int numberOfSong) {
        getSongAttributeValue(titleLocatorFormat, numberOfSong);
        songAttributeBeforeShuffle = new String[numberOfSong];
        System.arraycopy(songArray, 0, songAttributeBeforeShuffle, 0, numberOfSong);
        for (String i : songAttributeBeforeShuffle){
            System.out.println(i);
        }
    }

    public void getSongTitlesInOrderAfterShuffle(int numberOfSong) {
        getSongAttributeValue(titleLocatorFormat, numberOfSong);
        songAttributeAfterShuffle = new String[numberOfSong];
        System.arraycopy(songArray, 0, songAttributeAfterShuffle, 0, numberOfSong);
        for (String i : songAttributeAfterShuffle){
            System.out.println(i);
        }
    }

    public void clickShuffleButton() {
        findElementVisibility(shuffleButton).click();
    }

    public void checkSongsAreShuffled() {
        Assert.assertFalse(Arrays.equals(songAttributeBeforeShuffle, songAttributeAfterShuffle));
    }

    public void checkPresenceOfSongAttribute(String locatorFormat, String songAttribute, int numberOfSong){
        boolean isPresent = true;
        for(int x = 1; x <= numberOfSong; x++){
            String locator = String.format(locatorFormat,x);
            String attribute = findElement(By.xpath(locator)).getText();
            if (attribute.isEmpty()){
                System.out.println("The song's " + songAttribute + " is missing.");
                isPresent = false;
            } else {
                System.out.println("The song's " + songAttribute + " is " + attribute +".");
            }
            Assert.assertTrue(isPresent);
        }
    }

    public void getSongAttributeValue(String locatorFormat, int numberOfSong){
        songArray = new String[numberOfSong];
        for(int x = 1; x <= numberOfSong; x++){
            String locator = String.format(locatorFormat,x);
            String attributeValue = findElement(By.xpath(locator)).getText();
            int y = x - 1;
            songArray[y] = attributeValue;
        }
    }

    public void clickClearButton() {
        findElementVisibility(clearButton).click();
    }

    public void checkIfCurrentQueueListIsEmpty() {
        By clearButtonLocator = By.xpath("//section[@id=\"queueWrapper\"]//*[@class=\"btn-clear-queue\"]");
        Assert.assertTrue(isElementNotFound(clearButtonLocator), "Current Queue is not empty.");
    }

    public void getDisplayedMessage(String emptyQueueMessage) {
        String actualEmptyQueueMessage = findElementVisibility(emptyQueueMessageLocator).getText();
        String actualEmptyQueueMessageTrimmed = actualEmptyQueueMessage.replaceAll("\\s","").replaceAll("\\n","");
        String emptyQueueMessageTrimmed = emptyQueueMessage.replaceAll("\\s","").replaceAll("\\n","");
        System.out.println("Actual message is " + actualEmptyQueueMessageTrimmed);
        System.out.println("Expected message is " + emptyQueueMessageTrimmed);
        Assert.assertEquals(emptyQueueMessageTrimmed, actualEmptyQueueMessageTrimmed);
    }

    public void clickHyperlinkText(String shufflingAllSongsText) {
        shufflingAllSongsLocator.click();
    }


}
