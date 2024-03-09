package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CurrentQueuePage extends BasePage{

    public CurrentQueuePage (WebDriver givenDriver){
        super (givenDriver);
    }

    @FindBy(xpath = "//a[@class=\"queue\"]")
    private WebElement currentQueue;

    @FindBy(xpath = "//section[@id=\"queueWrapper\"]//h1")
    private WebElement currentQueueText;

    public void goToCurrentQueuePage() {
        actions.moveToElement(currentQueue).doubleClick().perform();
    }

    public void checkPresenceOfSongs(int numberOfSongs) {
        String locator = String.format(".song-list-wrap.main-scroll-wrap.queue tr.song-item:nth-child(%s)", numberOfSongs);
        WebElement element = findElement(By.cssSelector(locator));
        Assert.assertTrue(waitForElementToBeVisible(element));

//        for (int x = 1; x <= numberOfSongs; x++ ){
//            String locator = String.format(".song-list-wrap.main-scroll-wrap.queue tr.song-item:nth-child(%s)", x);
//            WebElement element = findElement(By.cssSelector(locator));
//            Assert.assertTrue(waitForElementToBeVisible(element));
//            findElementVisibility(element).click();
//        }
    }

    public void checkTotalNumberOfSongs(int numberOfSongs) {
        String locator = String.format("%s songs", numberOfSongs);
        WebElement element = findElement(By.linkText(locator));
        Assert.assertTrue(waitForElementToBeVisible(element));
    }

    public void checkIfNavigatedToCurrentQueuePage() {
        Assert.assertTrue(waitForElementToBeVisible(currentQueueText));
    }
}
