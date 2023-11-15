import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class Homework22 extends BaseTest{

    @Test
//            (dataProvider ="LoginData", dataProviderClass = BaseTest.class, enabled = true, priority = 0, description = "Login with provided email and password")

    public void renamePlaylist() {

        String newPlaylistName = "TestPro PlayList";
        String updatedPlaylistMsg = "Updated playlist\"TestPro PlayList.\"";
        LoginPage loginPage= new LoginPage(driver);
        HomePage homePage =new HomePage(driver);

        loginPage.login();
        homePage.chosePlaylistToRename();
        homePage.enterNewPlaylistName(newPlaylistName);

        Assert.assertEquals(homePage.isPlaylistRenamed(), updatedPlaylistMsg);


    }
}
