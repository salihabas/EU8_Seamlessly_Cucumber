package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.DashBoardPage;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Logout_StepDefs {

    DashBoardPage dashBoardPage = new DashBoardPage();

    @When("user clicks avatar image")
    public void user_clicks_avatar_image() {

        dashBoardPage.avatarImage.click();

    }
    @When("user clicks Log out link")
    public void user_clicks_log_out_link() {

        dashBoardPage.logoutLink.click();

    }
    @Then("user can log out and see log in page")
    public void user_can_log_out_and_see_log_in_page() {

        Assert.assertEquals(Driver.getDriver().getTitle(), "Seamlessly -QA" );
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://qa.seamlessly.net/index.php/login"));
    }


    @When("user clicks step back button")
    public void user_clicks_step_back_button() {

        Driver.getDriver().navigate().back();
    }
    @Then("User can not go to dashboard page and stay log in page")
    public void user_can_not_go_to_dashboard_page_and_stay_log_in_page() {

        Assert.assertEquals(Driver.getDriver().getTitle(), "Seamlessly -QA" );
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://qa.seamlessly.net/index.php/login"));

    }


}
