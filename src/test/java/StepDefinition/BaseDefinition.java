package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseDefinition {
    static WebDriver SHARED_DRIVER;

    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized", "-lang=en");
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        SHARED_DRIVER = driver;
    }

    @After
    public void closeBrowser(){
        SHARED_DRIVER.quit();
    }

}
