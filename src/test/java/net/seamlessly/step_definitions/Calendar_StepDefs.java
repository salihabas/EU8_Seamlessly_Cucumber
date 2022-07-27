package net.seamlessly.step_definitions;

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

public class Calendar_StepDefs {

    LoginPage loginPage = new LoginPage();
    CalendarPage calendarPage = new CalendarPage();

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get("https://qa.seamlessly.net/");
        loginPage.userName.sendKeys("Employee32");
        loginPage.password.sendKeys("Employee123");
        loginPage.loginButton.click();
    }

    @When("User click on the calendar module")
    public void user_click_on_the_calendar_module() {
        BrowserUtils.waitForVisibility(calendarPage.getModuleElement("Calendar"),10);
        calendarPage.getModuleElement("Calendar").click();
    }

    @When("User click on the calendar view dropdown menu")
    public void user_click_on_the_calendar_view_dropdown_menu() {
        calendarPage.dropdownMenu.click();
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

    @When("User  click on {string} button")
    public void user_click_on_button(String string) {
        calendarPage.newEventButton.click();
    }

    @When("User  input new event in {string} placeholder")
    public void user_input_new_event_in_placeholder(String string) {
         calendarPage.eventTitle.sendKeys("Alumni Meeting");
    }

    @When("User  select beginning time and date")
    public void user_select_beginning_time_and_date() {
        calendarPage.startTime.click();
        calendarPage.getHour("7").click();
        calendarPage.pm.click();
        calendarPage.pickDateButton.click();
        calendarPage.okButton.click();
    }

    @When("User  select ending time and date")
    public void user_select_ending_time_and_date() {
       // calendarPage.endTime.click();
       // calendarPage.getHour("11").click();
       // BrowserUtils.waitForClickablility(calendarPage.okButton,10);
       // calendarPage.okButton.click();
    }

    @When("User  click on Save  button")
    public void user_click_on_save_button() {
       calendarPage.saveButton.click();
    }

    @Then("User  should see new event on monthly calendar")
    public void user_should_see_new_event_on_monthly_calendar() {
        String expectedTime = "7:00 PM";
        String actualTime = calendarPage.getTime("2022-07-19");
        Assert.assertEquals(expectedTime,actualTime);

        String expectedTitle = "Alumni Meeting";
        String actualTitle = calendarPage.getTitle("2022-07-19");
        Assert.assertEquals(expectedTitle,actualTitle);


    }

}
