package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {

    private By nameLocator = By.cssSelector(".form-control ");
    private By ReferencesLocator = By.cssSelector("pull-left");
    private By ParentLocator = By.cssSelector("parent_id");
    private By DescriptionLocator = By.cssSelector("description_display");
    private By StarDateLocator = By.cssSelector("ui-state-default ui-state-highlight ui-state-active");
    private By EndDateLocator = By.cssSelector("ui-state-default ui-state-active");
    private By AddProjectButtonLocator = By.cssSelector("accept");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return nameLocator;
    }

    public WebElement getReferencesLocator() {
        return driver.findElement(ReferencesLocator);
    }

    public WebElement getParentLocator() {
        return driver.findElement(ParentLocator);
    }

    public WebElement getDescriptionLocator() {
        return driver.findElement(DescriptionLocator);
    }

    public WebElement getStarDateLocator() {
        return driver.findElement(StarDateLocator);
    }

    public WebElement getEndDateLocator() {
        return driver.findElement(EndDateLocator);
    }

    public WebElement getAddProjectButtonLocator() {
        return driver.findElement(AddProjectButtonLocator);
    }
}

