package net.seamlessly.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.DeckModulePage;
import net.seamlessly.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DeckModule_StepDefs {

    DeckModulePage deckModulePage = new DeckModulePage();
    String newBoardName;

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
}
