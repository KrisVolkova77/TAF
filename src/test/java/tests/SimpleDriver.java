package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {
    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/aleksandr/Documents/Work/TechMeSkills/CODE_AQA18/TAF_AQA18/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
