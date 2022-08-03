package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.ContactsPage;
import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class Contacts_StepDefs {

    ContactsPage contactsPage = new ContactsPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10, 1000);
    Actions action = new Actions(Driver.getDriver());

    int totalContactsNumber;
    WebElement selectedWebElement;
    String imageName;
    int randomElementIndex;


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

    @And("user enters {string} as name")
    public void userEntersAsName(String name) {
        BrowserUtils.waitFor(2);
        //String script = "arguments[0].value='"+name+"'";
       // ((JavascriptExecutor) Driver.getDriver()).executeScript(script, contactsPage.newContactNameValue);
        action.doubleClick(contactsPage.newContactNameValue).pause(100)
                .sendKeys(contactsPage.newContactNameValue, name).pause(100).build().perform();

        BrowserUtils.waitFor(1);


    }
    @When("user enters {string} as company name")
    public void user_enters_company_name(String companyName){

        action.sendKeys(contactsPage.companyName, companyName).pause(100).perform();


    }
    @When("user enters {string}")
    public void user_enters(String title) {

        action.sendKeys(contactsPage.title, title).pause(100).perform();
        BrowserUtils.waitFor(1);
    }
    @Then("user sees {string} in the middle column")
    public void user_sees_in_the_middle_column_and_doesn_t_see_upper_arrow(String companyName) {

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//span[text()='"+companyName+"']")).isDisplayed());

    }


    @And("user hovers on exclamation mark and sees the message")
    public void userHoversOnExclamationMarkAndSeesTheMessage() {
        action.moveToElement(contactsPage.exclamationMarkIcon).pause(1).perform();
        Assert.assertEquals("false", contactsPage.failMessageContainer.getAttribute("aria-hidden"));
        Assert.assertTrue(contactsPage.failMessageText.isDisplayed());


    }

    @And("user refresh the page")
    public void userRefreshThePage() {
        Driver.getDriver().navigate().refresh();
    }

    @Then("user doesn't see New contact in the middle column")
    public void userDoesnTSeeNewContactInTheMiddleColumn() {

        List <WebElement> listOfNewContact = Driver.getDriver().findElements(By.xpath("//span[text()='New contact']"));

        Assert.assertEquals(0, listOfNewContact.size());
    }

    @When("user can see all contacts in the middle column")
    public void userCanSeeAllContactsInTheMiddleColumn() {
        Assert.assertEquals(contactsPage.contactTotalNumber.getText(), String.valueOf(contactsPage.contactList.size()));

    }

    @Then("user can see total number of contact near the contact categories")
    public void userCanSeeTotalNumberOfContactNearTheContactCategories() {

        Assert.assertTrue(contactsPage.contactTotalNumber.isDisplayed());
    }

    @When("user clicks any contact middle column")
    public void userClicksAnyContactMiddleColumn() {

        totalContactsNumber = Integer.valueOf(contactsPage.contactTotalNumber.getText());
        randomElementIndex = new Random().nextInt(contactsPage.contactList.size());
        selectedWebElement = contactsPage.contactList.get(randomElementIndex);
        selectedWebElement.click();
    }

    @And("user clicks on three-dot icon")
    public void userClicksOnThreeDotIcon() {
        contactsPage.threeDotButton.click();
    }

    @And("user clicks delete option")
    public void userClicksDeleteOption() {
        contactsPage.deleteContactButton.click();
    }

    @Then("user can delete selected contact")
    public void userCanDeleteSelectedContact() {

        BrowserUtils.waitFor(3);
        Assert.assertEquals((Integer)(totalContactsNumber-1), Integer.valueOf(contactsPage.contactTotalNumber.getText()));
        Assert.assertEquals((totalContactsNumber-1), contactsPage.contactList.size());

        contactsPage.checkStaleElementTrue(selectedWebElement);

    }

    @And("user clicks on image icon")
    public void userClicksOnImageIcon() {
        contactsPage.addImageIconButton.click();

    }

    @And("user clicks choose from files option")
    public void userClicksChooseFromFilesOption() {
        contactsPage.chooseFromFileButton.click();

    }

    @And("user selects a image")
    public void userSelectsMyFolderAndAImage() {

        contactsPage.imageUnderMyFolder.click();
        contactsPage.chooseButtonForImage.click();
        BrowserUtils.waitFor(5);

        contactsPage.contactList.get(contactsPage.differentRandomIndex(randomElementIndex)).click();
        BrowserUtils.waitFor(3);
        selectedWebElement.click();

    }

    @Then("user can see selected avatar image for the contact")
    public void userCanSeeSelectedAvatarImageForTheContact() {

        Assert.assertTrue(contactsPage.avatarImageForContact.isDisplayed());
    }


}
