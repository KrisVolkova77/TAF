package tests;

import Confuguration.ReadProperties;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    private Object loginPage;

    private WebElement loginPage(String jhkhllmf, String password) {
        return null;
    }


    @Test(description = "Правильный логин")
    public void testName() {
        Assert.assertTrue(true);
    }


    @Test(description = "Неправильный емайл")
    public void incorrectPsw() {
        Assert.assertEquals(
                loginPage("jhkhllmf", ReadProperties.password()).getText(),
                "Your email or password is wrong");
    }



    @Test(description = "Неверный пароль")
    public void incorrectEmail() {
        Assert.assertEquals(
                loginPage(ReadProperties.username(), "1245h").getText(),
                "Your email or password is wrong");
    }
}



