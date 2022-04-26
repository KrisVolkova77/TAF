import Confuguration.ReadProperties;
import Services.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLInputElement;

public class Task_6 {
    private WebDriver driver;
    private HTMLInputElement button;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
    }


    @AfterMethod
    public void tearDown() {

        driver.close();

    }
    @Test
    public void task_6() throws InterruptedException {
        driver.get("https://www.saucedemo.com/\n");
        driver.get(ReadProperties.getUrl());

        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
        Thread.sleep(2000);
        driver.findElement(By.tagName("login-button")).click();
        button.click();
        Thread.sleep(2000);

        WebElement AddtoBasket = driver.findElement(By.cssSelector("vertical-align: inherit;"));
        AddtoBasket.click();

        WebElement Opencart = driver.findElement(By.cssSelector("shopping_cart_link"));
        Opencart.click();
        Thread.sleep(2000);

        Assert.assertEquals(1, driver.findElements(By.cssSelector("inventory_item_name")).size());
        Assert.assertEquals(1, driver.findElements(By.cssSelector("inventory_item_price")).size());
        Thread.sleep(2000);
    }

    @Test
    public void task_6_1() throws InterruptedException {
        driver.get("https://www.saucedemo.com/\n");


        // поиск по ID
        Assert.assertTrue(driver.findElement(By.cssSelector("#root")).isDisplayed());

        // поиск по className
        Assert.assertTrue(driver.findElement(By.className(".status-message")).isDisplayed());

        // Поиск по нескольким значения в аттрибуте class
        Assert.assertTrue(driver.findElement(By.cssSelector(".status-message")).isDisplayed());

        // Поиск по teg name
        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());

        //Поиск по linktext
        Assert.assertTrue(driver.findElement(By.cssSelector("/favicon.ico")).isDisplayed());

        //Поиск по partiallinktext
        Assert.assertTrue(driver.findElement(By.cssSelector("manifest")).isDisplayed());


        //CSS
        //Поиск по .class
        Assert.assertTrue(driver.findElement(By.cssSelector(".middle")).isDisplayed());

        //Поиск по .class1.class2
        Assert.assertTrue(driver.findElement(By.cssSelector(".viewport.theme-color.description")).isDisplayed());

        //Поиск по #id
        Assert.assertTrue(driver.findElement(By.cssSelector("#goog-gt-tt")).isDisplayed());

        //Поиск по [attribute=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("standard_user")).isDisplayed());

        //Поиск по [attribute|=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("lang=\"ru\"")).isDisplayed());


        //xpath
        //Поиск по атрибуту, например By.xpath("//tag[@attribute='value']");

        }
        }










