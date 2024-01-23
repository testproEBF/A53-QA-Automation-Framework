import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;

public class LoginTests extends BaseTest{

    @Test
    @Parameters({"email", "password"})
    public void loginValidCredentials(String email, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);

        loginPage.provideEmail(email)
                 .providePassword(password)
                 .clickSubmit();

        /**
         * Workaround safari issue:
         *  `org.openqa.selenium.NoSuchElementException`
         *
         * The assumption is safari is slow to load the page
         * after login.
         */
        Thread.sleep(5000);

        Assert.assertTrue(basePage.checkAvatarIconDisplayed());
    }
}
