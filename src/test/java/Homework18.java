import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException{
        //log in
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        // Click Play (Done first because nothing is played when Next Button
        // is clicked right after logging in)
        clickMediaPlayerPlayButton();
        Thread.sleep(5000);

        //Click play next song (media player)
        clickMediaPlayerNextButton();
        Thread.sleep(5000);

        //Assertion (sound bar/pause button is displayed)
        WebElement mediaPlayerPauseButton = driver.findElement(By.cssSelector("#mainFooter .fa.fa-pause"));
        Assert.assertTrue(mediaPlayerPauseButton.isDisplayed());

    }

    public void clickMediaPlayerPlayButton() throws InterruptedException {
        WebElement mediaPlayerPlayButton = driver.findElement(By.cssSelector("[title=\"Play or resume\"]"));
        Actions act =  new Actions(driver);
        act.moveToElement(mediaPlayerPlayButton).click().perform();
    }

    public void clickMediaPlayerNextButton(){
        WebElement mediaPlayerNextButton = driver.findElement(By.cssSelector("[data-testid=\"play-next-btn\"]"));
        mediaPlayerNextButton.click();
        // Actions act =  new Actions(driver);
        //act.moveToElement(mediaPlayerNextButton).click().perform();
    }
}

