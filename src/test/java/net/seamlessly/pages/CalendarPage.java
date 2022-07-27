package net.seamlessly.pages;

import net.seamlessly.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    public WebElement getHour(String hour) {
        return Driver.getDriver().findElement(By.xpath("(//li[@data-index='" + hour + "'])[1]"));
    }


    public WebElement getPickDate(String date) {
        return Driver.getDriver().findElement(By.xpath("//td[@title='" + date + "']"));
    }

    public WebElement getDate(String date) {
        return Driver.getDriver().findElement(By.xpath("//td[@data-date=" + date + "]"));
    }

    // return as a web element for last time . You should give date like "year-month-day"
    public String getTime(String date) {
        List<WebElement> times = Driver.getDriver().findElements(By.xpath("//td[@data-date='" + date + "']//div[@class='fc-daygrid-event-harness']//div[@class='fc-event-time']"));
        return times.get(times.size()-1).getText();
    }

    // return as a web element for last title . You should give date like "year-month-day"
    public String getTitle(String date) {
        List<WebElement> titles = Driver.getDriver().findElements(By.xpath("//td[@data-date='" + date + "']//div[@class='fc-daygrid-event-harness']//div[@class='fc-event-title']"));
        return titles.get(titles.size()-1).getText();
    }

}
