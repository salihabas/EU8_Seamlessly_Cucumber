package net.seamlessly.pages;

import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.apache.hc.client5.http.impl.auth.UnsupportedDigestAlgorithmException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UpdateEditDeletePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li[2]")
    public WebElement fileIcon;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement plusIcon;

    @FindBy(id = "file_upload_start")
    public WebElement uploadFileSelection;

    public WebElement uploadedFileLocator() {
        String fileUploadPath = ConfigurationReader.getProperty("fileUploadPath");
        String fileName = fileUploadPath.substring(fileUploadPath.lastIndexOf("/") + 1);
        return Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + fileName + "']"));
    }

    @FindBy(xpath = "//a[@data-templatename='New folder']")
    public WebElement newFolderSelection;

    @FindBy(xpath = "//input[@id='view11-input-folder']")
    public WebElement enterFileNameBox;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement rightArrwButton;

    public WebElement mainFolderLocator() {
        String MainFolderName = ConfigurationReader.getProperty("MainFolderName");
        return Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + MainFolderName + "']"));
    }

    @FindBy(xpath = "//*[@id=\"fileList\"]/tr[2]/td[2]/a/span[3]/a[2]")
    public WebElement secondThreeDot;

    @FindBy(xpath = "//a[@class='menuitem action action-movecopy permanent']")
    public WebElement moveOrCopySelection;

    public WebElement targetFolderLocator() {
        String MainFolderName = ConfigurationReader.getProperty("MainFolderName");
        return Driver.getDriver().findElement(By.xpath("//tr[@data-entryname='" + MainFolderName + "']"));
    }

    @FindBy(xpath = "//button[@class='primary']")
    public WebElement moveToMainFolderButton;

    public WebElement movingFolderLocator() {
        String MovingFolderName = ConfigurationReader.getProperty("MovingFolderName");
        return Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + MovingFolderName + "']"));
    }

    @FindBy(xpath = "//a[@class='icon-home']")
    public WebElement homeButton;

    @FindBy(xpath = "//*[@id=\"oc-dialog-filepicker-content\"]/span/div")
    public WebElement littleHomeButton;

    @FindBy(xpath = "//span[.='MainFolder']")
    public WebElement browseMainFolder;

    public void waitForNotStaled() {
        while (true) {

            try {
                movingFolderLocator().isDisplayed();
                System.out.println("Geçti...");
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("Bekliyor...");
                BrowserUtils.waitFor(1);
            }

            }
        }

    }
