package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;

public class ArtistsPage extends BasePage{

    public ArtistsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (xpath = "//a[@class=\"artists\"]")
    private WebElement artists;
    By artistsLocator = By.xpath("//*[@id=\"artistsWrapper\"]//*[@class=\"item full\"]");
    @FindBy (xpath = "//*[@id=\"artistsWrapper\"]//h1")
    private WebElement artistsPageHeader;
    @FindBy (xpath = "//*[@id=\"artistsWrapper\"]//*[@class=\"item compact\"]")
    private WebElement compactArtistsThumbnail;
    @FindBy (xpath = "//*[@id=\"artistsWrapper\"]//*[@class=\"item full\"]")
    private WebElement fullArtistsThumbnail;
    @FindBy (xpath = "//*[@id=\"artistsWrapper\"]//*[@title=\"View as list\"]")
    private WebElement viewAsListButton;
    @FindBy (xpath = "//*[@id=\"artistsWrapper\"]//*[@title=\"View as thumbnails\"]")
    private WebElement viewAsThumbnailButton;
    @FindBy (xpath = "//*[@id=\"artistWrapper\"]//h1")
    private WebElement selectedArtistsPageName;

    String selectedArtistName;
    WebElement selectedArtist;

    String selectedArtistSSongName;
    WebElement selectedArtistSSong;

    private static final String viewThumbnail = "item full";
    private static final String viewList = "item compact";
    String viewModeString;
    By allArtistNameLink;
    private int numberOfArtists;

    public void goToArtistsPage() {
        moveToElementClick(artists);
        Assert.assertNotNull(viewAsListButton);
        Assert.assertNotNull(viewAsThumbnailButton);
    }

    public void playArtists(int numberOfPlayedArtists) {
        String artistsLocatorFormat = "(//*[@id=\"artistsWrapper\"]//*[@class=\"item full\"])[%s]";
        String message = "The total number of artists in Artists Page is ";
        playSong(numberOfPlayedArtists, message, artistsLocatorFormat, artistsLocator);
    }

    public void displayArtistsPage() {
        findElementVisibility(artistsPageHeader);
        Assert.assertEquals(artistsPageHeader.getText(), "Artists");
    }

    public void checkArtistsDisplayedInThumbnailView() {
        Assert.assertTrue(fullArtistsThumbnail.isDisplayed());
    }

    public void clickArtistViewAsListButton() {
        moveToElementClick(viewAsListButton);
    }

    public void checkArtistsDisplayedInListView() {
        Assert.assertTrue(compactArtistsThumbnail.isDisplayed());
    }

    public void clickArtistViewAsThumbnailsButton() {
        moveToElementClick(viewAsThumbnailButton);
    }

    private String selectViewModeString (String viewMode){
        if (viewMode.equals("Thumbnail")) {
            viewModeString = viewThumbnail;
        }
        else{
            viewModeString = viewList;
        }
        return viewModeString;
    }

    public void clickArtistSThumbnail(String artistName, String viewMode) throws InterruptedException {
        selectViewModeString(viewMode);
        String artistsThumbnailLocatorFormat = String.format(
            "//*[@id=\"artistsWrapper\"]//*[@class=\"%s\" and @title=\"%s\"]//a[@class=\"control control-play font-size-0\"]", viewModeString, artistName);
        try {
            WebElement artistThumbnail = driver.findElement(By.xpath(artistsThumbnailLocatorFormat));
            moveToElementClick(artistThumbnail);
        } catch (Exception e) {

            //Problem: Cannot find the element not in view. Returns TimeoutException

            //Solution 1: Changed Xpath to Css selector: Nothing changed in results
//            artistsThumbnailLocatorFormat = String.format(
//              "#artistsWrapper article[class|=\"%s\"][title|=%s] .control.control-play.font-size-0", viewModeString, artistName);

            //Solution 2: Used Thread.sleep: Nothing changed in results
            //Thread.sleep(100000);

            //Solution 3: Use javascript scrollAndClick:Nothing changed in results
            //In conjunction with scrollPageDown: Inconsistent results. Returns MoveTargetOutOfBoundsException
//            scrollAndClickJS(artistThumbnail);

            //Solution 4: Scroll to the bottom of the page first so that all artist will be visible in DOM: SUCCESS! All artists are found.
            int numberOfTimesToScrollDown = 10;
            clickFirstArtist(viewModeString);
            scrollPageDown(numberOfTimesToScrollDown);

            WebElement artistThumbnail = findElementVisibility(By.xpath(artistsThumbnailLocatorFormat));
            moveToElementClick(artistThumbnail);
        }
    }

    private void clickFirstArtist(String viewModeString){
        String firstArtistsThumbnailLocatorFormat = String.format("(//*[@id=\"artistsWrapper\"]//*[@class=\"%s\"])[1]", viewModeString);
        WebElement firstArtistThumbnail = driver.findElement(By.xpath(firstArtistsThumbnailLocatorFormat));
        firstArtistThumbnail.sendKeys(Keys.DOWN);
    }

    private void scrollPageDown(int numberOfTimesToScrollDown) throws InterruptedException {
        for (int x = 0; x <= numberOfTimesToScrollDown; x++){
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            //Has to be added to make sure the UI can keep up with the scrolling command sent by Selenium.
            //The 50 millis is the optimum time to give consistent correct total number of artists.
            Thread.sleep(50);
        }
    }

    public void checkArtistSSongsAreAddedToCurrentQueue(String artistName) {
        String currentQueueSongsArtistSName;
//        By currentQueueSongsArtistsLocator = By.xpath("//*[@id=\"queueWrapper\"]//td[@class=\"artist\"]");
        List<WebElement> currentQueueSongsArtists = driver.findElements(By.xpath("//*[@id=\"queueWrapper\"]//td[@class=\"artist\"]"));
        for (WebElement currentQueueSongsArtist : currentQueueSongsArtists) {
            currentQueueSongsArtistSName = currentQueueSongsArtist.getText();
            System.out.println(currentQueueSongsArtistSName);
            Assert.assertEquals(currentQueueSongsArtistSName, artistName);
        }
    }

    public void clickArtistSName(String viewMode) throws InterruptedException{
        selectViewModeString(viewMode);
        System.out.println("Artists page is in " + viewMode);
        getTotalNumberOfArtists(viewModeString);
        selectArtist();
        clickSelectedArtist();
    }

    private void getTotalNumberOfArtists(String viewModeString) throws InterruptedException {

        //Solution 1: Used different xpath selector: Only 9 Artists are found
//        allArtistNameLink = By.xpath("(//*[@id=\"artistsWrapper\"]//div/a)");

        //Solution 2: Use css selector: Still 9 Artists
//        allArtistNameLink = By.cssSelector("#artistsWrapper div .name");

        //Solution 3: Scroll to the bottom using JS (Did not scroll to the bottom): Still 9 Artists
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        //Solution 4: Scroll to the bottom of the page first so that all artist will be visible in DOM
        //SUCCESS! Correct total number of artists are found.
        int numberOfTimesToScrollDown = 10;
        clickFirstArtist(viewModeString);
        scrollPageDown(numberOfTimesToScrollDown);

        String allArtistNameLinkLocatorFormat = String.format("//*[@id=\"artistsWrapper\"]//*[@class=\"%s\"]", viewModeString);
        allArtistNameLink = By.xpath(allArtistNameLinkLocatorFormat);

        //Solution 5: Used Thread.sleep: Inconsistent results. Can find up to 18 artists only
//        Thread.sleep(10000);

        numberOfArtists = getSize(allArtistNameLink);

        //Solution 6: Use List<WebElements>: Only 9 artists are found
//        numberOfArtists = getElements(allArtistNameLinkLocatorFormat).size();
    }

    private void selectArtist(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allArtistNameLink));
        int randomArtistNumber =  getRandomNumber( 1, numberOfArtists);
        String selectedArtistNameLinkLocatorFormat = String.format("(//*[@id=\"artistsWrapper\"]//div/a)[%s]", randomArtistNumber);
        selectedArtist = findElementVisibility(By.xpath(selectedArtistNameLinkLocatorFormat));
        selectedArtistName = selectedArtist.getText();
        System.out.println("The total number of artists is " + numberOfArtists);
        System.out.println("The selected artist is " + selectedArtistName);
    }

    private void clickSelectedArtist(){
        moveToElementClick(selectedArtist);
//        selectedArtist.click();
    }

    public void navigatedToArtistSPage() {
        Assert.assertEquals(selectedArtistsPageName.getText(), selectedArtistName);
    }

    public void playArtistSSongs(){
        selectSong();
        playSong();
    }

    private void selectSong(){
        By allArtistSSongs = By.xpath("//*[@id=\"artistWrapper\"]//*[@class=\"song-item\"]/*[@class=\"title\"]");
        int numberOfArtistSSongs = getSize(allArtistSSongs);
        int randomArtistSongNumber =  getRandomNumber( 1, numberOfArtistSSongs);
        String artistSSongLocatorFormat = String.format("(//*[@id=\"artistWrapper\"]//*[@class=\"song-item\"]/*[@class=\"title\"])[%s]", randomArtistSongNumber);
        selectedArtistSSong = findElementVisibility(By.xpath(artistSSongLocatorFormat));
        selectedArtistSSongName = selectedArtistSSong.getText();

        System.out.println("The total number of songs of " + selectedArtistName + " is " + numberOfArtistSSongs);
        System.out.println("The random number selected is " + randomArtistSongNumber);
        System.out.println("The selected song of " + selectedArtistName + " is " + selectedArtistSSongName);
    }

    private void playSong(){
        actions.doubleClick(selectedArtistSSong).perform();
    }

}
