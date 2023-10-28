import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest{

    // Click the first song in the search results
    public void searchSong(String name) throws InterruptedException {
        WebElement searchField =driver.findElement(By.cssSelector("input[type='search']"));
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }
    public void clickViewAll() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[1]/h1/button"));
        viewAll.click();
        Thread.sleep(2000);
    }
    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/comment()[2]"));
        firstSong.click();
        Thread.sleep(2000);
    }
    public void clickAddToBottom() throws InterruptedException {
        WebElement addToBottom = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]"));
        addToBottom.click();
        Thread.sleep(2000);
    }
    public void choosePlayList() throws InterruptedException {
        WebElement myPlayList = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li.playlist"));
        myPlayList.click();
        Thread.sleep(2000);
    }
    public String getAddToPlayListSuccessMsg()  {
        WebElement notification = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]"));
        return notification.getText();

    }
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"MyPlayList\"";
        // Navigate to "https://qa.koel.app/"
        navigateToPage();
        // Log in with your credentials (replace 'your_username' and 'your_password' with your actual credentials)
        provideEmail("ramil.hasanli@testpro.io");
        providePassword("iutZVH7Q");
        clickSubmit();
        Thread.sleep(2000);
       searchSong("Episode 2");
       clickViewAll();
       selectFirstSongResult();
       clickAddToBottom();
       choosePlayList();
        Assert.assertEquals(getAddToPlayListSuccessMsg(), expectedSongAddedMessage );


    }
}
