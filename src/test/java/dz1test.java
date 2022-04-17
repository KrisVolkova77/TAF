import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class dz1test {
    @Test
    public void testmult() {
        Assert.assertEquals(dz1.div(10, 2), 5, "Верное...");
    }

    @Test(enabled = false)
    public void testmult1() {
        Assert.assertEquals(dz1.div(10, 2), 5, "Верное...");
    }

    @Test(description = "Test with description")
    public void testmult2() {
        Assert.assertEquals(dz1.div(10, 2), 5, "Верное...");
    }

    @Test(testName = "Test with name")
    public void testSum3() throws InterruptedException {
        Assert.assertEquals(dz1.div(10, 2), 5, "Верное...");
    }

    @Test(timeOut = 2000)
    public void waitLongTimeTest() throws InterruptedException {
        sleep(1000);
    }

    @Test(invocationCount = 4, invocationTimeOut = 2000, threadPoolSize = 4)
    public void invocationCountTest() throws InterruptedException {
        sleep(500);
        Assert.assertEquals(dz1.div(10, 2), 5, "Верное...");
    }

    @Test(dataProvider = "dataForDiv", dataProviderClass = StaticProvider.class)
    public void testDataProvider(int a, int b, int expectedResult) {
        Assert.assertEquals(dz1.div(a, b), expectedResult, "Верное...");
    }
}


