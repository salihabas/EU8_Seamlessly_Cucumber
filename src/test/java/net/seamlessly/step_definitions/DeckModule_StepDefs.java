package net.seamlessly.step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.DeckModulePage;
import net.seamlessly.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DeckModule_StepDefs {

    DeckModulePage deckModulePage = new DeckModulePage();
    String newBoardName;
    String newListName;

    @When("User clicks on deck module")
    public void user_clicks_on_deck_module() {
        deckModulePage.getModuleElement("Deck").click();
    }
    @When("User clicks to navigation toggle top-left of the page")
    public void user_clicks_to_navigation_toggle_top_left_of_the_page() {
        deckModulePage.toggleButton.click();
    }
    @When("User clicks to Add board entry link")
    public void user_clicks_to_add_board_entry_link() {
        deckModulePage.addBoard.click();
    }
    @When("User enters {string} board name in input box")
    public void user_enters_board_name_in_input_box(String boardName) {
        newBoardName = boardName;
        deckModulePage.boardNameInputBox.sendKeys(newBoardName);
    }
    @When("User clicks input confirm button")
    public void user_clicks_input_confirm_button() {
        deckModulePage.confirmIcon.click();
    }
    @Then("User can see new board in the all boards")
    public void user_can_see_new_board_in_the_all_boards() {
        BrowserUtils.sleep(2);
        deckModulePage.checkcreatedBoard(newBoardName);
    }

    @When("User clicks first board from the opened menu")
    public void user_clicks_first_board_from_the_opened_menu() {
        deckModulePage.clickfirstBoard();
    }
    @When("User clicks + add list button top right of the page")
    public void user_clicks_add_list_button_top_right_of_the_page() {
        deckModulePage.addListIcon.click();
    }
    @When("User enters {string} list name and presses enter key")
    public void user_enters_list_name_and_presses_enter_key(String listName) {
        newListName = listName;
        deckModulePage.enterListNameInputBox.sendKeys(newListName + Keys.ENTER);
        BrowserUtils.sleep(2);
    }

    @Then("User can see newly created list appears under the related board;")
    public void user_can_see_newly_created_list_appears_under_the_related_board() {
        deckModulePage.checkCreatedListName(newListName);
    }
}
