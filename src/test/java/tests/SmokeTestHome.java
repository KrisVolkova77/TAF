package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class SmokeTestHome {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
    }

    @Test
    public void electricityCalculator() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        WebElement width = driver.findElement(By.id("el_f_width"));
        WebElement lenght = driver.findElement(By.id("el_f_lenght"));
        WebElement roomType = driver.findElement(By.id("room_type"));
        WebElement heatingType = driver.findElement(By.id("heating_type"));
        WebElement heatLosses = driver.findElement(By.id("el_f_losses"));
        WebElement floorCablePower = driver.findElement(By.id("floor_cable_power"));
        WebElement specFloorCablePower = driver.findElement(By.id("spec_floor_cable_power"));
        WebElement button = driver.findElement(By.className("buttHFcalc"));

        Select selectRoomType = new Select(roomType);
        Select selectHeatingType = new Select(heatingType);

        width.sendKeys("3");
        lenght.sendKeys("4");
        selectRoomType.selectByValue("3");
        selectHeatingType.selectByValue("2");
        heatLosses.sendKeys("800");
        button.click();

        floorCablePower.click();
        Assert.assertEquals(floorCablePower.getAttribute("value"), "1680");
        specFloorCablePower.click();
        Assert.assertEquals(specFloorCablePower.getAttribute("value"), "140");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}