package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class BaseDefinition {
    private static final ThreadLocal<WebDriver> SHARED_DRIVER = new ThreadLocal<>();
    private WebDriver driver = null;
    private int limitSeconds = 3;

    // This method returns the WebDriver instance stored in the ThreadLocal variable.
    public static WebDriver getThreadLocal() {
        return SHARED_DRIVER.get();
    }

    // This method is executed before each scenario and sets up the browser.
    @Before
    public void setUpBrowser() throws MalformedURLException {
        SHARED_DRIVER.set(pickBrowser(System.getProperty("browser")));
        SHARED_DRIVER.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(limitSeconds));
        System.out.println(
                "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());
    }

    // This method selects the browser based on the provided input and returns the corresponding WebDriver instance.
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.24.184:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver(optionsFirefox);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-edge":
                capabilities.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--lang-en");
                optionsChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new ChromeDriver(optionsChrome);
        }
    }

    // This method is executed after each scenario and performs browser teardown.
    @After
    public void tearDown() {
        SHARED_DRIVER.get().close();
        SHARED_DRIVER.remove();
    }
}