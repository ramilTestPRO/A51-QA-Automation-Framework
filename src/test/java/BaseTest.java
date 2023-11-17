import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

// Import necessary packages and classes for working with WebDriver,
// browser configurations, and executing automated tests using TestNG.

public class BaseTest {
    protected WebDriver driver = null;
    public String url = null;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    protected WebDriverWait wait;

    public static WebDriver getThreadDriver() {
        return threadDriver.get();
    }
    public void BasePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver cannot be null");
        }

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
    }
    @DataProvider(name = "LoginData")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"ramil.hasanli@testpro.io", "iutZVH7Q"}
        };
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpBrowser(String BaseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        url = BaseURL;
        navigateToPage();
    }

    public void navigateToPage() {
        getDriver().get(url);
    }

    // This getDriver() method returns the current instance of WebDriver associated with the current thread.
    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    @AfterMethod
    public void tearDown() {
        threadDriver.get().close();
        threadDriver.remove();
    }
    // The tearDown() method is executed after each test method (@AfterMethod),
    // and its purpose is to close the WebDriver and remove its instance from ThreadLocal.

    public WebDriver setupLambdaTest() throws MalformedURLException {

        /*      Test Pro Instructor LambdaTest account

        1.) Navigate and Login to https://accounts.lambdatest.com/login

        2.) Run command in IntelliJ Terminal:
         gradle clean test -Dbrowser=cloud

        3.) View the cloud automations in
        https://accounts.lambdatest.com/dashboard

       Configured for the Test Pro lambdatest account
       */
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Firefox");
        capabilities.setCapability("browserVersion", "107.0");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "9161290");
        ltOptions.put("accessKey", "MFNoqfKFadMwV3WUsBf3RlZGCJQRO9nqRgSZkSzKbP0Hxpotz4");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", this.getClass().getName());
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.0.0");
        capabilities.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), capabilities);
    }
    // This setupLambdaTest() method returns an instance of WebDriver for remote testing using the LambdaTest service.

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.1.8.115:4444"; // http://localhost:4444/grid/console

        // in PowerShell/CMD run java -jar selenium-server-4.15.0.jar standalone --selenium-manager true

        // Log the value of gridURL for debugging
        System.out.println("gridURL: " + gridURL);

        switch (browser) {
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
                return setupLambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);

        }
    }
    // This pickBrowser() method selects and returns an instance of WebDriver depending on the passed browser parameter.
}