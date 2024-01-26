import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;

public class LoginTests extends BaseTest{

    @Test
    @Parameters({"email", "password"})
    public void loginValidCredentials(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());

        loginPage.login(email, password);

        Assert.assertTrue(basePage.checkAvatarIconDisplayed());
    }


    @Test(dataProvider = "InvalidLoginData", dataProviderClass=BaseTest.class)
    //@Parameters({"BaseUrl"})
    public void loginWithInvalidEmailValidPassword(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login(email, password);

        //Expected Result
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
