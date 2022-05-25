package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuPage extends BasePage {
    private By topPanel = By.className("top-panel");

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getPageIdentifier() {

        return (WebElement) topPanel;
    }
}
