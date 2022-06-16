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

        WebElement oCr = driver.findElement(By.id("oCr"));
        WebElement oAge = driver.findElement(By.id("oAge"));
        WebElement oWeight = driver.findElement(By.id("oWeight"));
        WebElement oHeight = driver.findElement(By.id("oHeight"));
        WebElement button = driver.findElement(By.id("рассчитать"));
        button.click();

        oCr.sendKeys("80");
        oAge.sendKeys("38");
        oWeight.sendKeys("55");
        oHeight.sendKeys("163");
        button.click();

        Thread.sleep(2000);

        WebElement resultMDRD = driver.findElement(By.id("txtMDRD"));
        Assert.assertEquals(resultMDRD.getText(), "MDRD: 74 (мл/мин/1,73кв.м)");
        WebElement resultMDRD1 = driver.findElement(By.id("txtMDRD1"));
        Assert.assertEquals(resultMDRD1.getText(), "ХБП: 2 стадия (при наличии почечного повреждения)");
        WebElement resultCG = driver.findElement(By.id("txtCG"));
        Assert.assertEquals(resultCG.getText(), "Cockroft-Gault: 70 (мл/мин)");
        WebElement resultBSA = driver.findElement(By.id("txtBSA"));
        Assert.assertEquals(resultBSA.getText(), "Поверхность тела:1.58 (кв.м)");
    }

    @AfterMethod
    public void tearDow() {
        driver.quit();
    }

}