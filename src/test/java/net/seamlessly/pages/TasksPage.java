package net.seamlessly.pages;

import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends BasePage {

    public TasksPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[@title='Add List…']")
    public WebElement addList;

    @FindBy(xpath = "//input[@id='newListInput']")
    public WebElement newListInput;

    @FindBy(xpath = "//input[@id='newListInput']/..//input[@title='Cancel']")
    public WebElement newListInputCancel;

    @FindBy(xpath = "//input[@id='newListInput']/..//input[@title='Save']")
    public WebElement newListInputSave;


    @FindBy(xpath = "//div[@class='header__input']//input")
    public WebElement newTaskInput;

    @FindBy(xpath = "//span[contains(.,'completed tasks')]")
    public WebElement loadAllCopletedTasksButton;




    public boolean isListCreated(String listName) {
        return Driver.getDriver().findElement(By.xpath("//span[@title='" + listName + "']")).isDisplayed();
    }

    public WebElement getList(String listName) {
        return Driver.getDriver().findElement(By.xpath("//span[@title='" + listName + "']"));
    }

    /**
     * returns task's under chosen tasks group.
     * Correct tasks group should be chosen before to use this method
     *
     * @param taskName name of the task
     * @return returns web element of the given task
     */
    public WebElement getTask(String taskName) {
        return Driver.getDriver().findElement(By.xpath("//div[@class='grouped-tasks']//span[.='" + taskName + "']"));
    }

    public WebElement getCheckBox(String taskName) {
        return Driver.getDriver().findElement(By.xpath("//span[.='" + taskName + "']/../../..//input[contains(@id,'checkbox')]"));
    }


    /**
     * Takes listName as input and returns number of tasks under that list
     *
     * @param listName Name of the task group
     * @return returns number of the tasks in given task group
     */
    public int getCounter(String listName) {

        WebElement counter = Driver.getDriver().findElement(By.xpath("//span[@title='" + listName + "']/../following-sibling::div//div[@class='app-navigation-entry__counter']"));

        return Integer.parseInt(counter.getText());
    }

    /**
     *
     * @param taskName name of the task to be checked
     * @return Returns true if given taskname is in completed
     */
    public boolean isTaskInCompletedList(String taskName) {

        getList("Completed").click();
        return Driver.getDriver().findElement(By.xpath("//span[.='" + taskName + "']")).isDisplayed();

    }

    public void checkTheTaskAsImportant(String taskName){
        Driver.getDriver().findElement(By.xpath("(//span[.='"+taskName+"']/../../following-sibling::div//span[@class='material-design-icon star-icon'])[1]"));
    }

    public void completeTheTask(String taskName){
        Driver.getDriver().findElement(By.xpath("//span[.='"+taskName+"']/../../preceding-sibling::div//span")).click();
    }


}
