import org.testng.Assert;
import org.testng.annotations.Test;
import page_factory.LoginPage;
import pages.HomePage;

public class LoginTests extends BaseTest {


    @Test (enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailPassword(){

        page_factory.LoginPage loginPage= new LoginPage(driver);


        loginPage.provideEmail("ramil.hasanli@testpro.io");
        loginPage.providePassword("iutZVH7Q");
        loginPage.clickSubmit();

    }

}