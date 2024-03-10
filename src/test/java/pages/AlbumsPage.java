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

    public void goToAlbumsPage() {
        actions.moveToElement(albums).doubleClick().perform();
    }

    public void playAlbum(int numberOfPlayedAlbums, int totalNumberOfAlbums) {
        int albumItemNumber = getRandomNumber(1, totalNumberOfAlbums);
        String locator = String.format("(//article[@class=\"item full\"])[%s]", albumItemNumber);
        WebElement album = findElement(By.xpath(locator));
        actions.moveToElement(album).doubleClick().perform();
    }
}
