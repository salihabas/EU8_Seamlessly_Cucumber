package net.seamlessly.pages;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.seamlessly.step_definitions.DeckModule_StepDefs;
import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DeckModulePage extends BasePage {

    private String newBoardName;
    private String newListName;

    int indexNumberOfListOfCurrentBoard = 0;
    private String newCardName;

    int anyThreeDotsIndexNumber = 0;

    private int countOfAvatarsOnCards;

    private int afterAssignCountofAvatarsOnCards;

    DeckModule_StepDefs deckModule_stepDefs;


    public int getAfterAssignCountofAvatarsOnCards() {
        return afterAssignCountofAvatarsOnCards;
    }

    public void setAfterAssignCountofAvatarsOnCards() {
        List<WebElement> listOfAvatarsOnCards = Driver.getDriver().findElements(By.xpath("//div[@class='avatars']//div[@class='avatardiv popovermenu-wrapper has-tooltip']"));
        afterAssignCountofAvatarsOnCards = listOfAvatarsOnCards.size();

    }

    public int getCountOfAvatarsOnCards() {
        return countOfAvatarsOnCards;
    }

    public void setCountOfAvatarsOnCards() {
        List<WebElement> listOfAvatarsOnCards = Driver.getDriver().findElements(By.xpath("//div[@class='avatars']//div[@class='avatardiv popovermenu-wrapper has-tooltip']"));
        countOfAvatarsOnCards = listOfAvatarsOnCards.size();
    }

    public String getNewCardName() {
        return newCardName;
    }

    public void setNewCardName() {
        Faker faker = new Faker();
        newCardName = faker.animal().name();
    }

    public String getNewBoardName() {
        return newBoardName;
    }

    public void setNewBoardName() {
        Faker faker = new Faker();
        newBoardName = faker.funnyName().name();
    }

    public String getNewListName() {
        return newListName;
    }

    public void setNewListName() {
        Faker faker = new Faker();
        newListName = faker.idNumber().valid();
    }

    public DeckModulePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@aria-controls='app-navigation-vue']")
    public WebElement toggleButton;

    @FindBy(xpath = "//div[@id='app-navigation-vue']//a[@href='#']")
    public WebElement addBoard;

    @FindBy(xpath = "//input[@placeholder='Board name']")
    public WebElement boardNameInputBox;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement confirmIcon;

    @FindBy(xpath = "//ul[@class='app-navigation-entry__children']//span[@title]")
    public WebElement referanceOfBoardList;

    @FindBy(xpath = "//button[@icon='icon-add']")
    public WebElement addListIcon;

    @FindBy(xpath = "//div[@id='stack-add']//input[@id='new-stack-input-main']")
    public WebElement enterListNameInputBox;

    @FindBy(xpath = "//input[@id='new-stack-input-main']")
    public WebElement cardNameInput;

    @FindBy(xpath = "(//div[@class='open']//li//button)[1]")
    public WebElement assignToMe;

    @FindBy(xpath = "//div[@class='board']//button[@icon]")
    public WebElement addCardButtons;

    @FindBy(xpath = "//div[@class='smooth-dnd-container vertical']//div//button[@aria-label='Actions']")
    public WebElement threeDotsOnCurrentBoard;

    @FindBy(xpath = "//span[.='Assign to me']")
    public WebElement assignToMeText;


    public WebElement findBoardFromBoards(String boardName) {
        List<WebElement> boardList = Driver.getDriver().findElements(By.xpath("//ul[@class='app-navigation-entry__children']//span[@title]"));
        WebElement foundElement = null;
        for (WebElement eachBoard : boardList) {
            if (eachBoard.getAttribute("title").equals(boardName)) {
                foundElement = eachBoard;
            }
        }
        return foundElement;
    }

    public void checkcreatedBoard() {
        WebElement board = Driver.getDriver().findElement(By.xpath("//span[@title='" + newBoardName + "']") );
        BrowserUtils.sleep(1);
        Assert.assertTrue(board.isDisplayed());
    }

    public void clickAnyBoard() {
        Faker faker = new Faker();
        List<WebElement> boardList = Driver.getDriver().findElements(By.xpath("//ul[@class='app-navigation-entry__children']//span[@title]"));
        boardList.get(faker.number().numberBetween(0, boardList.size() - 1)).click();
    }


    public void checkCreatedListName() {

        WebElement createdList = Driver.getDriver().findElement(By.xpath("//h3[contains(text(),'" + newListName + "')]"));
        Assert.assertTrue(createdList.isDisplayed());
    }


    public void clickAnyAddCardButtonOnTheCurrentBoard() {
        if (!addCardButtons.isDisplayed()){
            deckModule_stepDefs.user_clicks_add_list_button_top_right_of_the_page();
            deckModule_stepDefs.user_enters_any_list_name_and_presses_enter_key();
        }
        Faker faker = new Faker();
        List<WebElement> addIcons = Driver.getDriver().findElements(By.xpath("//div[@class='board']//button[@icon]"));
        indexNumberOfListOfCurrentBoard = faker.number().numberBetween(0, addIcons.size() - 1);
        addIcons.get(indexNumberOfListOfCurrentBoard).click();
    }

    public void  checkCreatedCard() {
        WebElement createdCard = Driver.getDriver().findElement(By.xpath("//span[.='" + newCardName + "']"));
        Assert.assertTrue(createdCard.isDisplayed());
    }



    public void clickAnyThreeDotsOnCards() {
        Faker faker = new Faker();
        if (!threeDotsOnCurrentBoard.isDisplayed()){
            deckModule_stepDefs.user_clicks_add_list_button_top_right_of_the_page();
            deckModule_stepDefs.user_enters_any_list_name_and_presses_enter_key();
            deckModule_stepDefs.user_clicks_add_card_button_of_any_created_list();
            deckModule_stepDefs.user_enters_new_card_name_and_presses_enter();
            clickAnyThreeDotsOnCards();
        }


        List<WebElement> threeDotsList = Driver.getDriver().findElements(By.xpath("//div[@class='smooth-dnd-container vertical']//div//button[@aria-label='Actions']"));
        anyThreeDotsIndexNumber = faker.number().numberBetween(0, threeDotsList.size() - 1);
        threeDotsList.get(anyThreeDotsIndexNumber).click();
        if (!assignToMe.isDisplayed()){

        }

    }


}
