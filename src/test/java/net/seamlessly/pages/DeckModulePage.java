package net.seamlessly.pages;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.seamlessly.step_definitions.DeckModule_StepDefs;
import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DeckModulePage extends BasePage {


    public final String list_2_Name = "List2";


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


    @FindBy(xpath = "//button[@icon='icon-add']")
    public WebElement addListIcon;

    @FindBy(xpath = "//div[@id='stack-add']//input[@id='new-stack-input-main']")
    public WebElement enterListNameInputBox;

    @FindBy(xpath = "//div[@class='stack']//button[@icon='icon-add']")
    public List<WebElement> addCardButton;
    @FindBy(xpath = "//input[@id='new-stack-input-main']")
    public WebElement cardNameInput;

    @FindBy(xpath = "//span[contains(text(),'Assign to me')]//..")
    public WebElement assignToMeButton;

    @FindBy(xpath = "(//div[@class='open']//li//button)[1]//span[2]")
    public WebElement assignToMeText;

    @FindBy(xpath = "//div[@class='avatar-list']//img")
    public WebElement assignedAvatar;


    @FindBy(xpath = "//div[@class='smooth-dnd-container vertical']//div//button[@aria-label='Actions']")
    public List<WebElement> threeDotsOnCards;

    @FindBy(xpath = "(//div[@class='open']//li)[2]//button")
    public WebElement moveCardOnDropdown;

    @FindBy(xpath = "//button[@class='primary']")
    public WebElement moveCardButton;

    @FindBy(xpath = "//input[@placeholder='Select a board']")
    public WebElement selectBoardInputBox;

    @FindBy(xpath = "(//ul[@class='multiselect__content'])[2]//li[@class='multiselect__element']")
    public List<WebElement> listLinksFromOtherBoard;

    @FindBy(xpath = "//div[@class='smooth-dnd-container horizontal']//div[@class='avatardiv popovermenu-wrapper has-tooltip']")
    public List<WebElement> avatarsOnCards;

    @FindBy(xpath = "//h3[@class='stack__title has-tooltip']") //gettext
    public List<WebElement> listNamesOnCurrentBoard;

    @FindBy(xpath = "//input[@placeholder='Select a list']")
    public WebElement selectListInput;

    @FindBy(xpath = "//span[@class='action-button__icon icon-delete']/..")
    public WebElement deleteBoard;

    @FindBy(xpath = "//button[@class='error primary']")
    public WebElement deleteBoardConfirm;


    public void checkcreatedBoard() {
        WebElement board = Driver.getDriver().findElement(By.xpath("//span[@title='" + getBoardName() + "']"));
        BrowserUtils.sleep(1);
        Assert.assertTrue(board.isDisplayed());
    }


    public void clickAnyCreatedBoard() {
        WebElement createdBoard = Driver.getDriver().findElement(By.xpath("//span[@title='" + getAnyNameFromCreatedBoards() + "']/.."));
        createdBoard.click();
    }


    public void deleteBoards() {

        List<WebElement> boardsThreeDots = Driver.getDriver().findElements(By.xpath("//ul[@class='app-navigation-entry__children']//button[@aria-label='Actions']"));
        if (boardsThreeDots.size() != 0) {
            for (WebElement eachBoardsThreeDot : boardsThreeDots) {
                eachBoardsThreeDot.click();
                deleteBoard.click();
            }
        }

    }


    Faker faker = new Faker();
    private String boardName;

    //take the name with title attribute
    @FindBy(xpath = "//ul[@class='app-navigation-entry__children']//span[@class='app-navigation-entry__title']")
    public List<WebElement> createdBoardsNamesFromSpan;

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName() {

        this.boardName = "Board" + faker.number().randomNumber();
    }

    public String createNewBoardName() {
        setBoardName();
        for (WebElement eachCreatedBoard : createdBoardsNamesFromSpan) {
            if (eachCreatedBoard.getAttribute("title").equals(getBoardName())) {
                setBoardName();
            }
        }

        return getBoardName();
    }

    public String getAnyNameFromCreatedBoards() {
        int randomBoardIndex = faker.number().numberBetween(0, createdBoardsNamesFromSpan.size() - 1);
        return createdBoardsNamesFromSpan.get(randomBoardIndex).getAttribute("title");
    }


    public void clickAnyBoardNameFromCreatedBoards() {

        try {
            int indexOfBoard = faker.number().numberBetween(1, createdBoardsNamesFromSpan.size());
            Driver.getDriver().findElement(By.xpath("(//ul[@class='app-navigation-entry__children']//a)[" + indexOfBoard + "]")).click();
            if (createdBoardsNamesFromSpan.size() < 2) {
                setOfBoardAndCard();
            }
        } catch (NoSuchElementException e) {
            setOfBoardAndCard();
        }


    }

    private String listName;

    public String getListName() {
        return listName;
    }

    public void setListName() {
        this.listName = "List" + faker.number().randomNumber();
    }

    public void checkCreatedListName() {

        WebElement createdList = Driver.getDriver().findElement(By.xpath("//h3[contains(text(),'" + getListName() + "')]"));
        Assert.assertTrue(createdList.isDisplayed());
    }

    public void clickAnyAddCardButtonOnTheCurrentBoard() {
        try {
            addCardButton.get(faker.number().numberBetween(0, addCardButton.size()-1)).click();
            if (addCardButton.isEmpty()){
                setOfcreateCardfromBatch();
                clickAnyAddCardButtonOnTheCurrentBoard();
            }
        }catch (NoSuchElementException e){
            setOfcreateCardfromBatch();
            clickAnyAddCardButtonOnTheCurrentBoard();
        }

    }

    private String cardName;

    public String getCardName() {
        return cardName;
    }

    public void setCardName() {
        this.cardName = "Card" + faker.number().randomNumber();
    }

    public void checkCreatedCard() {
        WebElement createdCard = Driver.getDriver().findElement(By.xpath("//span[.='" + getCardName() + "']"));
        Assert.assertTrue(createdCard.isDisplayed());
    }

    @FindBy(xpath = "//div[@class='card-upper']//span")
    public List<WebElement> cardNames;



    public void clickAnyThreeDotsOnCards() {
        try {
            if (threeDotsOnCards.isEmpty()){
                setOfcreateCardfromBatch();
            }
            int randomNumber = faker.number().numberBetween(0,threeDotsOnCards.size()-1);
            threeDotsOnCards.get(randomNumber).click();
            setAnyCardName(cardNames.get(randomNumber).getText());
        } catch (NoSuchElementException | IndexOutOfBoundsException e) {
            System.out.println("I create set for you...");
            setOfcreateCardfromBatch();
            clickAnyThreeDotsOnCards();
        }

    }

    public void clickAssignToMe() {

        try {
            assignToMeButton.click();
        } catch (NoSuchElementException e) {
            setOfcreateCardfromBatch();
            clickAnyThreeDotsOnCards();
            clickAssignToMe();
        }
    }

    public void setOfcreateCardfromBatch() {
        addListIcon.click();
        BrowserUtils.sleep(1);
        setListName();
        BrowserUtils.sleep(1);
        enterListNameInputBox.sendKeys(getListName() + Keys.ENTER);
        BrowserUtils.sleep(1);
        addCardButton.get(faker.number().numberBetween(0, addCardButton.size())).click();
        BrowserUtils.sleep(1);
        setCardName();
        BrowserUtils.sleep(1);
        cardNameInput.sendKeys(getCardName() + Keys.ENTER);
        BrowserUtils.sleep(1);

    }

    public void setOfBoardAndCard() {
        addBoard.click();
        BrowserUtils.sleep(1);
        createNewBoardName();
        boardNameInputBox.sendKeys(getBoardName());
        BrowserUtils.sleep(1);
        confirmIcon.click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//span[@title='" + getBoardName() + "']/../..")).click();
        BrowserUtils.sleep(1);
        addListIcon.click();
        BrowserUtils.sleep(1);
        setListName();
        BrowserUtils.sleep(1);
        enterListNameInputBox.sendKeys(getListName() + Keys.ENTER);
        BrowserUtils.sleep(1);
        addCardButton.get(faker.number().numberBetween(0, addCardButton.size())).click();
        BrowserUtils.sleep(1);
        setCardName();
        BrowserUtils.sleep(1);
        cardNameInput.sendKeys(getCardName() + Keys.ENTER);
        BrowserUtils.sleep(1);
    }

    public String getAnyListNameFromCurrentBoard() {
        return listNamesOnCurrentBoard.get(faker.number().numberBetween(0, listNamesOnCurrentBoard.size() - 1)).getText();
    }

    private String anyBoardName ;
    private String anyCardName;


    public String getAnyBoardName() {
        return anyBoardName;
    }

    public void setAnyBoardName() {
        this.anyBoardName = getAnyNameFromCreatedBoards();
    }

    public String getAnyCardName() {
        return anyCardName;
    }

    public void setAnyCardName(String anyCardName) {
        this.anyCardName = anyCardName;
    }

    public void selectBoardAndListToMove() {
        setAnyBoardName();
        selectBoardInputBox.sendKeys(getAnyBoardName() + Keys.ENTER);
        BrowserUtils.sleep(1);
        selectListInput.click();
        listLinksFromOtherBoard.get(faker.number().numberBetween(0,listLinksFromOtherBoard.size()-1)).click();

    }

    public void clickBoardMovedCard() {
        Driver.getDriver().findElement(By.xpath("//span[@title='" + getAnyBoardName() + "']/..")).click();
    }

    public void checkMovedCard(){
       Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//span[contains(text(),'" + getAnyCardName() + "')]")).isDisplayed());
    }

    ////h3[contains(text(),'List313')]/../..//span[contains(text(),'Card3074297')]
}
