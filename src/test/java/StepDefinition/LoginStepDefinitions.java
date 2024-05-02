package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage(BaseDefinition.SHARED_DRIVER);

    @Given("I open Login Page")
    public void openLogin() throws InterruptedException {
        loginPage.openLogin();
    }

    @When("I enter email {string}")
    public void enterEmail(String email) throws InterruptedException {
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

    @Given("I am logged in using {string} and {string}")
    public void iAmLoggedIn(String email, String password) throws InterruptedException {
        loginPage.enterEmail(email)
                .enterPassword(password)
                .clickLogIn()
                .loggedIn();
    }

    @And("the message {string} is displayed")
    public void getLoginNotification(String notification) {
            loginPage.getLoginNotification(notification);
    }
}
