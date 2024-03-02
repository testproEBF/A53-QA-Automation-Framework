package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());

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
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogIn();
        loginPage.loggedIn();
    }

    @And("{string} message is displayed")
    public void getLoginNotification(String notification) {
        loginPage.getLoginNotification(notification);
    }

}
