package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //String txtFieldEmail = "input[type='email']"; // one of the way to set it up

    //Location using Selenium Page Factory
    @FindBy (css = "input[type='email']") //same as String txtFieldEmail = "input[type='email']"; // one of the way to set it up
    WebElement emailTxtField;
    @FindBy (css = "input[type='password']")
    WebElement passwordTxtField;
    @FindBy(css = "button[type='submit']")
    WebElement submitLoginButton;


    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    public  void providePassword (String password){
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit(){
        findElement(submitBtn).click();
    }
    public void login(){
        provideEmail("ramil.hasanli@testpro.io");
        providePassword("iutZVH7Q");
        clickSubmit();
    }

    // Helper Methods using Page Factory
    public  void provideEmailToLogin (String email){
        emailTxtField.sendKeys(email);
    }
    public  void providePasswordToLogin ( String password){
        passwordTxtField.sendKeys(password);
    }

    public  void submitLoginBtn(){
        submitLoginButton.click();
    }
}
