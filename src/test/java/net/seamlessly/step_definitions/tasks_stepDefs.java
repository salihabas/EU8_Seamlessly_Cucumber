package net.seamlessly.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.BasePage;
import net.seamlessly.pages.TasksPage;
import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;
import java.util.List;
import java.util.Random;


public class tasks_stepDefs extends BasePage {

    TasksPage tasksPage = new TasksPage();
    Random random = new Random();
    List<String> completedTasks;


    @When("user clicks {string} module")
    public void user_clicks_module(String module) {
        getModuleElement(module).click();
    }

    @Given("user clicks Add List...")
    public void user_clicks_add_list() {
        tasksPage.addList.click();
        BrowserUtils.waitFor(10);
    }

    @Given("user enters tasks list name as {string}")
    public void user_enters_tasks_list_name_as(String newList) {
        tasksPage.newListInput.sendKeys(newList);
    }

    @Given("user clicks checkmark")
    public void user_clicks_checkmark() {
        tasksPage.newListInputSave.click();
        BrowserUtils.waitFor(10);
    }

    @Then("new list of tasks is created as {string}")
    public void new_list_of_tasks_is_created_as(String newList) {
        Assert.assertTrue(tasksPage.isListCreated(newList));
    }

    @Given("user chose {string} tasks group from the tasks list")
    public void user_chose_tasks_group_from_the_tasks_list(String listName) {
        tasksPage.getList(listName).click();
    }

    @Given("user enters task name as {string} and clicks enter")
    public void user_enters_task_name_as_and_clicks_enter(String taskName) {
        tasksPage.newTaskInput.sendKeys(taskName + Keys.ENTER);
    }

    @Then("{string} task is created under {string} tasks group")
    public void task_is_created_under_tasks_group(String taskName, String listName) {
        tasksPage.getList(listName).click();
        Assert.assertTrue(tasksPage.getTask(taskName).isDisplayed());
    }

    @Given("Tasks are created under {string} tasks group")
    public void tasks_are_created_under_tasks_group(String listName, List<String> taskNames) {

        tasksPage.getList(listName).click();

        for (String each : taskNames) {

            // check if task is created. And if not, create it.
            try {
                if (tasksPage.getTask(each).isDisplayed()) {
                }
            } catch (Exception e) {
                tasksPage.newTaskInput.sendKeys(each + Keys.ENTER);
            }
        }
    }

    @Given("user clicks checkbox near any completed task name")
    public void user_clicks_checkbox_near_any_completed_task_name(List<String> taskNames) {

        completedTasks = taskNames;

        for (String taskName : taskNames) {
            tasksPage.completeTheTask(taskName);
        }
    }

    @Then("chosen task is added to the list of completed tasks")
    public void chosen_task_is_added_to_the_list_of_completed_tasks() {

        // Check if counter is increased, assume there was not any copmleted task
        Assert.assertTrue(tasksPage.getCounter("Completed") > 0);

        // Check if task is in completed task list
        for (String completedTask : completedTasks) {
            Assert.assertTrue(tasksPage.isTaskInCompletedList(completedTask));
        }
    }

    @Given("user has uncompleted tasks remaining")
    public void user_has_uncompleted_tasks_remaining() {
        BrowserUtils.waitForVisibility(tasksPage.getList("Current"),10);
        Assert.assertTrue(tasksPage.getList("Current").isDisplayed());
    }

    @Then("user can see the number of all uncompleted tasks")
    public void user_can_see_the_number_of_all_uncompleted_tasks() {
        Assert.assertTrue(tasksPage.getCounter("Current")>0);
    }


    @Given("user clicks on the star icon on the right side of task line")
    public void user_clicks_on_the_star_icon_on_the_right_side_of_task_line(List<String> taskNames) {
        BrowserUtils.waitForVisibility(tasksPage.getList("Current"),10);
        tasksPage.getList("Current").click();
        for (String taskName : taskNames) {
            tasksPage.checkTheTaskAsImportant(taskName);
        }

    }
    @Then("the task is added to list of important tasks")
    public void the_task_is_added_to_list_of_important_tasks(List<String> taskNames) {

        tasksPage.getList("Important").click();
        for (String taskName : taskNames) {

            Assert.assertTrue(tasksPage.getTask(taskName).isDisplayed());

        }


    }




}
