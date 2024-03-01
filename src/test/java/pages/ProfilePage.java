package pages;

import org.openqa.selenium.Keys;
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
        findElementVisibility(avatarIcon).click();
        findElementVisibility(profileCurrentPasswordField).sendKeys(password);
        findElementVisibility(profileEmailField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElementVisibility(profileEmailField).sendKeys(newEmail);
//        findElementVisibility(profileSaveButton).click();
        actions.moveToElement(findElementClickable(profileSaveButton)).click().perform();
        getUpdateEmailNotification();
    }

    public void getUpdateEmailNotification(){
        String message = "Profile updated.";
        Assert.assertEquals(getNotification(), message);
    }

    public void waitNotificationDisappear() {
        wait.until(ExpectedConditions.invisibilityOf(notification));
    }
}
