import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void navigateToKoelApp() {
        navigateToUrl();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void loginValidEmailPassword() {

            provideEmail("demo@class.com");
            providePassword("te$t$tudent");
            clickSubmit();

            //Assertion
            WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
            Assert.assertTrue(avatarIcon.isDisplayed());

    }

    @Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {
       provideEmail("invalid@class.com");
       providePassword("te$t$tudent");
       clickSubmit();
       Thread.sleep(2000);

       //Assertion
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginWithInvalidPasswordAndValidEmail() throws InterruptedException {
        provideEmail("demo@class.com");
        providePassword("invalidpassword");
        clickSubmit();
        Thread.sleep(2000);

        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}