package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.lang.model.element.Element;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class CurrentQueuePage extends BasePage{

    public CurrentQueuePage (WebDriver givenDriver){
        super (givenDriver);
    }

    private String[] songArray;
    private String[] songAttributeBeforeShuffle;
    private String[] songAttributeAfterShuffle;
    private static final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("mm:ss", Locale.ENGLISH);
    private static final String TITLE_LOCATOR_FORMAT = "(//td[@class=\"title\"])[%s]";
    private static final String trackNumberLocatorFormat = "(//td[@class=\"track-number text-secondary\"])[%s]";


    @FindBy(xpath = "//a[@class=\"queue\"]")
    private WebElement currentQueue;
    @FindBy(xpath = "//*[@data-test=\"list-meta\"]")
    private WebElement currentQueueTotalCountPlaytimeText;
    @FindBy(xpath = "//section[@id=\"queueWrapper\"]//h1[@data-v-223745fc=\"\"]")
    private WebElement currentQueueText;
    @FindBy(xpath = "//section[@id=\"queueWrapper\"]//*[@class=\"btn-shuffle-all\"]")
    private WebElement shuffleButton;
    @FindBy(xpath = "//section[@id=\"queueWrapper\"]//*[@class=\"btn-clear-queue\"]")
    private WebElement clearButton;
    @FindBy(xpath = "//section[@id=\"queueWrapper\"]//div[@class=\"text\"]")
    private WebElement emptyQueueMessageLocator;
    @FindBy(xpath = "//*[@class=\"start\"]")
    private WebElement shufflingAllSongsLocator;


    public void goToCurrentQueuePage() {
        moveToElementClick(currentQueue);
    }

    public void checkPresenceOfSongs(int numberOfSongs) {
        checkPresenceOfTitle(numberOfSongs);
    }

    public void checkTotalNumberOfSongs(int numberOfSong) {
        String actualNumberOfSongs = currentQueueTotalCountPlaytimeText.getText();
        String expectedNumberOfSongs = String.format("%s songs", numberOfSong);
        System.out.println("The number of songs in Current QueuePage  is " + actualNumberOfSongs + ".");
        Assert.assertTrue(actualNumberOfSongs.contains(expectedNumberOfSongs));
    }

    public void checkTotalNumberOfSongsUnderCurrentQueueText(String expectedNumberOfSongs) {
        String actualNumberOfSongs = currentQueueTotalCountPlaytimeText.getText();
        System.out.println("The number of songs in Current QueuePage  is " + actualNumberOfSongs + ".");
        Assert.assertTrue(actualNumberOfSongs.contains(expectedNumberOfSongs));
    }

    public void checkPresenceOfTotalLengthOfSongs(int numberOfSongs) throws ParseException {
        String songAttribute = "duration";
        final String songLengthLocatorFormat = "(//td[@class=\"time text-secondary\"])[%s]";
        getSongAttributeValue(songLengthLocatorFormat, songAttribute, numberOfSongs);

        String actualTotalSongDuration = currentQueueTotalCountPlaytimeText.getText();
        String expectedTotalSongDuration = "00:00";
        for(int i = 1; i <=numberOfSongs; i++){
            String x = songArray[i-1];
            expectedTotalSongDuration = addMinutes(expectedTotalSongDuration, x);
        }
        System.out.println("The expected total length of the played songs is " + expectedTotalSongDuration + ".");
        System.out.println("The actual total length of the played songs is " + actualTotalSongDuration + ".");
        Assert.assertTrue(actualTotalSongDuration.contains(expectedTotalSongDuration));
    }

    public void checkIfNavigatedToCurrentQueuePage() {
        Assert.assertTrue(waitForElementToBeVisible(currentQueueText));
        System.out.println("The text " + currentQueueText.getText() + " is visible. I am navigated to the Current Queue Page.");
    }

    public void checkPresenceOfTrackNumber(int numberOfSong) {
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
        String songAttribute = "length";
        checkPresenceOfSongAttribute(PlaytimeLocatorFormat, songAttribute, numberOfSong);
    }

    public void getSongTitlesInOrderBeforeShuflle(int numberOfSong) {
        String songAttribute = "title";
        getSongAttributeValue(TITLE_LOCATOR_FORMAT, songAttribute, numberOfSong);
        songAttributeBeforeShuffle = new String[numberOfSong];
        System.arraycopy(songArray, 0, songAttributeBeforeShuffle, 0, numberOfSong);
    }

    public void getSongTitlesInOrderAfterShuffle(int numberOfSong) {
        String songAttribute = "title";
        getSongAttributeValue(TITLE_LOCATOR_FORMAT, songAttribute, numberOfSong);
        songAttributeAfterShuffle = new String[numberOfSong];
        System.arraycopy(songArray, 0, songAttributeAfterShuffle, 0, numberOfSong);
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

    public void getSongAttributeValue(String locatorFormat, String songAttribute,int numberOfSong){
        songArray = new String[numberOfSong];
        for(int x = 1; x <= numberOfSong; x++){
            String locator = String.format(locatorFormat,x);
            String attributeValue = findElement(By.xpath(locator)).getText();
            int y = x - 1;
            songArray[y] = attributeValue;
            System.out.println( "The " + songAttribute + " of song " + x + " is " + songArray[y]);
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

    public void clickHyperlinkText() {
        shufflingAllSongsLocator.click();
    }

    private String addMinutes(String timeString1, String timeString2) throws ParseException {
        Date time1 = TIME_FORMATTER.parse(timeString1);
        Date time2 = TIME_FORMATTER.parse(timeString2);

        Date referenceTime = TIME_FORMATTER.parse("00:00");
        long sum = (time1.getTime() - referenceTime.getTime()) + (time2.getTime() - referenceTime.getTime());
        String totalTime = TIME_FORMATTER.format(new Date(sum));
//        System.out.println("Time1 + Time2: " + totalTime);
        return totalTime;
    }

}
