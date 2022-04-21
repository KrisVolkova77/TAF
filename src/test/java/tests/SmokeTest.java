package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLInputElement;
import services.BrowsersService;

public class SmokeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
    }

    @Test
    public void validateIKTCalculation() throws InterruptedException {
        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");
        WebElement height = driver.findElement(By.name("height"));
        WebElement weight = driver.findElement(By.name("weight"));
        WebElement button = driver.findElement(By.id("calc-mass-c"));

        height.sendKeys("183");
        weight.sendKeys("58");
        button.click();

        Thread.sleep(2000);
        WebElement result = driver.findElement(By.id("imt-result"));
        Assert.assertEquals(result.getText(), "17.3 - Недостаточная (дефицит) масса тела");
    }

    @Test
    public void validateSKF() throws InterruptedException {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");

        WebElement selectWebElement = driver.findElement(By.id("oSex"));
        Select selectSex = new Select(selectWebElement);
        selectSex.selectByIndex(1);
        Thread.sleep(2000);
        selectSex.selectByValue("0");
        Thread.sleep(2000);
        selectSex.selectByVisibleText("женский");
        Thread.sleep(2000);

        WebElement nCr = driver.findElement(By.id("nCr"));
        WebElement nAge = driver.findElement(By.id("nAge"));
        WebElement nWeight = driver.findElement(By.id("nWeight"));
        WebElement nHeight = driver.findElement(By.id("nHeight"));
        WebElement button = driver.findElement(By.name("рассчитать"));
        button.click();

        nCr.sendKeys("80");
        nAge.sendKeys("38");
        nWeight.sendKeys("55");
        nHeight.sendKeys("163");

        Thread.sleep(2000);

        WebElement result = driver.findElement(By.id("txtMDRD"));
        Assert.assertEquals(result.getText(), "MDRD: 74 (мл/мин/1,73кв.м)");

        WebElement result1 = driver.findElement(By.id("txtMDRD1"));
        Assert.assertEquals(result.getText(), "ХБП: 2 стадия (при наличии почечного повреждения)");

        WebElement result2 = driver.findElement(By.id("txtCG"));
        Assert.assertEquals(result.getText(), "Cockroft-Gault: 70 (мл/мин)");

        WebElement result3 = driver.findElement(By.id("txtBSA"));
        Assert.assertEquals(result.getText(), "Поверхность тела:1.58 (кв.м)");



    }

    @Test
    public void validateHome() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        WebElement el_f_width = driver.findElement(By.name("el_f_width"));
        WebElement el_f_lenght = driver.findElement(By.name("el_f_lenght"));
        WebElement selectWebElement = driver.findElement(By.id("hfcol1"));
        Select selecthfcol1 = new Select(selectWebElement);
        selecthfcol1.selectByIndex(1);
        Thread.sleep(2000);
        selecthfcol1.selectByValue("0");
        Thread.sleep(2000);
        selecthfcol1.selectByVisibleText("кухня или спальня");
        Thread.sleep(2000);

        WebElement heating_type = driver.findElement(By.id("heating_type"));
        Select selectSex = new Select(selectWebElement);
        selectSex.selectByIndex(1);
        Thread.sleep(2000);
        selectSex.selectByValue("0");
        Thread.sleep(2000);
        selectSex.selectByVisibleText("основное отопление");
        Thread.sleep(2000);

        WebElement hfcol1 = driver.findElement(By.id("hfcol1"));









    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
