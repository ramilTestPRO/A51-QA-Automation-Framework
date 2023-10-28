import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest{

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
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }
    public void clickAddToButton() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]"));
        addToButton.click();
        Thread.sleep(2000);
    }
    public void choosePlayList() throws InterruptedException {
        WebElement myPlayList = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/section[1]/section[11]/header/div[3]/div/section[1]/ul/li[5]"));
        myPlayList.click();
        Thread.sleep(3000);
    }
    public String getAddToPlayListSuccessMsg()  {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show")); //css body > div.alertify-logs.top.right>div.success.show //xpath /html/body/div[4]/div
        return notification.getText();


    }
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"MyPlayList.\"";
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
       clickAddToButton();
       choosePlayList();
        Assert.assertEquals(getAddToPlayListSuccessMsg(), expectedSongAddedMessage );
        //driver.wait();


    }
}
