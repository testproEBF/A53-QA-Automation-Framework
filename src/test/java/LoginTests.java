import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest{

    @Test
    @Parameters({"email", "password"})
    public void loginValidCredentials(String email, String password){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail(email)
                 .providePassword(password)
                 .clickSubmit();

    }
}
