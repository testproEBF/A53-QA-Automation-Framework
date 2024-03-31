package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProfilePage extends BasePage{

    @FindBy(xpath = "//input[@id=\"inputProfileCurrentPassword\"]")
    private WebElement profileCurrentPasswordField;
    @FindBy(xpath = "//input[@id=\"inputProfileEmail\"]")
    private WebElement profileEmailField;
    @FindBy(xpath = "//input[@id=\"inputProfileNewPassword\"]")
    private WebElement profileNewPasswordField;
    @FindBy(xpath = "//button[@class=\"btn-submit\"]")
    private WebElement profileSaveButton;

    public ProfilePage(WebDriver givenDriver){
        super (givenDriver);
    }

    public void updateEmail(String newEmail, String password){
        findElementVisibility(profileCurrentPasswordField).sendKeys(password);
        findElementVisibility(profileEmailField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElementVisibility(profileEmailField).sendKeys(newEmail);
        moveToElementClick(profileSaveButton);
    }

    public void getProfileUpdateSuccessfulNotification(String successMessage){
        Assert.assertEquals(getNotification(), successMessage);
    }

    public void updatePassword(String password, String newPassword) {
        findElementVisibility(profileCurrentPasswordField).sendKeys(password);
        findElementVisibility(profileNewPasswordField).sendKeys(newPassword);
        moveToElementClick(profileSaveButton);
    }

    public void getDisplayedErrorNotification(String errorMessage) {
        Assert.assertEquals(getErrorNotification(), errorMessage);
    }
}
