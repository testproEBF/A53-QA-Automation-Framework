package pages;

import StepDefinition.BaseDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;

public class ArtistsPage extends BasePage{

    public ArtistsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    MainFooterPage mainFooterPage = new MainFooterPage(BaseDefinition.getThreadLocal());

    @FindBy (xpath = "//a[@class=\"artists\"]")
    private WebElement artists;
    By artistsLocator = By.xpath("//*[@id=\"artistsWrapper\"]//*[@class=\"item full\"]");
    @FindBy (xpath = "//*[@id=\"artistsWrapper\"]//h1")
    private WebElement artistsPageHeader;
    @FindBy (xpath = "//*[@id=\"artistsWrapper\"]//*[@class=\"item compact\"]")
    private WebElement compactArtistsThumbnail;
    @FindBy (xpath = "//*[@id=\"artistsWrapper\"]//*[@class=\"item full\"]")
    private WebElement fullArtistsThumbnail;
    @FindBy (xpath = "//*[@id=\"artistsWrapper\"]//*[@class=\"list\"]")
    private WebElement viewAsListButton;
    @FindBy (xpath = "//*[@id=\"artistsWrapper\"]//*[@class=\"thumbnails\"]")
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

    public void goToArtistsPage() {
        artists.click();
//        moveToElementClick(artists);
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

    public void displayArtistsInThumbnailView() {
//        List<WebElement> fullArtistsThumbnailList = wait.until(ExpectedConditions.visibilityOfAllElements(By.xpath("//*[@id=\\\"artistsWrapper\\\"]//*[@class=\\\"item full\\\"]\"")));
        Assert.assertTrue(fullArtistsThumbnail.isDisplayed());
    }

    public void clickArtistViewAsListButton() {
        viewAsListButton.click();
    }

    public void displayArtistsInAListView() {
        Assert.assertTrue(compactArtistsThumbnail.isDisplayed());
    }

    public void clickArtistsViewAsThumbnailsButton() {
        viewAsThumbnailButton.click();
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

    public void clickArtistsThumbnail(String artistName, String viewMode) {
        selectViewModeString(viewMode);
        String artistsThumbnailLocatorFormat = String.format("//*[@id=\"artistsWrapper\"]//*[@class=\"%s\" and @title=\"%s\"]//a[@class=\"control control-play font-size-0\"]", viewModeString, artistName);
        String firstArtistsThumbnailLocatorFormat = String.format("(//*[@id=\"artistsWrapper\"]//*[@class=\"%s\"]//a[@class=\"control control-play font-size-0\"])[1]", viewModeString);
        try {
            WebElement artistThumbnail = driver.findElement(By.xpath(artistsThumbnailLocatorFormat));
            actions.moveToElement(artistThumbnail).perform();
            actions.click(artistThumbnail).perform();
        } catch (Exception e) {
            WebElement firstArtistThumbnail = driver.findElement(By.xpath(firstArtistsThumbnailLocatorFormat));
            firstArtistThumbnail.sendKeys(Keys.DOWN);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            WebElement artistThumbnail = driver.findElement(By.xpath(artistsThumbnailLocatorFormat));
            actions.moveToElement(artistThumbnail).perform();
            actions.click(artistThumbnail).perform();
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


    public void checkArtistSSongSAutomaticallyPlay() {
//        Assert.assertNull(mainFooterPage.soundBar);
        Assert.assertTrue(mainFooterPage.soundBar.isDisplayed());
    }

    public void clickArtistSName(String viewMode){
        selectViewModeString(viewMode);
        System.out.println("Artists page is in " + viewMode);
        selectArtist(viewModeString);
        clickArtist();
    }

    private void selectArtist(String viewModeString){

        //Solution # 1 ~ still 18 Artists
//        WebElement allArtistInThumbnail = driver.findElement(By.xpath("//*[@id=\"artistsWrapper\"]//*[@class=\"artists main-scroll-wrap as-thumbnails\"]"));
//        List<WebElement> allArtistInThumbnailList = allArtistInThumbnail.findElements(By.xpath("./article"));
//        int numberOfArtists = allArtistInThumbnailList.size();
//        System.out.println(numberOfArtists);

        //Solution # 2 ~ still 18 Artists
//        By allArtistInThumbnail = By.xpath("(//*[@id=\"artistsWrapper\"]//div/a)");

        //Solution # 2 ~ still 18 Artists
//        By allArtistInThumbnail = By.cssSelector("#artistsWrapper div .name");

        //Solution # 2 ~ still 18 Artists
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        String allArtistInThumbnailLocatorFormat = String.format("//*[@id=\"artistsWrapper\"]//*[@class=\"%s\"]", viewModeString);
        By allArtistInThumbnail = By.xpath(allArtistInThumbnailLocatorFormat);

//        Solution # 5 ~ still 18 Artists
//        Thread.sleep(10000);

//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allArtistInThumbnail));
//        final int numberOfArtists = getSize(allArtistInThumbnail);

        int randomArtistNumber =  getRandomNumber( 1, numberOfArtists);
        String artistNameInThumbnailLocatorFormat = String.format("(//*[@id=\"artistsWrapper\"]//div/a)[%s]", randomArtistNumber);
        selectedArtist = findElement(By.xpath(artistNameInThumbnailLocatorFormat));
        selectedArtistName = selectedArtist.getText();
        System.out.println("The total number of artists is " + numberOfArtists);
        System.out.println("The selected artist is " + selectedArtistName);
    }

    private void clickArtist(){
        selectedArtist.click();
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
        selectedArtistSSong = findElement(By.xpath(artistSSongLocatorFormat));
        selectedArtistSSongName = selectedArtistSSong.getText();

        System.out.println("The total number of songs of " + selectedArtistName + " is " + numberOfArtistSSongs);
        System.out.println("The random number selected is " + randomArtistSongNumber);
        System.out.println("The selected song of " + selectedArtistName + " is " + selectedArtistSSongName);
    }

    private void playSong(){
        Assert.assertNotNull(selectedArtistSSong);
        actions.doubleClick(selectedArtistSSong).perform();
        Assert.assertTrue(mainFooterPage.soundBar.isDisplayed());
    }

}
