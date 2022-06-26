package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

   public SelenideElement username =  $(By.id(".input"));
   public SelenideElement password = $(By.id("password"));
    public SelenideElement button= $(By.id("button is-vcentered"));

}
