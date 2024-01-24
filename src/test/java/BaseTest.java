import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    //Data Providers
    @DataProvider(name="InvalidLoginData")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][] {
                {"invalid@mail.com", "invalidPassword"},
                {"demo@class.com", ""},
                {"", "te$t$tudent"},
                {"",""}
        };
    }

    public WebDriver driver = null;
    public String url = null;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();

        url = BaseURL;
        navigateToUrl(url);
    }

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    private WebDriver pickBrowser (String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.222:4444";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        switch (browser){
            case "chrome":
                return driver = new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "grid-safari":
                caps.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lamdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver(chromeOptions);
        }
    }

    public WebDriver lamdaTest() throws MalformedURLException {
        String hubURL = "@hub.lamdatest.com/";
        String username = System.getenv("LT_USERNAME") == null ? "" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "" : System.getenv("LT_ACCESS_KEY");

        DesiredCapabilities capabilities = new DesiredCapabilities();


        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("macOS Sonoma");
        browserOptions.setBrowserVersion("120.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "enrile.fuentes");
        ltOptions.put("accessKey", "12K3XhCWuHpuTAhIxeeFb0bXUbWgYtBXNwY4dWpnrczOY5F3SZ");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("resolution", "2560x1440");
        ltOptions.put("project", "Untitled");
        ltOptions.put("name", "Homework25ParallelTesting");
        ltOptions.put("selenium_version", "4.5.0");
        ltOptions.put("driver_version", "120.0");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);

        URL lambdaUrl;
        try{
            lambdaUrl = new URI("https://" + username + ":" + authkey + hubURL).toURL();
        }catch (URISyntaxException e) {
            lambdaUrl = new URL("https://" + username + ":" + authkey + hubURL);
        }
        System.out.println("url: " + lambdaUrl.toString());
        Assert.assertNotNull(lambdaUrl, "url: " + lambdaUrl.toString());
        return new RemoteWebDriver(lambdaUrl, capabilities);

    }

    @AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }


    public void navigateToUrl(String url){
        getDriver().get(url);
    }

}