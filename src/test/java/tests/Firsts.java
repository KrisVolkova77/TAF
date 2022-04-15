package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Firsts {
    @Test
    public void browserTests(){
        System.setProperty("webdriver.chrome.driver", "C:\\proekt\\src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }
}
