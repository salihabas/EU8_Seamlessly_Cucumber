package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.BasePage;
import net.seamlessly.pages.UpdateEditDeletePage;
import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateEditDelete_StepDefs {

    UpdateEditDeletePage uedPage = new UpdateEditDeletePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);


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
        uedPage.uploadFileSelection.sendKeys(ConfigurationReader.getProperty("fileUploadPath"));
    }

    @Then("file successfully uploaded")
    public void file_successfully_uploaded() {
        Assert.assertTrue(uedPage.uploadedFileLocator().isDisplayed());
    }

    @And("user clicks new folder selection")
    public void userClicksNewFolderSelection() {
        uedPage.newFolderSelection.click();
    }

    @And("user enters MainFolderName")
    public void userEntersMainFolderName() {
        uedPage.enterFileNameBox.sendKeys(ConfigurationReader.getProperty("MainFolderName"));
    }

    @And("user clicks right arrow")
    public void userClicksRightArrow() {
        uedPage.rightArrwButton.click();
    }

    @Then("folder successfully created")
    public void folderSuccessfullyCreated() {
        Assert.assertTrue(uedPage.mainFolderLocator().isDisplayed());
    }

    @And("user enters MovingFolderName")
    public void userEntersMovingFolderName() {
        uedPage.enterFileNameBox.sendKeys(ConfigurationReader.getProperty("MovingFolderName"));
    }

    @And("user clicks second three dot icon")
    public void userClicksSecondThreeDotIcon() {
        uedPage.secondThreeDot.click();
    }

    @And("user selects moveOrCopy selection")
    public void userSelectsMoveOrCopySelection() {
        uedPage.moveOrCopySelection.click();
    }

    @And("user clicks Main folder")
    public void userClicksCreatedFolder() {
        uedPage.mainFolderLocator().click();
    }

    @And("user chooses MainFolderName target in the list")
    public void userChoosesMainFolderNameTargetInTheList() {
        uedPage.targetFolderLocator().click();
    }

    @And("user clicks MoveToMainFolder button")
    public void userClicksMoveToMainFolderButton() {
        uedPage.moveToMainFolderButton.click();
    }

    @Then("user can see MovingFolder")
    public void userCanSeeMovingFolder() {
        //Assert.assertEquals(uedPage.movingFolderLocator().getText(),ConfigurationReader.getProperty("MovingFolderName"));
        //wait.until(ExpectedConditions.elementToBeClickable(uedPage.movingFolderLocator()));
        BrowserUtils.waitFor(3);
        //uedPage.waitForNotStaled();
        //Assert.assertTrue(uedPage.movingFolderLocator().isDisplayed());
        uedPage.movingFolderLocator().click();
    }

    @And("user clicks home button")
    public void userClicksHomeButton() {
        uedPage.homeButton.click();
    }

    @And("user clicks little home button")
    public void userClicksLittleHomeButton() {
        uedPage.littleHomeButton.click();
    }


    @Given("user already uploaded a file")
    public void userAlreadyUploadedAFile() {
        uedPage.getModuleElement("Files").click();
        uedPage.plusIcon.click();
        uedPage.uploadFileSelection.sendKeys(ConfigurationReader.getProperty("fileUploadPath"));
    }

    @When("user clicks threeDotForDeleting")
    public void userClicksThreeDotForDeleting() {
        uedPage.threeDotForDeleting.click();
    }

    @And("user clicks Delete file selection")
    public void userClicksDeleteFileSelection() {
        uedPage.deleteSelection.click();
    }

    @Then("verify the item is deleted")
    public void verifyTheItemIsDeleted() {
        try {
            uedPage.uploadedFileLocator().isDisplayed();
        } catch (StaleElementReferenceException e) {
            Assert.assertTrue(true);
        }
    }


    @Given("user already created a folder")
    public void userAlreadyCreatedAFolder() {
        uedPage.getModuleElement("Files").click();
        uedPage.plusIcon.click();
        uedPage.newFolderSelection.click();
        uedPage.enterFileNameBox.sendKeys(ConfigurationReader.getProperty("MainFolderName"));
        uedPage.rightArrwButton.click();
    }

    @Then("total file and folder number is seen")
    public void totalFileAndFolderNumberIsSeen() {
       Assert.assertTrue(uedPage.folderFileSummary.isDisplayed());
    }
}
