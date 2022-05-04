package baseEntities;

import Confuguration.ReadProperties;
import Services.WaitsService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitsService waitsService;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        waitsService = new WaitsService(driver, Duration.ofSeconds(ReadProperties.timeout()));

    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        return waitsService.waitForExists(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUrl() + pagePath);
    }
}
