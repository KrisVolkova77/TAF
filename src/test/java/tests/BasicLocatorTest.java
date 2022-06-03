package tests;

import Confuguration.ReadProperties;
import Services.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicLocatorTest {
    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = new BrowserService().getDriver();
    }

    @AfterMethod
    public void tearDown(){ driver.close();
    }

    @Test
    public void basicLocatorTest_1(){
        driver.get(ReadProperties.getUrl());

        //Find WebElement be ID
        driver.findElement(By.id("name")).sendKeys(ReadProperties.username());

        //Find webElement by name
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
        //Find webElement by Teg name
        driver.findElement(By.tagName("button")).click();
    }

    @Test
    public void basicLocatorTest_2() throws InterruptedException {
        driver.get(ReadProperties.getUrl());

        //find web element by link text
        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(2000);

        //find web element by class name
        driver.findElement(By.className("forgot_passwordpage-request-cancel")).click();

        Thread.sleep(2000);

        //find web element by parcial link text
        driver.findElement(By.partialLinkText("your password")).click();

        Thread.sleep(2000);


    }
}


