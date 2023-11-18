import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "LoginData")
    public void loginTests(String email, String password) throws InterruptedException {
        navigateToLoginPage();
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        Thread.sleep(2000);
        //https://qa.koel.app/#!/home
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void loginEmptyEmailPassword() throws InterruptedException {

        navigateToLoginPage();
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailPassword() {

        //steps

        navigateToLoginPage();
        provideEmail("akansha.shukla@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        // WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        //Expected result

        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public void loginInValidEmailValidPassword()  {
        //steps
        navigateToLoginPage();
        provideEmail("InvalidEmail@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        //Expected result
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected result
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public void loginValidEmailNoPassword() throws InterruptedException {

        //steps
        navigateToLoginPage();
        provideEmail("akansha.shukla@testpro.io");
        providePassword("");
        clickSubmit();

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected result
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test(dataProvider = "excel-data")
    public void search(String keyword1, String keyword2){
        provideEmail(keyword1);
        providePassword(keyword2);
        //WebElement txtBox = driver.findElement(By.tagName("//input[@class='gLFYf gsfi']"));
        //txtBox.sendKeys(keyword1,keyword2);
        Reporter.log("KeyWord Entered is: "+keyword1+ " " +keyword2);
        //txtBox.sendKeys(Keys.ENTER);
        clickSubmit();
        Reporter.log("Search results are displayed.");
    }
    /**
     * With Fluent Interface and Selenium Page Factory
     * @throws InterruptedException
     */
    @Test
    public void LoginValidEmailPasswordTestByPageFactory() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmailToLogin("akansha.shukla@testpro.io")
                .providePasswordToLogin("te$t$tudent")
                .clickSubmitBtnToLogin();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    public void waitForAnElementToBeVisible(String cssLocator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
    }

}
