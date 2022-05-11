package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramTest extends BaseTest {

    @Test
    public void framTest(){
        driver.get("http://the-internet.herokuapp.com/frames");

       //driver.switchTo().frame(0); //как только мы это сделали то селениум переключился сразу не на родительский а туда куда надо на фрейм
        //driver.switchTo().frame("mce_0_ifr");
        driver.switchTo().frame(driver.findElement(By.cssSelector(".tox-edit-area__iframe")));
        Assert.assertTrue(driver.findElement(By.id("tinymce")).isDisplayed());

       driver.switchTo().parentFrame(); //вернутся назад в родительский документ
        driver.switchTo().defaultContent(); // помогает с последнего фрейма вернутся сразу на первый а не постепенно

        Assert.assertTrue(driver.findElement(By.className("tox-editor-container")).isDisplayed());

    }

}
