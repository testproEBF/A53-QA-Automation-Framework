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

    public void openLogin() throws InterruptedException {
        // force few sec delay between each login
        // workaround on the 429 error that causes random failed logins
        // `429 Too Many Requests` error on `/api/data` call which is an API called immediately after login
        //  429 error is caused by Rate Limiting; the API does not allow the user / frontend application to send “too many requests in a given amount of time”
        try{
            driver.get("https://qa.koel.app/");
        } catch (AssertionError e){
            Thread.sleep(5000);
            driver.get("https://qa.koel.app/");
        }

    }

    public LoginPage enterEmail(String email) throws InterruptedException {
        // workaround on the 429 error that causes random failed logins
        try {
            Assert.assertTrue(fluentWaitForElement(emailField));
            findElementClickable(emailField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
            findElementVisibility(emailField).sendKeys(email);
            return this;
        } catch (AssertionError error){
            Thread.sleep(5000);
            openLogin();
            Thread.sleep(5000);
            Assert.assertTrue(fluentWaitForElement(emailField));
            findElementClickable(emailField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
            findElementVisibility(emailField).sendKeys(email);
            return this;
        }
    }

    public LoginPage enterPassword(String password) {
        Assert.assertTrue(fluentWaitForElement(passwordField));
        findElementClickable(passwordField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElementVisibility(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickLogIn() {
        Assert.assertTrue(fluentWaitForElement(loginButton));
        findElementVisibility(loginButton).click();
        return this;
    }

    public void loggedInForCurrentQueue(String email, String password) throws InterruptedException {
        // workaround on the 429 error that causes random failed logins
        // this method reloads the page and forces several seconds delay when 429 error is encountered
        try {
            Assert.assertTrue(waitForElementToBeVisible(avatarIcon));
        } catch (AssertionError error){
            Thread.sleep(5000);
            openLogin();
            Thread.sleep(5000);
            enterEmail(email);
            Thread.sleep(5000);
            enterPassword(password);
            Thread.sleep(5000);
            clickLogIn();
            Thread.sleep(5000);
            Assert.assertTrue(waitForElementToBeVisible(avatarIcon));
        }
    }

    public void notLoggedIn() {
        Assert.assertTrue(waitForElementToBeVisible(registerButton));
    }

    public void getLoginNotification(String message) {
        Assert.assertTrue(waitForElementToBeVisible(notification));
        Assert.assertEquals(getNotification(), message);
    }

}


