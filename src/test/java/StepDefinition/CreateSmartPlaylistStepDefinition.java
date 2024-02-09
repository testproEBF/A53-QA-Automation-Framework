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

public class CreateSmartPlaylistStepDefinition {

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

    @When("I click on the + button under PLAYLISTS on the main menu")
    public void clickPlusButton() {
        basePage.clickPlusButton();
    }
}