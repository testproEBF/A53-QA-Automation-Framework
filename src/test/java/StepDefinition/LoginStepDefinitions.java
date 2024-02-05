package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import pages.BasePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;

    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }


    @Given("I open Login Page")
    public void openLogin() {
        LoginPage.openLogin();
    }


    @When("I enter email {string}")
    public void enterEmail(String email) {
        LoginPage.enterEmail(email);
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        LoginPage.enterPassword(password);
    }

    @And("I click submit")
    public void clickSubmit() {
       LoginPage.clickSubmit();
    }

    @Then("I am logged in")
    public void loggedIn() {
        BasePage.loggedIn();
    }

    @Then("I am not logged in")
    public void notLoggedIn() {
        LoginPage.notLoggedIn();
    }

    @Given("I am Loggedin using {string} and {string}")
    public void iAmLoggedin(String email, String password) {
        LoginPage.openLogin();
        LoginPage.enterEmail(email);
        LoginPage.enterPassword(password);
        LoginPage.clickSubmit();
    }

}
