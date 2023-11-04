import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeTest extends BaseTest{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      public void playSongWithContext(){
          // login
          provideEmail("ramil.hasanli@testpro.io");
          providePassword("iutZVH7Q");
          clickSubmit();
          //chose all songs list
          chooseAllSongsList();
          //right/context click
          contextClickFirstSong();
          //choose play
          choosePlayOption();
          //Assertion

    }
    public void chooseAllSongsList(){
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
    public void contextClickFirstSong(){

    }
    public void choosePlayOption(){

    }
}
