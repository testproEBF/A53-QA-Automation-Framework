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
import org.testng.Assert;
import pages.LoginPage;

public class LoginStepDefinitions {
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);

        loginPage = new LoginPage(driver);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }


    @Given("I open Login Page")
    public void openLogin() {
        loginPage.openLogin();
    }


    @When("I enter email {string}")
    public void enterEmail(String email) {
        loginPage.enterEmail(email);
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("I click submit")
    public void clickSubmit() {
       loginPage.clickLogIn();
    }

    @Then("I am logged in")
    public void loggedIn() {
        loginPage.loggedIn();
    }

    @Then("I am not logged in")
    public void notLoggedIn() {
        loginPage.notLoggedIn();
    }

    @Given("I am LoggedIn using {string} and {string}")
    public void iAmLoggedIn(String email, String password) {
        loginPage.openLogin();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogIn();
        loginPage.notLoggedIn();

    }
}
