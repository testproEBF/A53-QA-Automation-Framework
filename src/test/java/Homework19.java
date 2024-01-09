import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19 extends BaseTest{

    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    @Parameters({"email", "password"})
    public void deletePlaylist(String email, String password){
        provideEmail(email);
        providePassword(password);
        clickSubmit();

        //create playlist
        String newPlaylistName = generateRandomName();
        clickPlusButton();
        createNewPlaylist(newPlaylistName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("Created playlist")));

        //delete playlist
        deleteEmptyPlaylist(newPlaylistName);

        //Assertion
        String expectedSuccessMessage = String.format("Deleted playlist \"%s.\"", newPlaylistName);
        Assert.assertEquals(getNotification(), expectedSuccessMessage);

    }

    public void clickDeletePlaylistButton(String newPlaylistName){
        selectPlaylist(newPlaylistName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String locator = ".del.btn-delete-playlist";
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
        deletePlaylistButton.click();
    }

    public void deleteEmptyPlaylist(String newPlaylistName){
        clickDeletePlaylistButton(newPlaylistName);
    }

}
