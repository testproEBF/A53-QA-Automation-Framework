package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PlaylistPage extends BasePage {
    @FindBy(css = ".form-row input[name='name']")
    WebElement smartPFormNameField;
    @FindBy(css = ".row [name=\"model[]\"]")
    WebElement smartPFModelList;
    @FindBy(linkText = "length")
    WebElement smartPFModelLength;
    @FindBy(css = ".row [name=\"operator[]\"]")
    WebElement smartPFOperatorList;
    @FindBy(partialLinkText = "is not")
    WebElement smartPFOperatorIsNot;
    @FindBy(css = ".row input[name='value[]']")
    WebElement smartPFValueField;
    @FindBy(css = ".btn-add-rule")
    WebElement smartPFAddRuleButton;
    @FindBy(css = ".btn-add-group")
    WebElement smartPFAddGroupButton;
    @FindBy(css = ".smart-playlist-form [type=\"submit\"]")
    WebElement smartPFSaveButton;
    @FindBy(css = ".btn-cancel")
    WebElement smartPFCancelButton;
    @FindBy(css = ".cancel")
    WebElement smartPFDiscardCancelButton;
    @FindBy(css = ".ok")
    WebElement smartPFDiscardOKButton;


    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public PlaylistPage inputOneCharName(String name){
        /*smartPFormNameField.click();
        smartPFormNameField.sendKeys("A");*/
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-row input[name='name']")));
        nameField.click();
        nameField.sendKeys(name);
        return this;
    }

    public PlaylistPage  makeARule(String sec){
        smartPFModelList.click();
//        smartPFModelLength.click();
        smartPFOperatorList.click();
//        smartPFOperatorIsNot.click();
        smartPFValueField.sendKeys(sec);
        return this;
    }

    public PlaylistPage clickSaveButton(){
        smartPFSaveButton.click();
        return this;
    }

    public PlaylistPage checkSongsInSmartPlaylist(String song, String name){
        clickSmartPlaylist(name);
        Assert.assertNotNull(wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(song))));
        return this;
    }




}