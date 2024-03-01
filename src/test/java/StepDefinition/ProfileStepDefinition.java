package StepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.PlaylistPage;
import pages.ProfilePage;

public class ProfileStepDefinition {

    BasePage basePage = new BasePage(BaseDefinition.SHARED_DRIVER);
    ProfilePage profilePage = new ProfilePage(BaseDefinition.SHARED_DRIVER);

    @And("I update my email to {string} using password {string}")
    public void updateEmail(String newEmail, String password) {
        profilePage.updateEmail(newEmail, password);
        profilePage.waitNotificationDisappear();
    }
}
