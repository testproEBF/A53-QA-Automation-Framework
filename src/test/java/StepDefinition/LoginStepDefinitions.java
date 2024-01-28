package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import pages.BasePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage = new LoginPage(driver);
    BasePage basePage = new BasePage(driver);

    @Given("I open browser")
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
       // wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("I open Login Page")
    //@Parameters({"BaseURL"})
    //public void iOpenLoginPage(String BaseURL) {
    public void iOpenLoginPage() {
        driver.get("https://qa.koel.app/");
    }


    @When("I enter email {string}")
    @Parameters({"email"})
    public void iEnterEmail(String email) {
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    @Parameters({"password"})
    public void iEnterPassword(String password) {
        loginPage.providePassword(password);
    }

    @And("I click submit")
    public void iClickSubmit() {
        loginPage.clickSubmit();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        Assert.assertTrue(basePage.checkAvatarIconDisplayed());
    }
}
