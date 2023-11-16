import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;


import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class BaseTest {

    public static RemoteWebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;

    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();

    @DataProvider(name = "LoginData")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"ramil.hasanli@testpro.io", "iutZVH7Q"}
        };
    }

    @BeforeSuite
    static void setupClass() {
//        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
//        Added ChromeOptions argument below to fix websocket error
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");

//        driver = pickBrowser(System.getProperty("browser"));

        threadDriver.set( pickBrowser(System.getProperty("browser")) );
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();

        // Initialize WebDriverWait using the getDriver() method
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());

        url = BaseURL;
        navigateToPage();
    }


    public WebDriver getDriver() {
        System.out.println("Driver is accessed");
        // one more line of code
        return threadDriver.get();
    }

    public static RemoteWebDriver lambdaTest() throws MalformedURLException {
        String hubURL="https://hub.lambdatest.com/wd/hub";

        FirefoxOptions browserOptions = new FirefoxOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("120.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username","9161290r");
        ltOptions.put("accessKey","BWlDPCK7CFczG6DvwfVbHRAEQWCdXTyjiQBwfbYpOolKUtJ59L");
        ltOptions.put("project", "Automation Test");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.1.8.115:4444";

        switch (browser){
            case "firefox": // gradle clean test -Dbrowser=firefox
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "MicrosoftEdge": // gradle clean test -Dbrowser=MicrosoftEdge
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            case "grid-edge": // gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-firefox": // gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome": // gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud": // gradle clean test -Dbrowser=cloud
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }
    public  void navigateToPage() {
        getDriver().get(url);
    }
    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }

}
