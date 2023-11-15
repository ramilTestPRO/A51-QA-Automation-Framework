package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
public class HomePage extends BasePage{
        public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    By myPlayList = By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a");
//    By clickEdit = By.xpath("//*[@id=\"playlists\"]/ul/li[3]/nav/ul/li[1]");
    By textField = By.cssSelector(" [name = 'name']");
//    By newName = By.cssSelector(" [name = 'name']");
    By playlistRenamedMsg = By.cssSelector("div.success.show");
    public void chosePlaylistToRename()  {
        doubleClick(myPlayList);
    }

//    public void clickOnEdit()  {
//        findElement(clickEdit).click();
//    }

    public void enterNewPlaylistName(String playlistNewName)  {
       findElement (textField).sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        findElement(textField).sendKeys(playlistNewName);
        findElement(textField).sendKeys(Keys.ENTER);
    }


    public String isPlaylistRenamed()  {
        return findElement(playlistRenamedMsg).getText();
           }





    By userAvatarIcon = By.cssSelector("img.avatar");
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
}
