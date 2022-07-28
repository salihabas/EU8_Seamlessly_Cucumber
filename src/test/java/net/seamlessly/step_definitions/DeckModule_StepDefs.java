package net.seamlessly.step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.seamlessly.pages.DeckModulePage;
import net.seamlessly.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DeckModule_StepDefs {

    DeckModulePage deckModulePage = new DeckModulePage();


    @When("User clicks on deck module")
    public void user_clicks_on_deck_module() {
        deckModulePage.getModuleElement("Deck").click();
        BrowserUtils.sleep(1);
    }
    @When("User clicks to navigation toggle top-left of the page")
    public void user_clicks_to_navigation_toggle_top_left_of_the_page() {
        deckModulePage.toggleButton.click();
    }
    @When("User clicks to Add board entry link")
    public void user_clicks_to_add_board_entry_link() {
        deckModulePage.addBoard.click();
    }

    @When("User enters any board name in input box")
    public void user_enters_any_board_name_in_input_box() {
        deckModulePage.createNewBoardName();
        deckModulePage.boardNameInputBox.sendKeys(deckModulePage.getBoardName());
    }
    @When("User clicks input confirm button")
    public void user_clicks_input_confirm_button() {
        deckModulePage.confirmIcon.click();
    }
    @Then("User can see new board in the all boards")
    public void user_can_see_new_board_in_the_all_boards() {
        BrowserUtils.sleep(1);
        deckModulePage.checkcreatedBoard();
    }


    @When("User clicks created board from the opened menu")
    public void user_clicks_created_board_from_the_opened_menu() {
        BrowserUtils.sleep(1);
        deckModulePage.clickAnyBoardNameFromCreatedBoards();


    }

    @When("User clicks + add list button top right of the page")
    public void user_clicks_add_list_button_top_right_of_the_page() {
        BrowserUtils.sleep(1);
        deckModulePage.addListIcon.click();
        BrowserUtils.sleep(1);
    }

    @When("User enters any list name and presses enter key")
    public void user_enters_any_list_name_and_presses_enter_key() {
        deckModulePage.setListName();
        deckModulePage.enterListNameInputBox.sendKeys(deckModulePage.getListName() + Keys.ENTER);
        BrowserUtils.sleep(1);
    }

    @Then("User can see newly created list appears under the related board;")
    public void user_can_see_newly_created_list_appears_under_the_related_board() {
        deckModulePage.checkCreatedListName();
    }

    @When("User clicks + add card button of any created list")
    public void user_clicks_add_card_button_of_any_created_list() {
        deckModulePage.clickAnyAddCardButtonOnTheCurrentBoard();
    }
    @When("User enters new card name and presses enter")
    public void user_enters_new_card_name_and_presses_enter() {
        deckModulePage.setCardName();
        deckModulePage.cardNameInput.sendKeys(deckModulePage.getCardName() + Keys.ENTER);
    }
    @Then("User can see new card appears on the related list")
    public void user_can_see_new_card_appears_on_the_related_list() {
        deckModulePage.checkCreatedCard();
    }

    @When("User clicks any three dots button on any created card")
    public void user_clicks_any_three_dots_button_on_any_created_card() {
        deckModulePage.clickAnyThreeDotsOnCards();
    }
    @When("User clicks the assign to me option from opened menu")
    public void user_clicks_the_assign_to_me_option_from_opened_menu() {
        BrowserUtils.sleep(1);
        deckModulePage.clickAssignToMe();

    }
    @Then("User profile icon should be displayed on card")
    public void user_profile_icon_should_be_displayed_on_card() {
        Assert.assertTrue(deckModulePage.assignedAvatar.isDisplayed());

    }

    @When("User clicks move card")
    public void user_clicks_move_card() {
        deckModulePage.moveCardOnDropdown.click();
    }
    @When("User selects board and list and clicks move card button")
    public void user_selects_board_and_list_and_clicks_move_card_button() {
        deckModulePage.selectBoardAndListToMove();
        deckModulePage.moveCardButton.click();

    }
    @When("User clicks board that moved card recently")
    public void user_clicks_board_that_moved_card_recently() {
        deckModulePage.clickBoardMovedCard();
    }
    @Then("The card should be displayed under the selected list")
    public void the_card_should_be_displayed_under_the_selected_list() {
        deckModulePage.checkMovedCard();
    }
}
