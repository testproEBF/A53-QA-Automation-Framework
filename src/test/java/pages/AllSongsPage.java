package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage{

    public AllSongsPage(WebDriver givenDriver){
        super (givenDriver);
    }



    @FindBy (xpath = "//a[@class=\"songs\"]")
    private WebElement allSongs;
    @FindBy (xpath = "//section[@id=\"songsWrapper\"]//*[@class=\"meta text-secondary\"]")
    public WebElement allSongsTotalCountPlaytimeText;


    By allSongsLocator = By.xpath("//*[@id=\"songsWrapper\"]//*[@class=\"song-item\"]");


    public void goToAllSongsPage() {
        moveToElementClick(allSongs);
    }

    public void playSongInAllSongsPage(int numberOfPlayedSongs) {
        int totalNumberOfSongs;
        String message = "The total number of songs in All Songs Page is ";
        int y = getPopulationSize(allSongsLocator, message);
        totalNumberOfSongs = y;
        for (int x = 1; x <= numberOfPlayedSongs; x++ ){
            int songItemNumber = getRandomNumber(1, y);

            // to account for the bug in UI where only 63 songs are displayed instead of all 66 songs
            if (songItemNumber > 63) {
                songItemNumber = songItemNumber - 3;
            }

            String locator = String.format("(//*[@id=\"songsWrapper\"]//*[@class=\"song-item\"])[%s]", songItemNumber);
            WebElement song = findElement(By.xpath(locator));
            moveToElementDoubleClick(song);
            System.out.println("Double clicked on the song element");

        }
    }


}
