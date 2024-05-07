package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainFooterPage extends BasePage {
    @FindBy(xpath = "//*[@alt=\"Sound bars\"]")
    protected WebElement soundBar;

    public MainFooterPage(WebDriver givenDriver) {
        super(givenDriver);
    }

}