package com.cydeo.seamlessly.pages;

import com.cydeo.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy (id = "submit-form")
    public WebElement loginButton;

    @FindBy (xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement wrongCredentialMessage;

    @FindBy (xpath = "//a[@class='toggle-password']")
    public WebElement eyeIconforPassword;

    @FindBy (id = "lost-password")
    public WebElement forgotPasswordLink;

    @FindBy (id = "reset-password-submit")
    public WebElement resetPasswordButton;



    public void inputValidationMessageCheck(String message){

         if (message.equals("Please fill out this field.") || message.equals("This is a required field")) {
             Assert.assertTrue(true);
         } else {
             Assert.assertTrue(false);
         }
    }

}
