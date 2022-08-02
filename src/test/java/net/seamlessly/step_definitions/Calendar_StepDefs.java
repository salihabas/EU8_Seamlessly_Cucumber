package net.seamlessly.step_definitions;

import java.util.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.BasePage;
import net.seamlessly.pages.CalendarPage;
import net.seamlessly.pages.LoginPage;
import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Calendar_StepDefs {

    LoginPage loginPage = new LoginPage();
    CalendarPage calendarPage = new CalendarPage();
    WebElement selectedEvent;

    String time     = "7:00 PM";
    String endTime  = "9:00 PM";
    String date     = "2022-08-19";
    String anyEvent ="Alumni Meeting" ;
    String title  ;

    @When("User click on the calendar view dropdown menu")
    public void user_click_on_the_calendar_view_dropdown_menu() {
        calendarPage.dropdownMenu.click();
        BrowserUtils.waitFor(3);
    }

    @When("User click on {string} option")
    public void user_click_on_option(String time) {
        if (time.equalsIgnoreCase("day")){
            calendarPage.dayButton.click();
        }else if (time.equalsIgnoreCase("week")){
            calendarPage.weekButton.click();
        }else if (time.equalsIgnoreCase("month")){
            calendarPage.monthButton.click();
        }
    }

    @Then("User should see daily calendar view")
    public void user_should_see_daily_calendar_view() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("timeGridDay") );
    }

    @Then("User should see weekly calendar view")
    public void user_should_see_weekly_calendar_view() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("timeGridWeek") );
    }

    @Then("User should see monthly calendar view")
    public void user_should_see_monthly_calendar_view() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dayGridMonth") );
    }

    @When("User  select Monthly view calendar")
    public void user_select_monthly_view_calendar() {
        calendarPage.dropdownMenu.click();
        calendarPage.monthButton.click();
    }

    @When("User  click on New event button")
    public void user_click_on_New_event_button(){
        calendarPage.newEventButton.click();
    }

    @When("User  input {string} as a new event in placeholder")
    public void user_input_new_event_in_placeholder(String title) {
        this.title = title;
        calendarPage.eventTitle.sendKeys(title);
    }

    @When("User  select beginning time and date")
    public void user_select_beginning_time_and_date() {
        calendarPage.startTime.click();
        calendarPage.getHour(time.substring(0,1)).click();
        calendarPage.pm.click();
        calendarPage.pickDateButton.click();
        calendarPage.getPickDate(date).click();
        calendarPage.okButton.click();
    }

    @When("User  select ending time and date")
    public void user_select_ending_time_and_date() {
        calendarPage.endTime.click();
        BrowserUtils.waitFor(3);
        calendarPage.getHour(endTime.substring(0,1)).click();
        BrowserUtils.waitFor(3);
        calendarPage.okButton.click();
    }

    @When("User  click on Save  button")
    public void user_click_on_save_button() {
       calendarPage.saveButton.click();
    }

    @Then("User  should see new event on monthly calendar")
    public void user_should_see_new_event_on_monthly_calendar() {

        WebElement actualHour = calendarPage.getEventTime(date, time);
        Assert.assertEquals(time,actualHour.getText());

        WebElement actualTitle = calendarPage.getEventTitle(date,title);
        Assert.assertEquals(title,actualTitle.getText());
    }

    @When("User click {string} on the monthly calendar")
    public void user_click_any_event_on_the_monthly_calendar(String title) {
         selectedEvent = calendarPage.getEventLink(date,anyEvent);
         selectedEvent.click();
         BrowserUtils.waitFor(3);
    }

    @When("User click More button")
    public void user_click_more_button() {
         calendarPage.moreButton.click();
    }

    @When("User click tree dot dropdown menu")
    public void user_click_tree_dot_dropdown_menu() {
         calendarPage.sideBarDropdown.click();
    }

    @When("User click delete button")
    public void user_click_delete_button() {
         calendarPage.deleteButton.click();
    }

    @Then("User should see the event was erased")
    public void user_should_see_the_event_was_erased() {

          BrowserUtils.waitFor(3);
          calendarPage.checkStaleElementTrue(selectedEvent);
    }


}
