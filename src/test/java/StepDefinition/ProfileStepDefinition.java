package StepDefinition;
import io.cucumber.java.en.And;
import pages.ProfilePage;

public class ProfileStepDefinition {

    ProfilePage profilePage = new ProfilePage(BaseDefinition.SHARED_DRIVER);

    @And("I update my email to {string} using password {string}")
    public void updateEmail(String newEmail, String password) {
        profilePage.updateEmail(newEmail, password);
        profilePage.waitNotificationDisappear();
    }

    @And("I update my password from {string} to {string}")
    public void updatePassword(String password, String newPassword) {
        profilePage.updatePassword(password, newPassword);
        profilePage.waitNotificationDisappear();
    }
}
