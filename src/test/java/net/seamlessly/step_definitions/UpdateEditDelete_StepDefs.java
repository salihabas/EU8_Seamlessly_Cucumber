package net.seamlessly.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.UpdateEditDeletePage;
import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;

public class UpdateEditDelete_StepDefs {

    UpdateEditDeletePage uedPage = new UpdateEditDeletePage();


    @When("user clicks files module")
    public void user_clicks_files_module() {
        //uedPage.fileIcon.click();
        uedPage.getModuleElement("Files").click();
    }

    @When("user clicks plus upload link")
    public void user_clicks_plus_upload_link() {
        uedPage.plusIcon.click();
    }

    @When("user clicks upload file selection")
    public void user_clicks_upload_file_selection() {
        System.out.println("ConfigurationReader.getProperty(\"fileUploadPath\") = " + ConfigurationReader.getProperty("fileUploadPath"));
        uedPage.uploadFileSelection.sendKeys(ConfigurationReader.getProperty("fileUploadPath"));
    }


    @Then("file successfully uploaded")
    public void file_successfully_uploaded() {
        Assert.assertTrue(uedPage.uploadedFileLocator().isDisplayed());

    }

}
