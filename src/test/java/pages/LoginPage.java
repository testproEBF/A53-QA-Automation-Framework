package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    @FindBy(css = "[type='submit")
    WebElement loginButton;
    @FindBy(css = "[href=\"registration\"]")
    WebElement registerButton;

    public LoginPage (WebDriver givenDriver){
        super (givenDriver);
    }

    public void openLogin(){
        driver.get("https://qa.koel.app/");
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogIn() {
        loginButton.click();
    }

    public void notLoggedIn() {
        Assert.assertNotNull(registerButton);
    }
}


