package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AdvancedDriver {
        public static WebDriver getDriver(){
            System.setProperty("webdriver.chrome.driver", "/Users/aleksandr/Documents/Work/TechMeSkills/CODE_AQA18/TAF_AQA18/src/test/resources/chromedriver");
            WebDriver driver = new ChromeDriver();
            return driver;
}
public ChromeOptions getChromeOptions(){
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setHeadless(ReadProperties.isHeadless());
    chromeOptions.addArguments("--disable-gru");
    //chromeOptions.addArguments("--window-size=1920,1200");
    chromeOptions.addArguments("--ignore-certificate-errors");
    chromeOptions.addArguments("--silent");
    chromeOptions.addArguments("--start-maximized");

    return chromeOptions;

        }
}
