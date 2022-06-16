package tests;

import Services.WaitsService;
import baseEntities.BaseTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramesTest extends BaseTest {

    @Test

    public void framesTest(){
        driver.get("http://the-internet.herokuapp.com/frames");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(20));




    }
}
