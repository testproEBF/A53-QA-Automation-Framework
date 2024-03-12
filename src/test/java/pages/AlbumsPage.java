package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlbumsPage extends BasePage{

    public AlbumsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath = "//a[@class=\"albums\"]")
    private WebElement albums;
    By albumsLocator = By.xpath("//*[@id=\"albumsWrapper\"]//*[@class=\"item full\"]");

    public void goToAlbumsPage() {
        actions.moveToElement(albums).doubleClick().perform();
    }

    public void playAlbum(int numberOfPlayedAlbums) {
        String message = "The total number of albums in Albums Page is ";
        int y = getPopulationSize(albumsLocator, message);
        for (int x = 1; x <= numberOfPlayedAlbums; x++ ){
            int albumItemNumber = getRandomNumber(1, y);

            String albumsLocatorFormat = String.format("(//*[@id=\"albumsWrapper\"]//*[@class=\"item full\"])[%s]", albumItemNumber);
            WebElement album = findElement(By.xpath(albumsLocatorFormat));
            actions.moveToElement(album).doubleClick().perform();
        }
    }
}
