package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    public DashBoardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//img[@width='32']")
    public WebElement avatarImage;


    @FindBy(xpath = "//div[@id='settings']")
    public WebElement avatarDiv;

    @FindBy(xpath = "//li[@data-id='logout']/a")
    public WebElement logoutLink;
}
