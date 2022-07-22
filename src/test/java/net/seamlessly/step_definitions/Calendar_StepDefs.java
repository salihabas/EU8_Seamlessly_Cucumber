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
    public void user_click_on_option(String day) {
            calendarPage.dayButton.click();
    }
    @Then("User should see daily calendar view")
    public void user_should_see_daily_calendar_view() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("timeGridDay") );
    }

}
