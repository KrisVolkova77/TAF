package pages;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class CreationMilestonesPage extends BaseTest {

    private By nameLocator = By.id("name");
    private By referenceLocator = By.id("reference");
    private By descriptionLocator = By.id("description_display");
    private By startDateLocator = By.id("start_on");
    private By endDateLocator = By.id("due_on");
    private By addMilestoneButtonLocator = By.id("accept");

    public CreationMilestonesPage(WebDriver driver) {
        super(driver);
    }

    private By successStartMilestoneButtonLocator = By.xpath(
            "//div[@class='message message-success' and text()='Successfully added the new milestone.']");

    @Override
    protected By getPageIdentifier() {
        return successStartMilestoneButtonLocator;
    }

    protected By getNameIdentifier() {return nameLocator;}
    protected By getReferenceIdentifier() {return referenceLocator;}
    protected By getDescriptionIdentifier() {
        return descriptionLocator;
    }
    protected By getStartDateIdentifier() {
        return startDateLocator;
    }
    protected By getEndDateIdentifier() {
        return endDateLocator;
    }
    protected By getAddMilestoneButtonIdentifier() {
        return addMilestoneButtonLocator;
    }



}
