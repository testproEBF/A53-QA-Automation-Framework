package StepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BasePage;
import pages.ProfilePage;

public class ProfileStepDefinition {

    ProfilePage profilePage = new ProfilePage(BaseDefinition.SHARED_DRIVER);
    BasePage basePage = new BasePage(BaseDefinition.SHARED_DRIVER);

    @And("I navigate to Profile and Preferences Page")
    private void goToProfileAndPreferencesPage() {
        basePage.goToProfileAndPreferencesPage();
    }

    @And("I update my email to {string} using password {string}")
    private void updateEmail(String newEmail, String password) {
        profilePage.updateEmail(newEmail, password);
    }

    @Then("a notification {string} is displayed")
    private void successNotificationIsDisplayed(String successMessage) {
        profilePage.getProfileUpdateSuccessfulNotification(successMessage);
//        profilePage.waitNotificationDisappear();
    }

    @And("I update my password from {string} to {string}")
    private void updatePassword(String password, String newPassword) {
        profilePage.updatePassword(password, newPassword);
//        profilePage.waitNotificationDisappear();
    }

    @Then("an error notification {string} is displayed")
    private void anErrorNotificationIsDisplayed(String errorMessage) {
        profilePage.getDisplayedErrorNotification(errorMessage);
    }
}
