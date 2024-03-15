package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@type='email']")
    private WebElement emailField;
    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@href=\"registration\"]")
    private WebElement registerButton;

    public LoginPage (WebDriver givenDriver){
        super (givenDriver);
    }

    public void openLogin(){
        driver.get("https://qa.koel.app/");
    }

    public LoginPage enterEmail(String email) {
        Assert.assertTrue(fluentWaitForElement(emailField));
        findElementClickable(emailField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElementVisibility(emailField).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        Assert.assertTrue(fluentWaitForElement(passwordField));
        findElementClickable(passwordField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElementVisibility(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickLogIn() {
        // force few sec delay between each login
        // this adds "wait" time between logins
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        Assert.assertTrue(fluentWaitForElement(loginButton));
        findElementVisibility(loginButton).click();
        return this;
    }

    public void notLoggedIn() {
        Assert.assertTrue(waitForElementToBeVisible(registerButton));
    }

    public void getLoginNotification(String message) {
        Assert.assertTrue(waitForElementToBeVisible(notification));
        Assert.assertEquals(getNotification(), message);
    }
}


