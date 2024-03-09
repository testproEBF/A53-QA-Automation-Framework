package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlbumsPage extends BasePage{

    public AlbumsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath = "//a[@class=\"albums\"]")
    private WebElement albums;

    public void goToAllSongsPage() {
        actions.moveToElement(albums).doubleClick().perform();
    }
}
