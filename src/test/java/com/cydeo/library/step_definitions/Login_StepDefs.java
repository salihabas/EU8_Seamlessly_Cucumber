package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefs {

    LoginPage loginPage = new LoginPage();
    String username;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("https://qa.seamlessly.net/index.php/login");
    }
    @When("user enters {string} as a username")
    public void user_enters_as_a_username(String username) {
        this.username = username;
        loginPage.userName.sendKeys(username);
    }
    @When("user enters {string} as a password")
    public void user_enters_as_a_password(String password) {
        loginPage.password.sendKeys(password);
    }
    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }
    @Then("user can logged in")
    public void user_can_logged_in() {
       // Assert.assertTrue(dashBoardPage.avatarImage.getAttribute("src").toLowerCase().contains(username.toLowerCase()));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://qa.seamlessly.net/index.php/apps"));
    }

    @Then("user cannot logged in with invalid username")
    public void user_cannot_logged_in_with_invalid_username() {

        Assert.assertEquals("Wrong username or password.", loginPage.wrongCredentialMessage.getText());
    }

    @Then("user cannot logged in with absent username")
    public void user_cannot_logged_in_with_absent_username() {
       // System.out.println(loginPage.userName.getAttribute("required"));
        Assert.assertTrue(loginPage.userName.getAttribute("required").equalsIgnoreCase("true"));

        loginPage.inputValidationMessageCheck(loginPage.userName.getAttribute("validationMessage"));
    }

    @Then("user cannot logged in with absent password")
    public void user_cannot_logged_in_with_absent_password() {
       // System.out.println(loginPage.userName.getAttribute("required"));
        Assert.assertTrue(loginPage.password.getAttribute("required").equalsIgnoreCase("true"));

        loginPage.inputValidationMessageCheck(loginPage.password.getAttribute("validationMessage"));

    }

    @Then("User can see the password in a form of dots")
    public void user_can_see_the_password_in_a_form_of_dots() {
       Assert.assertTrue(loginPage.password.getAttribute("type").equalsIgnoreCase("password"));

    }

    @When("user clicks eye icon inside the password section")
    public void user_clicks_eye_icon_inside_the_password_section() {
        loginPage.eyeIconforPassword.click();

    }
    @Then("User can see the password explicitly")
    public void user_can_see_the_password_explicitly() {
        Assert.assertTrue(loginPage.password.getAttribute("type").equalsIgnoreCase("text"));

    }

    @When("User can see the Forgot password link")
    public void user_can_see_the_forgot_password_link() {

        Assert.assertEquals(loginPage.forgotPasswordLink.getText(), "Forgot password?");
    }
    @When("User clicks Forgot password? link")
    public void user_clicks_forgot_password_link() {

        loginPage.forgotPasswordLink.click();

    }
    @Then("User can see Reset password button")
    public void user_can_see_reset_password_button() {

        System.out.println(loginPage.resetPasswordButton.getAttribute("value"));
        Assert.assertEquals(loginPage.resetPasswordButton.getAttribute("value"), "Reset password");

    }

    @Then("User can see valid placeholders on Username and Password fields")
    public void user_can_see_valid_placeholders_on_username_and_password_fields() {

        Assert.assertEquals(loginPage.userName.getAttribute("placeholder"), "Username or email");
        Assert.assertEquals(loginPage.password.getAttribute("placeholder"), "Password");

    }



}
