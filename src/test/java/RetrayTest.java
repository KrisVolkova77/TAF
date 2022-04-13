import org.testng.Assert;
import org.testng.annotations.Test;

public class RetrayTest {
    private int attempt =1;
    @Test
public void flakyTest(){
        if(attempt ==4) {
            Assert.assertTrue(true);
        }else{
            attempt++;
            System.out.println("Attempt is:" + attempt);
            throw new NullPointerException();
        }
    }
}


