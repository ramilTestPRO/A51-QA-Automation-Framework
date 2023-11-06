package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    // locators
    By userAvatarIcon = By.cssSelector("img.avatar");

    // helpers
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

}
