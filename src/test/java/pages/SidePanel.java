package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {

    public SidePanel(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (xpath = "//*[@type=\"search\"]")
    private WebElement searchBar;


    public void searchArtistUsingSearchBar(String artistName) {
        searchBar.click();
        searchBar.sendKeys(artistName);
    }
}