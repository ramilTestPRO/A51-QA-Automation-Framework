
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;


public class LoginTests extends BaseTest {

    //Fluent interfaces example
       @Test
    public void loginValidEmailPassword () {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("ramil.hasanli@testpro.io")
                .providePassword("iutZVH7Q")
                .clickSubmit();

        Assert.assertTrue(homePage.isAvatarDisplayed());
    }


}