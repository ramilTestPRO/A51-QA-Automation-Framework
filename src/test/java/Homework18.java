import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest{

    public void playNextSong() throws InterruptedException {
        WebElement playNextButton =driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/i[2]"));
        playNextButton.click();
        Thread.sleep(2000);

    }
    public void playSongButton() throws InterruptedException {
        WebElement playButton =driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/span/span[2]"));
        playButton.click();
        Thread.sleep(2000);

    }
       public void isSoundBarDisplayed()  {
        WebElement soundBarDisplayed = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[2]/div[2]/div/button[1]/div/img"));
           Assert.assertTrue(soundBarDisplayed.isDisplayed());
    }
    @Test
    public void playSong() throws InterruptedException {
        // Navigate to "https://qa.koel.app/"
        navigateToPage();
        // Log in with your credentials (replace 'your_username' and 'your_password' with your actual credentials)
        provideEmail("ramil.hasanli@testpro.io");
        providePassword("iutZVH7Q");
        clickSubmit();
        Thread.sleep(2000);
        playNextSong();
        playSongButton();
        isSoundBarDisplayed();
        //driver.wait();


    }
}
