package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.BasePage;

public class PlaylistStepDefinition {
    String newPlaylistName = basePage.generateRandomName();

    WebDriver driver;
    BasePage basePage;

    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);

        basePage = new BasePage(driver);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @When("^I click the plus button")
    public void clickPlusButton() {
        basePage.clickPlusButton();
    }

    @And("I click New Playlist")
    public void clickNewPlaylist() {
        basePage.clickNewPlaylist();
    }


    @And("I enter playlist name")
    public void enterPlaylistName() {
        basePage.enterPlaylistName(newPlaylistName);
    }

    @Then("I created a playlist")
    public void createdPlaylist() {
        String expectedSuccessMessage = String.format("Created playlist \"%s.\"", newPlaylistName);
        Assert.assertEquals(basePage.getNotification(), expectedSuccessMessage);
    }
}