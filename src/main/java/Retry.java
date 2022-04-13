import org.testng.IRetryAnalyzer;

     public class Retry implements IRetryAnalyzer{
    private int attemp=1;
    private static final int MAX_RETRY=5;

    @Override
         public boolean retry(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            if(attemp<MAX_RETRY) {
                attemp++;
                iTestResult.setStatus(TestResult.FAILURE);
                System.out.println("Retrying one more time...");
                return true;
            }else {
                iTestResult.setStatus(TestResult.FAILURE);
            }
        }else {
            iTestResult.setStatus(TestResult.SUCCESS);
        }
        return false;

            }
        }
    }
}
