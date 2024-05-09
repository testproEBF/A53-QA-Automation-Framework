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
    private WebElement artistNegativeSearchResults;
    @FindBy (xpath = "//section[@class=\"artists\"]//a[@class=\"name\"]")
    private WebElement artistPositiveSearchResults;


    public void displayArtistUnderArtistsInSearchResults(String artistName) {
        try{
            Assert.assertEquals(artistPositiveSearchResults.getText(), artistName);
        } catch (Exception e){
            Assert.assertEquals(artistNegativeSearchResults.getText(), artistName);
        }

    }
}
