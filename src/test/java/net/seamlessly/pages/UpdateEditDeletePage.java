package net.seamlessly.pages;

import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UpdateEditDeletePage extends BasePage{

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li[2]")
    public WebElement fileIcon;

    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement plusIcon;

    @FindBy(id = "file_upload_start")
    public WebElement uploadFileSelection;

    public WebElement uploadedFileLocator(){
        String fileUploadPath = ConfigurationReader.getProperty("fileUploadPath");
        String fileName = fileUploadPath.substring(fileUploadPath.lastIndexOf("/")+1);
        return Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + fileName + "']"));
    }

    @FindBy(xpath = "//a[@data-templatename='New folder']")
    public WebElement newFolderSelection;

    @FindBy(xpath = "//input[@id='view11-input-folder']")
    public WebElement enterFileNameBox;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement rightArrwButton;

    public WebElement newFolderLocator(){
        String newFolderName = ConfigurationReader.getProperty("newFolderName");
        return Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + newFolderName + "']"));
    }






}
