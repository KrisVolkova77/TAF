import Services.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_6 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new BrowserService().getDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void task_6(){
        driver.get("https://www.saucedemo.com/cart.html");

        Assert.assertEquals(1, driver.findElements(By.cssSelector("vertical-align: inherit;")).size());
        Assert.assertEquals(1, driver.findElements(By.cssSelector("vertical-align: inherit;")).size());





    }
}
