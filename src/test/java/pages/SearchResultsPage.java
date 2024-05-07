package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchResultsPage extends BasePage{

    public SearchResultsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (xpath = "//*[@class=\"artists\"]/p")
    private WebElement artistResults;


    public void displayArtistUnderArtistsInSearchResults(String artistName) {
        Assert.assertEquals(artistResults.getText(), artistName);
    }
}
