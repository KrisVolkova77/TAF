package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/overview";

    public SideMenuPage sideMenuPage;

    private By headerTitleLabel = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Projects')]");

    public ProjectsPage(WebDriver driver) {
        super(driver);

        sideMenuPage = new SideMenuPage(driver);
    }

    @Override
    public WebElement getPageIdentifier() {
        return (WebElement) headerTitleLabel;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}

