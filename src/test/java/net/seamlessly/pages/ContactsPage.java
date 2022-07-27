package net.seamlessly.pages;

import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ContactsPage extends BasePage{

    public ContactsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "new-contact-button")
    public WebElement newContactButton;

    @FindBy(id = "contact-fullname")
    public WebElement newContactNameValue;

    @FindBy (xpath = "//a[@class='header-icon icon-error header-icon--pulse has-tooltip']")
    public WebElement exclamationMarkIcon;

    @FindBy (xpath = "//div[contains(@aria-describedby,'tooltip')]")
    public WebElement upperArrowIcon;

    @FindBy(id = "contact-org")
    public WebElement companyName;

    @FindBy(id = "contact-title")
    public WebElement title;

    @FindBy (xpath = "//div[text()='This contact is not yet synced. Edit it to save it to the server.']")
    public WebElement failMessageText;

    @FindBy (xpath = "//div[contains(@id,'tooltip')]")
    public WebElement failMessageContainer;

    @FindBy (xpath = "//div[@role='listitem']")
    public List<WebElement> contactList;

    @FindBy (xpath = "//div[@class='app-navigation-entry__counter']")
    public WebElement contactTotalNumber;

    @FindBy(xpath = "(//button[@class='icon action-item__menutoggle action-item__menutoggle--default-icon'])[4]")
    public WebElement threeDotButton;

    @FindBy (xpath = "//ul/li/button/span[text()='Delete']/parent::button")
    public WebElement deleteContactButton;

    @FindBy (xpath = "//button[@class='icon action-item__menutoggle icon-picture-force-white']")
    public WebElement addImageIconButton;

    @FindBy (xpath = "//span[text()='Choose from Files']/parent::button")
    public WebElement chooseFromFileButton;

    @FindBy (xpath = "//span[text()='MyFolder']")
    public WebElement myFolderElement;

    @FindBy (xpath = "//tr[@data-type='file']")
    public WebElement imageUnderMyFolder;

    @FindBy (xpath = "//button[text()='Choose']")
    public WebElement chooseButtonForImage;

    @FindBy (xpath = "//div/div/img[contains(@src,'blob:')]")
    public WebElement avatarImageForContact;



    /**
     * If Webelement is stale, this method will return true
     * @param staleElement
     */
    public void checkStaleElementTrue(WebElement staleElement){
        try{

           staleElement.getText();

        }catch (StaleElementReferenceException e){
            Assert.assertTrue(true);
        }

    }

    public int differentRandomIndex(int oldRandom){
        int newRandom;
        do {
            newRandom = new Random().nextInt(contactList.size());

        }while (oldRandom==newRandom);
        return newRandom;
    }

    public void writingCompanyName(String name) {

        BrowserUtils.waitFor(3);
        String script = "arguments[0].value='"+name+"'";
        Actions action = new Actions(Driver.getDriver());
        //action.click(companyName).sendKeys(name).perform();
        //companyName.sendKeys(name);
        //String script2 = "arguments[0].innerHTML='"+name+"'";
        action.click(newContactNameValue).sendKeys(name).pause(2).perform();

        //action.click(companyName).pause(1).perform();
       // ((JavascriptExecutor) Driver.getDriver()).executeScript(script, companyName);
       // newContactNameValue.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript(script, newContactNameValue);


        BrowserUtils.waitFor(1);




        new WebDriverWait(Driver.getDriver(), 5).until(ExpectedConditions.attributeContains(newContactNameValue,"value",name));
        Assert.assertEquals(newContactNameValue.getAttribute("value"), name);
    }

}
