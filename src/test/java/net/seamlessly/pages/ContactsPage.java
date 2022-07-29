package net.seamlessly.pages;

import net.seamlessly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
