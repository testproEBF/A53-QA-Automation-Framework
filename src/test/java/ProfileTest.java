import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest {

    @Test
   public void changeProfileName() throws InterruptedException{
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        clickOnAvatar();
        Thread.sleep(2000);
        String randomNewName = generateRandomName();
        Thread.sleep(2000);
        provideCurrentPassword("te$t$tudent");
        Thread.sleep(2000);
        provideNewName(randomNewName);
        Thread.sleep(2000);
        clickSave();
        Thread.sleep(2000);

        //Assertion
        WebElement actualProfileName = driver.findElement(By.cssSelector("span.name"));
        Assert.assertEquals(actualProfileName.getText(), randomNewName);

    }

    //Methods

    public void clickOnAvatar(){
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void provideCurrentPassword(String password){
        WebElement currentPasswordField = driver.findElement(By.cssSelector("#inputProfileCurrentPassword"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
    }

    public void provideNewName(String newName){
        WebElement provideNewNameField = driver.findElement(By.cssSelector("#inputProfileName"));
        provideNewNameField.clear();
        provideNewNameField.sendKeys(newName);
    }

    public void clickSave(){
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

}
