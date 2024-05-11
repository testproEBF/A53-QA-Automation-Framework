package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SearchResultsPage extends BasePage{

    public SearchResultsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (xpath = "//*[@class=\"artists\"]/p")
    private WebElement artistNegativeSearchResults;
    @FindBy (xpath = "//section[@class=\"artists\"]//a[@class=\"name\"]")
    private WebElement artistPositiveSearchResults;


    public void displayArtistUnderArtistsInSearchResults(String artistName) {
        new WebDriverWait(driver, Duration.ofSeconds(2));
        try{
            Assert.assertEquals(artistPositiveSearchResults.getText(), artistName);
        } catch (Exception e){
            Assert.assertEquals(artistNegativeSearchResults.getText(), artistName);
        }

    }
}
