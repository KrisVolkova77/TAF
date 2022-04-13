import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class CalcTest extends BaseTest {
    @Test
    public void testSum() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма...");
    }

    @Test(enabled = false)
    public void testSum1() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма...");
    }

    @Test(description = "Тест с описанием")
    public void testSum2() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма...");
    }

    @Test(testName = "Test with name")
    public void testSum3() throws InterruptedException {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма...");
    }

    @Test(timeOut = 1000)
    public void waitLongTimeTest() throws InterruptedException {
        sleep(800);
    }

    @Test(invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void invocationCountTest() throws InterruptedException {
        sleep(250);
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма...");
    }

    @Test(dataProvider = "dataForSum", dataProviderClass = StaticProvider.class)
    public void testDataProvider(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.sum(a, b), expectedResult, "Неверная сумма...");

    }
}