package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage{

    public AllSongsPage(WebDriver givenDriver){
        super (givenDriver);
    }

    public int TOTAL_NUMBER_OF_SONGS;

    @FindBy (xpath = "//a[@class=\"songs\"]")
    private WebElement allSongs;
    By allSongsLocator = By.xpath("//*[@id=\"songsWrapper\"]//*[@class=\"song-item\"]");


    public void goToAllSongsPage() {
        actions.moveToElement(allSongs).doubleClick().perform();
    }

    public void playSongInAllSongsPage(int numberOfPlayedSongs) {
        String message = "The total number of songs in All Songs Page is ";
        int y = getPopulationSize(allSongsLocator, message);
        for (int x = 1; x <= numberOfPlayedSongs; x++ ){
            int songItemNumber = getRandomNumber(1, y);

            if (songItemNumber > 63) {
                songItemNumber = songItemNumber - 3;
            }

            String locator = String.format("(//*[@id=\"songsWrapper\"]//*[@class=\"song-item\"])[%s]", songItemNumber);
            WebElement song = findElement(By.xpath(locator));
            actions.moveToElement(song).doubleClick().perform();
        }
    }


}
