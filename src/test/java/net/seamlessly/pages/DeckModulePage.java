package net.seamlessly.pages;

import net.seamlessly.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DeckModulePage extends BasePage{
    public DeckModulePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
