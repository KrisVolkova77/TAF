import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

// ToDo: Название тестового метода мне не нравиться
public class dz1test {
    @Test
    public void testdiv() {
        Assert.assertEquals(dz1.div(10, 2), 5, "Верное...");
    }
    // ToDo: Сообщение в Assert выводиться только в случае ошибки и должно быть направлено на пояснение случившегося.

    @Test(enabled = false)
    public void testdiv1() {
        Assert.assertEquals(dz1.div(10, 2), 5, "Верное...");
    }

    @Test(description = "Test with description")
    public void testdiv2() {
        Assert.assertEquals(dz1.div(10, 2), 5, "Верное...");
    }

    @Test(testName = "Test with name")
    public void testdiv3() throws InterruptedException {
        Assert.assertEquals(dz1.div(10, 2), 5, "Верное...");}

    @Test(timeOut = 2000)
    public void waitLongTimeTest() throws InterruptedException {
        sleep(1000);}

    @Test(invocationCount = 4, invocationTimeOut = 2000, threadPoolSize = 4)
    public void invocationCountTest() throws InterruptedException {
        sleep(500);
        Assert.assertEquals(dz1.div(10, 2), 5, "Верное...");}

    @Test(dataProvider = "dataForDiv", dataProviderClass = StaticProvider.class)
    public void testDataProvider(int a, int b, int expectedResult) {
        Assert.assertEquals(dz1.div(a, b), expectedResult, "Верное...");}

    // ToDo: Отсутствуют тесты деления на 0
    // ToDo: Отсутствуют тесты с параметрами передаваемыми из TestNG.xml
    // ToDo: Название тестовых методов - переделать согласно https://dzone.com/articles/7-popular-unit-test-naming
    // ToDo: Отсутствуют зависимые тесты
    // ToDo: Отсутствуют приоритизированные тесты
}


