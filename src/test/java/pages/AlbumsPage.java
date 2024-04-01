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
    private final By albumsLocator = By.xpath("//*[@id=\"albumsWrapper\"]//*[@class=\"item full\"]");

    public void goToAlbumsPage() {
        moveToElementClick(albums);
    }

    public void playAlbum(int numberOfPlayedAlbums) {
        String albumsLocatorFormat = "(//*[@id=\"albumsWrapper\"]//*[@class=\"item full\"])[%s]";
        String message = "The total number of albums in Albums Page is ";
        playSong(numberOfPlayedAlbums, message, albumsLocatorFormat, albumsLocator);
    }
}
