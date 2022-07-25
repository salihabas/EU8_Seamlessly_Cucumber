package net.seamlessly.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CalendarPage extends BasePage{


    @FindBy(xpath = "(//div[@class='action-item'])[1]")
    public WebElement dropdownMenu;

    @FindBy(xpath = "(//span[@class='action-button__text'])[9]")
    public WebElement dayButton;

}
