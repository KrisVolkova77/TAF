package tests;

import Services.WaitsService;
import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadTest extends BaseTest {

@Test
    public void fileUploadTest(){

    driver.get("http://the-internet.herokuapp.com/upload");

    WaitsService wait = new WaitsService(driver, Duration.ofSeconds(20));
    WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
    fileUploadPath.sendKeys("C:\\proekt\\src\\test\\resources\\File Uploader.docx");
    wait.waitForExists(By.id("file-submit")).submit();




}
}
