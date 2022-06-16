package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {

    private By milestonesPageLocator= By.cssSelector("content-header-title page_title");
    private By deleteMilestoneLocator = By.cssSelector("icon-small-delete ");
    private By confirmationDeleteLocator= By.xpath("//div.button button-ok button-left button-positive dialog-action-default\"");

    public MilestonesPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getDeleteMilestoneLocator() {
        return driver.findElement(deleteMilestoneLocator);
    }
    public WebElement getConfirmationDeleteLocator() {
        return driver.findElement(confirmationDeleteLocator);
    }

    @Override
    protected By getPageIdentifier() {
        return milestonesPageLocator;
    }
}
