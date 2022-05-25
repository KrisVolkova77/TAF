package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";

    public TopMenuPage topMenuPage;

    // Блок описания селекторов для элементов
    private By headerTitleLabel = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Dashboard')]");

    public DashboardPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    public WebElement getPageIdentifier() {
        return (WebElement) headerTitleLabel;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public WebElement getHeaderTitleLabel() {
        return waitsService.waitForExists(headerTitleLabel);
    }
}

