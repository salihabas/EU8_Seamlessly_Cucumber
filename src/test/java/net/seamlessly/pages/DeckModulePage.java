package net.seamlessly.pages;

import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DeckModulePage extends BasePage{
    public DeckModulePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@aria-controls='app-navigation-vue']")
    public WebElement toggleButton;

    @FindBy(xpath = "//div[@id='app-navigation-vue']//a[@href='#']")
    public WebElement addBoard;

    @FindBy(xpath = "//input[@placeholder='Board name']")
    public WebElement boardNameInputBox;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement confirmIcon;

    @FindBy(xpath = "//ul[@class='app-navigation-entry__children']//span[@title]")
    public WebElement referanceOfBoardList;
    public void checkcreatedBoard (String boardName){

        List<WebElement> boardList = Driver.getDriver().findElements(By.xpath("//ul[@class='app-navigation-entry__children']//span[@title]"));

        int count = 0;
        for (WebElement eachBoard : boardList) {
            if (eachBoard.getAttribute("title").equals(boardName)){
                count++;
            }
        }
        Assert.assertTrue(count>0);



    }

}
