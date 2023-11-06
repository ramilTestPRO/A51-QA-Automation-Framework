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
    public void chosePlaylistToRename()  {
        actions.contextClick(findElement(myPlayList)).perform();
    }
    By clickEdit = By.xpath("//*[@id=\"playlists\"]/ul/li[3]/nav/ul/li[1]");
    public void clickOnEdit()  {
        findElement(clickEdit).click();
    }
By textField = By.cssSelector(" [name = 'name']");
    public void clearOldName()  {
       findElement (textField).sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
    }
    By newName = By.cssSelector(" [name = 'name']");
    public void typeNewName(){
        findElement(newName).sendKeys("MyNewPlayList", Keys.ENTER);
    }
By playlistRenamed = By.cssSelector("div.success.show");
    public WebElement isPlaylistRenamed()  {
        return findElement(playlistRenamed);
           }


    By userAvatarIcon = By.cssSelector("img.avatar");
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
}
