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

    public void goToAllSongsPage() {
        actions.moveToElement(allSongs).doubleClick().perform();
    }

    public void playSongInAllSongsPage(int numberOfPlayedSongs, int totalNumberOfSongs) {
        for (int x = 1; x <= numberOfPlayedSongs; x++ ){
            int songItemNumber = getRandomNumber(1, totalNumberOfSongs);

            if (songItemNumber > 63) {
                songItemNumber = songItemNumber - 3;
            }

            String locator = String.format("#songsWrapper tr.song-item:nth-child(%s)", songItemNumber);
            WebElement song = findElement(By.cssSelector(locator));
            actions.moveToElement(song).doubleClick().perform();
        }
    }


}
