package StepDefinition;

import io.cucumber.java.en.And;
import pages.BasePage;

public class LogoutStepDefinition {

    BasePage basePage = new BasePage(BaseDefinition.SHARED_DRIVER);

    @And("I click log out button")
    public void logOut() {
        basePage.clickLogoutButton();
    }
}
