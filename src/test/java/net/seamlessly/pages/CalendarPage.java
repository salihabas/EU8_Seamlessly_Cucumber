package net.seamlessly.pages;

import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class CalendarPage extends BasePage {

    @FindBy(xpath = "(//div[@class='action-item'])[1]")
    public WebElement dropdownMenu;

    @FindBy(xpath = "(//span[@class='action-button__text'])[9]")
    public WebElement dayButton;

    @FindBy(xpath = "(//span[@class='action-button__text'])[10]")
    public WebElement weekButton;

    @FindBy(xpath = "(//span[@class='action-button__text'])[11]")
    public WebElement monthButton;

    @FindBy(xpath = "//button[@class='button primary new-event']")
    public WebElement newEventButton;

    @FindBy(xpath = "//input[@placeholder='Event title']")
    public WebElement eventTitle;

    @FindBy(xpath = "(//input[@placeholder='Pick a date and a time'])[1]")
    public WebElement startTime;

    @FindBy(xpath = "(//input[@placeholder='Pick a date and a time'])[2]")
    public WebElement endTime;

    @FindBy(xpath = "//button[@class='mx-btn mx-btn-text']")
    public WebElement pickDateButton;

    @FindBy(xpath = "(//li[@data-index='0'])[3]")
    public WebElement am;

    @FindBy(xpath = "(//li[@data-index='1'])[3]")
    public WebElement pm;

    @FindBy(xpath = "//button[@class='mx-btn mx-datepicker-btn-confirm']")
    public WebElement okButton;

    @FindBy(xpath = "//button[@class='primary']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[normalize-space()='More']")
    public WebElement moreButton;

    @FindBy(xpath = "(//span[@class='material-design-icon dots-horizontal-icon'])[4]")
    public WebElement treeDotDropdown;

    @FindBy(xpath = "//span[text()='Delete']")
    public WebElement deleteButton;




    // return webelement as an hour from popup menü
    public WebElement getHour(String hour) {
        return Driver.getDriver().findElement(By.xpath("(//li[@data-index='" + hour + "'])[1]"));
    }

    // return webelement as a date from popup menü
    public WebElement getPickDate(String date) {
        return Driver.getDriver().findElement(By.xpath("//td[@title='" + date + "']"));
    }

    /*
    public WebElement getDate(String date) {
        return Driver.getDriver().findElement(By.xpath("//td[@data-date=" + date + "]"));
    }*/

    // return as a String for time . You should give date like "year-month-day"
    public WebElement getEventTime(String date,String time) {
     WebElement times =  Driver.getDriver().findElement(By.xpath("//td[@data-date='"+date+"']//div[text()='"+time+"']"));
      return times;
    }

    // return as a String for title . You should give date like "year-month-day"
    public WebElement getEventTitle(String date, String title ) {
       WebElement titles = Driver.getDriver().findElement(By.xpath("//td[@data-date='" + date + "']//div[text()='"+title +"']"));
       return titles;
    }

    // return webelement as a link of event
    public WebElement getEventLink (String date, String title){
        WebElement link = Driver.getDriver().findElement(By.xpath("//td[@data-date='"+ date+ "']" +
                "//a[@class='fc-daygrid-event fc-daygrid-dot-event fc-event fc-event-draggable fc-event-resizable fc-event-start fc-event-end fc-event-past']//div[text()='"+ title +"']"));
        return link;
    }

    /**
     * If Webelement is stale, this method will return true
     * @param staleElement
     */
    public void checkStaleElementTrue(WebElement staleElement){
        try{

            staleElement.getText();

        }catch (StaleElementReferenceException e){
            System.out.println("event erased");
            Assert.assertTrue(true);
        }

    }

}
