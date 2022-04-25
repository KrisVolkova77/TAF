package tests;

import Confuguration.ReadProperties;
import Services.BrowserService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    WebDriver driver ;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
        driver.get(ReadProperties.getUrl());
    }
    @AfterMethod
    public void tearDown(){

}
    @Test
    public void successLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPswInput().sendKeys(ReadProperties.username());
        loginPage.getLogInButton().sendKeys(ReadProperties.username());
    }
    @Test
    public void incorrectEmailLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPswInput().sendKeys(ReadProperties.password());
        loginPage.getLogInButton().click();
    }

    @Test
    public void incorrectPswLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPswInput().sendKeys(ReadProperties.password());
        loginPage.getLogInButton().click();
    }
    }

