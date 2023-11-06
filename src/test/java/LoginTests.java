import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {


    @Test (enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailPassword(){

        LoginPage loginPage= new LoginPage(driver);
        HomePage homePage =new HomePage(driver);

        loginPage.provideEmail("ramil.hasanli@testpro.io");
        loginPage.providePassword("iutZVH7Q");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

}