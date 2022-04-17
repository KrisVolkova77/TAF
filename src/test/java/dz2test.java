import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class dz2test {

    @Test
    public void testdiv() {Assert.assertEquals(dz2.div(20, 2), 40, "OK...");
    }

    @Test(enabled = false)
    public void testdiv1() {Assert.assertEquals(dz2.div(20, 2), 40, "OK...");
    }

    @Test(description = "Test with description")
    public void testdiv2() {
        Assert.assertEquals(dz2.div(20, 2), 40, "OK...");
    }


    @Test(testName = "Test with name")
    public void testdiv3() throws InterruptedException {
        Assert.assertEquals(dz2.div(20, 2), 40, "OK...");
    }

    @Test(timeOut = 2000)
    public void waitLongTimeTest() throws InterruptedException {
        sleep(1000);
    }

    @Test(invocationCount = 4, invocationTimeOut = 1000, threadPoolSize = 4)
    public void invocationCountTest() throws InterruptedException {
        sleep(500);
        Assert.assertEquals(dz2.div(20, 2), 40, "OK...");
    }

    @Test(dataProvider = "dataForDiv", dataProviderClass = StaticProvider.class)
    public void testDataProvider(int a, int b, int expectedResult) {
        Assert.assertEquals(dz2.div(a, b), expectedResult, "OK...");
    }
}



