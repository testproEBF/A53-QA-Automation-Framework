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
    private String[] songTitlesBeforeShuffle;
    private String[] songTitlesAfterShuffle;

    String titleLocatorFormat = "(//td[@class=\"title\"])[%s]";
    String titleSongAttribute = "title";
    @FindBy(xpath = "//a[@class=\"queue\"]")
    private WebElement currentQueue;
    @FindBy(xpath = "//section[@id=\"queueWrapper\"]//h1")
    private WebElement currentQueueText;
    @FindBy(xpath = "//section[@id=\"queueWrapper\"]//*[@class=\"btn-shuffle-all\"]")
    private WebElement shuffleButton;
    @FindBy(xpath = "//section[@id=\"queueWrapper\"]//*[@class=\"btn-clear-queue\"]")
    private WebElement clearButton;


    public void goToCurrentQueuePage() {
        actions.moveToElement(currentQueue).doubleClick().perform();
    }

    public void checkPresenceOfSongs(int numberOfSongs) {
        String locator = String.format(".song-list-wrap.main-scroll-wrap.queue tr.song-item:nth-child(%s)", numberOfSongs);
        WebElement element = findElement(By.cssSelector(locator));
        Assert.assertTrue(waitForElementToBeVisible(element));

//        for (int x = 1; x <= numberOfSongs; x++ ){
//            String locator = String.format(".song-list-wrap.main-scroll-wrap.queue tr.song-item:nth-child(%s)", x);
//            WebElement element = findElement(By.cssSelector(locator));
//            Assert.assertTrue(waitForElementToBeVisible(element));
//            findElementVisibility(element).click();
//        }
    }

    public void checkTotalNumberOfSongs(int numberOfSongs) {
        String locator = String.format("%s songs", numberOfSongs);
        WebElement element = findElement(By.linkText(locator));
        Assert.assertTrue(waitForElementToBeVisible(element));
    }

    public void checkIfNavigatedToCurrentQueuePage() {
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
        getSongAttributeValue(titleLocatorFormat, titleSongAttribute, numberOfSong);
        songTitlesBeforeShuffle = new String[numberOfSong];
        for (int x = 0; x < numberOfSong; x++) {
            songTitlesBeforeShuffle[x] = songArray[x];
        }
    }

    public void getSongTitlesInOrderAfterShuffle(int numberOfSong) {
        getSongAttributeValue(titleLocatorFormat, titleSongAttribute, numberOfSong);
        songTitlesAfterShuffle = new String[numberOfSong];
        for (int x = 0; x < numberOfSong; x++) {
            songTitlesAfterShuffle[x] = songArray[x];
        }
    }

    public void clickShuffleButton() {
        findElementVisibility(shuffleButton).click();
    }

    public void checkSongsAreShuffled() {
        Assert.assertFalse(Arrays.equals(songTitlesBeforeShuffle,songTitlesAfterShuffle));
    }

    public Boolean checkPresenceOfSongAttribute(String locatorFormat, String songAttribute, int numberOfSong){
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
        return isPresent;
    }

    public void getSongAttributeValue(String locatorFormat, String songAttribute, int numberOfSong){
        songArray = new String[numberOfSong];
        for(int x = 1; x <= numberOfSong; x++){
            String locator = String.format(locatorFormat,x);
            String attributeValue = findElement(By.xpath(locator)).getText();
            int y = x - 1;
            songArray[y] = attributeValue;
        }
    }

    public String getSongTitle(int songNumber) {
        String locator = String.format("(//td[@class=\"title\"])[%s]", songNumber);
        return findElement(By.xpath(locator)).getText();
    }

    public void clickClearButton() {
        findElementVisibility(clearButton).click();
    }

    public void checkIfCurrentQueueListIsEmpty() {
        int numberOfSong = 1;
        Assert.assertFalse(checkPresenceOfSongAttribute(titleLocatorFormat, titleSongAttribute, numberOfSong));
    }
}
