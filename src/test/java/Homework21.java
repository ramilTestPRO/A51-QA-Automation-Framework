import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework21 extends BaseTest{

    public void chosePlaylistToRename()  {
        WebElement choseMyPlaylistToRename =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a")));
        choseMyPlaylistToRename.click();
        actions.contextClick(choseMyPlaylistToRename).perform();
           }
    public void clickOnEdit()  {
        WebElement clickEdit =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/nav/ul/li[1]")));
        clickEdit.click();
    }
    public void clearOldName()  {
        WebElement textField = wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector(" [name = 'name']"))));
        textField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));

    }
public void typeNewName(){
        WebElement newName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(" [name = 'name']")));
        newName.sendKeys("MyNewPlayList", Keys.ENTER);
}
          public void isPlaylistRenamed()  {
        WebElement isMyPlaylistRenamed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
           Assert.assertTrue(isMyPlaylistRenamed.isDisplayed());
    }
    @Test (dataProvider ="LoginData", dataProviderClass = BaseTest.class,
           enabled = true, priority = 0, description = "Login with provided email and password")
    // test logic here, using 'email' and 'password' for login
    public void renamePlaylist(String email, String password) {
        String expectedPlaylistRenameMessage = "Updated playlist \"MyNewPlayList.\"";
        // Navigate to "https://qa.koel.app/"
        navigateToPage();
        // Log in with your credentials (replace 'your_username' and 'your_password' with your actual credentials)
        provideEmail(email);
        providePassword(password);
        //provideEmail("ramil.hasanli@testpro.io");
        //providePassword("iutZVH7Q");
        clickSubmit();
//        Thread.sleep(2000);
        chosePlaylistToRename();
        clickOnEdit();
        clearOldName();
        typeNewName();
        isPlaylistRenamed();
        //driver.wait();


    }
}
