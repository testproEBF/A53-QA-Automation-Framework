package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArtistsPage extends BasePage{

    public ArtistsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath = "//a[@class=\"artists\"]")
    private WebElement artists;
    By artistsLocator = By.xpath("//*[@id=\"artistsWrapper\"]//*[@class=\"item full\"]");

    public void goToArtistsPage() {
        artists.click();
    }

    public void playArtists(int numberOfPlayedArtists) {
        String message = "The total number of artists in Artists Page is ";
        int y = getPopulationSize(artistsLocator, message);
        for (int x = 1; x <= numberOfPlayedArtists; x++ ){
            int artistItemNumber = getRandomNumber(1, y);

            String albumsLocatorFormat = String.format("(//*[@id=\"artistsWrapper\"]//*[@class=\"item full\"])[%s]", artistItemNumber);
            WebElement artist = findElement(By.xpath(albumsLocatorFormat));
            actions.moveToElement(artist).doubleClick().perform();
        }
    }
}
