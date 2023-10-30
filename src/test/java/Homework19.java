import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework19 extends BaseTest{

    public void chosePlaylistToDelete() throws InterruptedException {
        WebElement choseMyPlaylistToDelete =driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        choseMyPlaylistToDelete.click();
        Thread.sleep(2000);

    }
    public void deletePlaylist() throws InterruptedException {
        WebElement redButtonXPlaylist =driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button"));
        redButtonXPlaylist.click();
        Thread.sleep(2000);

    }
          public void isPlaylistDeleted()  {
        WebElement isMyPlaylistDeleted = driver.findElement(By.cssSelector("div.success.show"));
           Assert.assertTrue(isMyPlaylistDeleted.isDisplayed());
    }
    @Test //(dataProvider ="LoginData", dataProviderClass = BaseTest.class,
           // enabled = true, priority = 0, description = "Login with provided email and password")
    public void deleteAndConfirm() throws InterruptedException {
        String expectedPlaylistDeletedMessage = "Deleted playlist \"MyPlayList.\"";
        // Navigate to "https://qa.koel.app/"
        navigateToPage();
        // Log in with your credentials (replace 'your_username' and 'your_password' with your actual credentials)

        provideEmail("ramil.hasanli@testpro.io");
        providePassword("iutZVH7Q");
        clickSubmit();
        Thread.sleep(2000);
        chosePlaylistToDelete();
        deletePlaylist();
        isPlaylistDeleted();
        //driver.wait();


    }
}
