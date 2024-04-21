package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VeevaLoginPage extends VeevaBasePage{

    public VeevaLoginPage (WebDriver givenDriver){
        super (givenDriver);
    }

    @FindBy(xpath = "//*[@id=\"j_username\"]")
    private WebElement usernameField;
    @FindBy(xpath = "//*[@name=\"continue\"]")
    private WebElement continueButton;
}
