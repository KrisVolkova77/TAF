package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import services.AdvancedDriver;
import services.SimpleDriver;

public class FirstTest {
    private WebDriver driver;

    @Test
    public void browserTests(){
        SimpleDriver simpleDriver = new SimpleDriver();
        SimpleDriver.getDriver();

    }
    @Test
    public void advancedTest(){
        AdvancedDriver advancedDriver = new AdvancedDriver();
        driver = advancedDriver.getDriver();

    }

}
