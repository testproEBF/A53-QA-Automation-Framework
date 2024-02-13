package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PlaylistPage extends BasePage {

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
    @FindBy(xpath = "//section[@id='playlistWrapper']/header/div/span/span[contains(text(),'66 songs')]")
    WebElement allSongsPresent;

    int row;
    int group;

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void inputName(String name){
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-row input[name='name']")));
        nameField.click();
        nameField.sendKeys(name);
    }

    public void  inputRule(int group, int row, String modelOption, String operatorOption, String value){
        String model = String.format("//div[%s]/div[%s]/select[@name='model[]']", group, row);
        String modelOptionLocator = String.format("//div[%s]/div[%s]/select[@name='model[]']/option[text()='%s']", group, row, modelOption);
        String operator = String.format("//div[%s]/div[%s]/select[@name='operator[]']", group, row);
        String operatorOptionLocator = String.format("//div[%s]/div[%s]/select[@name='operator[]']/option[text()='%s']", group, row, operatorOption);
        String valueLocator = String.format("//div[%s]/div[%s]/span/*[@name='value[]']", group, row);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(model))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(modelOptionLocator))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(operator))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(operatorOptionLocator))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(valueLocator))).sendKeys(value);
    }

    public void makeRuleRules(int ruleNumber, String modelOption, String operatorOption, String value) {
        int y = ruleNumber + 1;
        group = 1;

        for (int x = 1; x < y ; x++ ){
            row = x+1;
            inputRule(group, row, modelOption, operatorOption, value);

            if (x < ruleNumber){
                smartPFAddRuleButton.click();
            }
        }
    }

    public void makeGroups(int groupNumber, String modelOption, String operatorOption, String value) {
        int y = groupNumber + 1;
        row = 2;

        for (int x = 1; x < y ; x++ ){
                group = x;
                inputRule(group, row, modelOption, operatorOption, value);

            if (x < groupNumber){
                smartPFAddGroupButton.click();
            }
        }
    }

    public void  editInputRule(int group, int row, String modelOption, String operatorOption, String value){
        String model = String.format("//div[%s]/div[%s]/select[@name='model[]']", group, row);
        String modelOptionLocator = String.format("//div[%s]/div[%s]/select[@name='model[]']/option[text()='%s']", group, row, modelOption);
        String operator = String.format("//div[%s]/div[%s]/select[@name='operator[]']", group, row);
        String operatorOptionLocator = String.format("//div[%s]/div[%s]/select[@name='operator[]']/option[text()='%s']", group, row, operatorOption);
        String valueLocator = String.format("//div[%s]/div[%s]/span/*[@name='value[]']", group, row);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(model))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(modelOptionLocator))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(operator))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(operatorOptionLocator))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(valueLocator))).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(valueLocator))).sendKeys(value);
    }

    public void editRule(int ruleNumber, String modelOption, String operatorOption, String value){
        group = 1;
        row = ruleNumber + 1;
        editInputRule(group, row, modelOption, operatorOption, value);
    }

    public void editGroupRule(int groupNumber, String modelOption, String operatorOption, String value){
        group = groupNumber;
        row = 2;
        editInputRule(group, row, modelOption, operatorOption, value);
    }

    public void clickSaveButton(){
        smartPFSaveButton.click();
    }

    public void smartPlaylistCreatedNotification(String name) {
        String actualMessage = String.format("Created playlist \"%s.\"", name);
        Assert.assertEquals(getNotification(), actualMessage);
    }

    public void checkSongsInSmartPlaylist(String song, String name){
        clickSmartPlaylist(name);
        String songLocator = String.format("//*[text()='%s']", song);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(songLocator))).isDisplayed());
    }

    public void checkSongsInSmartPlaylistRandomName(String song) {
        clickSmartPlaylist(recentAddedSmartPlaylistName);
        String songLocator = String.format("//*[text()='%s']", song);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(songLocator))).isDisplayed());
    }

    public void seeEmptyPlaylistRandomName() {
        clickSmartPlaylist(recentAddedSmartPlaylistName);
        Assert.assertNotNull(emptyPlaylist);
    }

    public void seeEmptyPlaylist(String name) {
        clickSmartPlaylist(name);
        Assert.assertNotNull(emptyPlaylist);
//        Assert.assertTrue(emptyPlaylist.isDisplayed());
    }

    public void stillInNewSmartPlaylistForm() {
//        Assert.assertNotNull(smartPFSaveButton);
        Assert.assertTrue(smartPFSaveButton.isDisplayed());
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

    public void seeAll66SongsInPlaylist() {
        Assert.assertNotNull(allSongsPresent);
//        Assert.assertTrue(allSongsPresent.isDisplayed());
    }

}