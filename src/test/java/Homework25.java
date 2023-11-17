import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class Homework25 extends BaseTest{
@Test
public void renamePlaylist() {

    String newPlaylistName = "TestPro PlayList";

    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());

    loginPage.provideEmail("ramil.hasanli@testpro.io")
            .providePassword("iutZVH7Q")
            .clickSubmit();
    homePage.doubleClickPlaylist();
    homePage.enterNewPlaylistName(newPlaylistName);

    Assert.assertEquals(homePage.getPlaylistName(), newPlaylistName);
}
}