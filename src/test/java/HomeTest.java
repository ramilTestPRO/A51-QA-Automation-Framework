import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;


public class HomeTest extends BaseTest{

    @Test (dataProvider ="LoginData", dataProviderClass = BaseTest.class,
           enabled = true, priority = 0, description = "Login with provided email and password")

    public void renamePlaylist() {

        HomePage homePage =new HomePage(driver);

        homePage.chosePlaylistToRename();
        homePage.clickOnEdit();
        homePage.clearOldName();
        homePage.typeNewName();

        Assert.assertTrue(homePage.isPlaylistRenamed().isDisplayed());
    }

    @Test
    public void playSong(){
        LoginPage loginPage=new LoginPage(driver);
        HomePage homePage=new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        //Login


    }
}
