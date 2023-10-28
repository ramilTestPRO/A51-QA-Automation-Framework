import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {



       // @Test (dataProvider = "LoginData" )




    @Test (enabled = true, priority = 2, description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPassword() throws InterruptedException {

        navigateToPage(url);
        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }

    @Test (enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailPassword(){

        navigateToPage(url);
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        isAvatarDisplayed();
    }

    @Test (enabled = true, priority = 3, description = "Login with valid email and empty password")
    public void loginValidEmailEmptyPassword() throws InterruptedException {

        navigateToPage(url);
        provideEmail("demo@class.com");
        providePassword("");
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }

}