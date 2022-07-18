package com.cydeo.seamlessly.pages;

import com.cydeo.seamlessly.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //-----locators on the dashboard page------


    @FindBy(xpath = "//div[@id='settings']")
    public WebElement avatarDiv;

    @FindBy(xpath = "//li[@data-id='logout']/a")
    public WebElement logoutLink;

    @FindBy (xpath = "//a[@class='user-status-menu-item__toggle']")
    public WebElement setStatusLink;

    @FindBy(xpath = "//li[@data-id='settings']/a")
    public WebElement settingsLink;


    /**
     *
     * @param module
     * @return
     * You should use "Dashboard", "Files", "Photos", "Activity", "Contacts", "Notes", "Deck", "Tasks" as a module parameter
     */
    public WebElement getModuleElement(String module){
        return Driver.getDriver().findElement(By.xpath("//a[@aria-label='"+module+"']"));

    }

}
