package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.BasePage;

public class LogoutStepDefinition {

    @When("I click the logout button")
    public void clickLogoutButton() {
        BasePage.clickLogoutButton();
    }

    @And("I press enter")
    public void pressEnter() {
        BasePage.pressEnter();
    }
}
