package StepDefinition;

import io.cucumber.java.en.And;
import pages.BasePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class LogoutStepDefinition {

    BasePage basePage = new BasePage(BaseDefinition.SHARED_DRIVER);

    @And("I log out")
    public void logOut() {
        basePage.clickLogoutButton();
    }
}
