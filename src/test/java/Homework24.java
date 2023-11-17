import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework24 extends BaseTest{
    @Test

    public void renamePlaylist() {
        String newPlaylistName = "Aaryav";
        String updatedPlaylistMsg = "Updated playlist \"Aaryav.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmailToLogin("akansha.shukla@testpro.io");
        loginPage.providePasswordToLogin("te$t$tudent");
        loginPage.clickSubmitBtnToLogin();
        homePage.doubleClickPlayList();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);

    }

}