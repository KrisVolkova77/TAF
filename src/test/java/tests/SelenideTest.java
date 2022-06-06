package tests;

import Confuguration.ReadProperties;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeSuite
    public void setupBrowser(){
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = ReadProperties.browserName();//ставим браузер в котором хотим чтобы открылся
        Configuration.browserSize = "1200x1800";
        //Configuration.assertionMode = AssertionMode.SOFT;
        //Configuration.driverManagerEnabled = false;возможно подключать сторонний драйвер менеджер
        Configuration.fastSetValue=true;//имитация скорости работы
        Configuration.headless = true;
        Configuration.reportsFolder = "target/screen";//куда скидывается репорты все, скрины


    }


    @Test

    public void simpleSelenideTest(){

        open(ReadProperties.getUrl());

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));


    }

    @Test

    public void poSelenideTest(){

        open(ReadProperties.getUrl());

        LoginPage loginPage = new LoginPage();


       loginPage.username.setValue(ReadProperties.username());
        loginPage.password.setValue(ReadProperties.password());
        loginPage.button.click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

    }
    @Test
    public void selenideTest1() {
        // Относительный путь для login-страницы - простой слеш
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        $$("div.project");//поиск нескольких элементов
        $$("div.project").shouldHave(size(26))
                .find(text("erg"))
                .click();



    }
}
