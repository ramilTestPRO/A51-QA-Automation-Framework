import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

public class LoginTests extends BaseTest {

    @Test (enabled = false, priority = 2, description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPassword() throws InterruptedException {

        navigateToPage();
        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

//        Thread.sleep(2000);

        wait.until(ExpectedConditions.urlToBe(url));
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }

    @Test (enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailPassword(){

        navigateToPage();
        provideEmail("ramil.hasanli@testpro.io");
        providePassword("iutZVH7Q");
        clickSubmit();
        isAvatarDisplayed();

        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }

    @Test (enabled = false, priority = 3, description = "Login with valid email and empty password")
    public void loginValidEmailEmptyPassword() throws InterruptedException {

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("");
        clickSubmit();
//        Thread.sleep(2000);
        wait.until(ExpectedConditions.urlToBe(url));
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }

}