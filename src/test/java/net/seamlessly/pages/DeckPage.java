package net.seamlessly.pages;

import net.seamlessly.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DeckPage extends BasePage{
    public DeckPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
