package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMilestonePage extends BasePage {

    private By addMilestonePageLocator;
    private By headerTitleLocator = By.cssSelector("content-header-title page_title");
    private By nameMilestoneLocator = By.cssSelector("sidebar-milestones-overview");
    private By addNavigationMilestones = By.cssSelector("navigation-milestones-add");
    private String pagePath;

    public AddMilestonePage(WebDriver driver) {
        super(driver);

    }

    @Override
    protected By getPageIdentifier() {
        return addMilestonePageLocator;
    }

    public By getHeaderTitleLocator() {
        return headerTitleLocator;
    }

    public WebElement getNameMilestoneLocator() {
        return driver.findElement(nameMilestoneLocator);
    }

    public WebElement getAddNavigationMilestones() {
        return driver.findElement(addNavigationMilestones);
    }


    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
