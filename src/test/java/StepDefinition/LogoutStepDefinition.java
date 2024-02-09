package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.BasePage;

public class LogoutStepDefinition{

    WebDriver driver;
    BasePage basePage;

    /*public LogoutStepDefinition (){
        basePage = new BasePage(driver);
    }*/
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

    @When("I click the logout button")
    public void clickLogoutButton() {
        basePage.clickLogoutButton();
    }

    @And("I press enter")
    public void pressEnter() {
        basePage.pressEnter();
    }
}
