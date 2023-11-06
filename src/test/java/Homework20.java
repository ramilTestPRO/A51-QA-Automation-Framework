import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework20 extends BaseTest{

    public void chosePlaylistToDelete()  { //throws InterruptedException
        WebElement choseMyPlaylistToDelete =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a")));
        choseMyPlaylistToDelete.click();
//        Thread.sleep(2000);

    }
    public void deletePlaylist()  { //throws InterruptedException
        WebElement redButtonXPlaylist =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button")));
        redButtonXPlaylist.click();
//        Thread.sleep(2000);

    }
          public void isPlaylistDeleted()  {
        WebElement isMyPlaylistDeleted = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
           Assert.assertTrue(isMyPlaylistDeleted.isDisplayed());
    }
    @Test (dataProvider ="LoginData", dataProviderClass = BaseTest.class,
           enabled = true, priority = 0, description = "Login with provided email and password")
    // test logic here, using 'email' and 'password' for login
    public void deleteAndConfirm(String email, String password) throws InterruptedException {
        String expectedPlaylistDeletedMessage = "Deleted playlist \"MyPlayList.\"";
        // Navigate to "https://qa.koel.app/"
        navigateToPage();
        // Log in with your credentials (replace 'your_username' and 'your_password' with your actual credentials)
        provideEmail(email);
        providePassword(password);
        //provideEmail("ramil.hasanli@testpro.io");
        //providePassword("iutZVH7Q");
        clickSubmit();
//        Thread.sleep(2000);
        chosePlaylistToDelete();
        deletePlaylist();
        isPlaylistDeleted();
        //driver.wait();


    }
}
