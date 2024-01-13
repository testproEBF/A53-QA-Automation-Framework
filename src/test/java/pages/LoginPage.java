package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage (WebDriver givenDriver){
        super (givenDriver);
    }

    @FindBy(css = "input[type='email']")
    private WebElement emailField;
    @FindBy(css = "input[type='password']")
    private WebElement passwordField;
    @FindBy (css = "button[type='submit']")
    private WebElement submitButton;

    public LoginPage provideEmail (String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword (String password){
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit(){
        submitButton.click();
        return this;
    }

}
