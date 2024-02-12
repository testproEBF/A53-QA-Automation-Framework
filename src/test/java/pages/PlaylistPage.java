package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v100.dom.DOM;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PlaylistPage extends BasePage {
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
    @FindBy(partialLinkText = "No songs match the playlist's")
    WebElement emptyPlaylist;

    int row;
    int group;

   // String recentAddedSmartPlaylistName;
//    public String getRecentAddedSmartPlaylistName() {
//        return recentAddedSmartPlaylistName;
//    }


    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void inputName(String name){
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-row input[name='name']")));
        nameField.click();
        nameField.sendKeys(name);
    }

    public void  makeARule(String value){
        smartPFModelList.click();
//        smartPFModelLength.click();
        smartPFOperatorList.click();
//        smartPFOperatorIsNot.click();
        smartPFValueField.sendKeys(value);
    }

    public void clickSaveButton(){
        smartPFSaveButton.click();
    }

    public void checkSongsInSmartPlaylist(String song, String name){
        clickSmartPlaylist(name);
        //String songLocator = String.format("Updated playlist \"%s.\"", playlistNewName)"//*[text()='Frantic']";
        Assert.assertNotNull(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Frantic']"))));
    }

    public void checkSongsInSmartPlaylistRandomName(String song) {
        clickSmartPlaylist(recentAddedSmartPlaylistName);
        //String songLocator = String.format("Updated playlist \"%s.\"", playlistNewName)"//*[text()='Frantic']";
        Assert.assertNotNull(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Frantic']"))));
    }

    public void makeMultipleRules(int numOfRules, String value){
        int y = numOfRules + 1;
        group = 1;

        for (int x = 1; x < y ; x++ ){
            row = x+1;
            String model = String.format("div .rule-group:nth-child(%s) .row:nth-child(%d) [name='model[]']", group, row);
            String operator = String.format("div .rule-group:nth-child(%s) .row:nth-child(%d) [name='operator[]']", group, row);
            String valueLocator = String.format("div .rule-group:nth-child(%s) .row:nth-child(%d) [name='value[]']", group, row);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(model))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(operator))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(valueLocator))).sendKeys(value);

            if (x < numOfRules){
                smartPFAddRuleButton.click();
            }
        }
    }

    public void seeEmptyPlaylist() {
        clickSmartPlaylist(recentAddedSmartPlaylistName);
        Assert.assertNotNull(recentAddedSmartPlaylistName);
    }

    public void makeMultipleGroups(int numOfGroups, String value) {
        int y = numOfGroups + 1;

        for (int x = 1; x < y ; x++ ){
            row = 2;
            group = x;
            String model = String.format("div .rule-group:nth-child(%s) .row:nth-child(%d) [name='model[]']", group, row);
            String operator = String.format("div .rule-group:nth-child(%s) .row:nth-child(%d) [name='operator[]']", group, row);
            String valueLocator = String.format("div .rule-group:nth-child(%s) .row:nth-child(%d) [name='value[]']", group, row);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(model))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(operator))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(valueLocator))).sendKeys(value);

            if (x < numOfGroups){
                smartPFAddGroupButton.click();
            }
        }
    }

    public void stillInNewSmartPlaylistForm() {
        Assert.assertNotNull(smartPFSaveButton);
    }

    public void clickCancelButton() {
        smartPFCancelButton.click();
    }

    public void clickOKDiscardButton() {
        smartPFDiscardOKButton.click();
    }

    public void clickCancelDiscardButton() {
        smartPFDiscardCancelButton.click();
    }


}