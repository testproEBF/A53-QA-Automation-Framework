package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    @FindBy(css = "[type='email']")
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(css = "[type='submit")
    private WebElement loginButton;
    @FindBy(css = "[href=\"registration\"]")
    private WebElement registerButton;

    public LoginPage (WebDriver givenDriver){
        super (givenDriver);
    }

    public void openLogin(){
        driver.get("https://qa.koel.app/");
    }

    public LoginPage enterEmail(String email) {
        findElementClickable(emailField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElementClickable(emailField).sendKeys(email);
        return this;
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        passwordField.sendKeys(password);
    }

    public void clickLogIn() {
        loginButton.click();
    }

    public void notLoggedIn() {
        Assert.assertTrue(waitForElementToBeVisible(registerButton));
    }

    public void getLoginNotification(String message) {
        Assert.assertTrue(waitForElementToBeVisible(notification));
        Assert.assertEquals(getNotification(), message);
    }
}


