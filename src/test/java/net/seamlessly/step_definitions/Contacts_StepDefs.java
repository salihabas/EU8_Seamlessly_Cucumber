package net.seamlessly.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.ContactsPage;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Contacts_StepDefs {

    ContactsPage contactsPage = new ContactsPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    Actions action = new Actions(Driver.getDriver());

    @Given("user clicks contacts link and user on the contacts page")
    public void user_clicks_contacts_link_and_user_on_the_contacts_page() {
       contactsPage.getModuleElement("Contacts").click();

    }
    @When("user clicks +New contact button")
    public void user_clicks_new_contact_button() {

        contactsPage.newContactButton.click();
    }
    @When("user see New contact form and exclamation mark")
    public void user_see_new_contact_form_and_exclamation_mark() {

        Assert.assertEquals(contactsPage.newContactNameValue.getAttribute("value"), "New contact");
        Assert.assertTrue(contactsPage.exclamationMarkIcon.isDisplayed());

    }
    @When("user enters {string} and sees changed company name")
    public void user_enters_and_sees_changed_company_name(String companyName) {

        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(contactsPage.companyName, companyName).pause(1).perform();

        wait.until(ExpectedConditions.attributeContains(contactsPage.newContactNameValue, "value", companyName));
        Assert.assertEquals(contactsPage.newContactNameValue.getAttribute("value"), companyName);
        wait.until(ExpectedConditions.visibilityOf(contactsPage.upperArrowIcon));
        Assert.assertTrue(contactsPage.upperArrowIcon.isDisplayed());

    }
    @When("user enters {string}")
    public void user_enters(String title) {

        action.sendKeys(contactsPage.title, title).pause(1).perform();


    }
    @Then("user sees {string} in the middle column")
    public void user_sees_in_the_middle_column_and_doesn_t_see_upper_arrow(String companyName) {

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//span[text()='"+companyName+"']")).isDisplayed());

    }
}
