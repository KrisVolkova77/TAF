package tests;

import Confuguration.ReadProperties;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeSuite
    public void setupBrowser() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = ReadProperties.browserName();//ставим браузер в котором хотим чтобы открылся
        Configuration.browserSize = "1200x1800";
        //Configuration.assertionMode = AssertionMode.SOFT;
        //Configuration.driverManagerEnabled = false;возможно подключать сторонний драйвер менеджер
        Configuration.fastSetValue = true;//имитация скорости работы
        Configuration.headless = true;
        Configuration.reportsFolder = "target/screen";//куда скидывается репорты все, скрины

        Configuration.pageLoadTimeout = 30000; //можно так сделать а можно
        Configuration.pageLoadTimeout = Duration.ofSeconds(30).toMillis();// а можно и так

        Configuration.timeout = 20000;


        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()); //базовая версия

        // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );


    }


    @Test

    public void simpleSelenideTest() {

        open(ReadProperties.getUrl());

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));


    }

    @Test

    public void poSelenideTest() {

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
        $$("div.project")
                .shouldHave(size(26))
                .filter(visible)
                .find(text("erg"))
                .click();

        $$("div.project")
                .first();
        $$("div.project")
                .get(2);


        sleep(1000);
        refresh();// обновляет страницу
        title();//возращает тайл с нашей страницы и проверить
        executeJavaScript("");

    }

    @Test
    public void selenideTest2() throws FileNotFoundException {
        // Относительный путь для login-страницы - простой слеш
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        System.out.println($(byText("asdasdasdfaszc")).innerText());
        System.out.println($(byText("asdasdasdfaszc")).getText());
        System.out.println($(byText("asdasdasdfaszc")).innerHtml());
        System.out.println($(byText("asdasdasdfaszc")).data(""));
        System.out.println($(byText("asdasdasdfaszc")).val());
        $(byText("asdasdasdfaszc")).scrollTo();
        $(byText("asdasdasdfaszc")).doubleClick();
        $(byText("asdasdasdfaszc")).contextClick();
        $(byText("asdasdasdfaszc")).hover();
        $(byText("asdasdasdfaszc")).find(By.xpath(""));
        $(byText("asdasdasdfaszc")).closest("tr");
        $(byText("asdasdasdfaszc")).ancestor("div");
        $(byText("asdasdasdfaszc")).sibling(1);
        $(byText("asdasdasdfaszc")).parent();
        $(byText("asdasdasdfaszc")).uploadFile(new File(""));
        //$(byText("asdasdasdfaszc")).download();

    }

    @Test
    public void selenideTest3() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        open("/index.php?/admin/projects/overview");

        $$(By.className("hoverSensitive"))
                .shouldHave(size(26))
                .find(text("erg"))
                .find(By.tagName("a"))
                .click();

        $("#announcement")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("This is the description for the project1"));

        $("#announcement")
                .should(exist)
                .should(hidden).should(disappear).shouldNotBe(not(visible))
                .shouldHave(name("hbfdj"))
                .shouldHave(value("hhf"))
                .shouldHave(type("checkbox"))
                .shouldBe(empty)
                .shouldBe(focused);

        WebElement webElement = $("#Announcement").toWebElement();

        Condition clicable = and("can you clicked", visible,enabled);
        $$("#announcement")
                .findBy(clicable).click();

        $("#announcement").shouldBe(clicable);


        //проверка текста ниже

        $("#announcement")
                .shouldHave(text("Expected Text")) // проверка на вхождение текста "contains"
                .shouldHave(matchText("Expected Text")) // проверка на вхождение паттерна текста
                .shouldHave(exactText(""))     // проверка на вхождение конкретного текста и регистра "equalsIgnoreCase
                .shouldHave(textCaseSensitive("Expected Result Text"))  //проверка с учетом регистра и всех символов
                .shouldHave(exactTextCaseSensitive("Exp Result Text \n\n\n")); // Проверка на вхождение текста + регистрозависимость + все символы; "equals"



    }
}