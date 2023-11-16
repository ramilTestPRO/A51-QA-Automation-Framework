package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page_factory.LoginPage;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;


    @Before
    @Given("I open browser")
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origin=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @And("I open Login Page")
    public void iOpenLoginPage() {
        driver.get("https://qa.koel.app/");
    }

    @And("I enter email {string}")
    public void iEnterEmail(String email) {
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']"))).sendKeys(email);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']"))).sendKeys(password);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @And("Submit")
    public void submit() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']"))).click();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.clickSubmit();
    }

    @Then("I should get logged in")
    public void iShouldGetLoggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("imq.avatar"))).isDisplayed());
    }
}
