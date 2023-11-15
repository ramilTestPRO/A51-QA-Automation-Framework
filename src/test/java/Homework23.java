import org.testng.Assert;
import org.testng.annotations.Test;
import page_factory.HomePage;
import page_factory.LoginPage;


public class Homework23 extends BaseTest{

    @Test

    public void renamePlaylist() {

        String newPlaylistName = "TestPro PlayList";
        String updatedPlaylistMsg = "TestPro PlayList";
        page_factory.LoginPage loginPage= new LoginPage(driver);
        HomePage homePage =new page_factory.HomePage(driver);

        loginPage.provideEmail("ramil.hasanli@testpro.io");
        loginPage.providePassword("iutZVH7Q");
        loginPage.clickSubmit();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);

        Assert.assertEquals(homePage.getPlaylistName(), newPlaylistName);


    }
}
