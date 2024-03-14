package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

            // to account for the bug in UI where only 63 songs are displayed instead of all 66 songs
            if (songItemNumber > 63) {
                songItemNumber = songItemNumber - 3;
            }

            String locator = String.format("(//*[@id=\"songsWrapper\"]//*[@class=\"song-item\"])[%s]", songItemNumber);
            WebElement song = findElement(By.xpath(locator));
            actions.moveToElement(song).doubleClick().perform();
            System.out.println("Double clicked on the song element");

//            try {
//                WebElement song = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
//                actions.moveToElement(song).doubleClick().perform();
//                System.out.println("Double clicked on the song element");
//            } catch (TimeoutException e) {
//                System.out.println("Element not found: " + locator);
//                continue;
//            }
        }
    }


}
