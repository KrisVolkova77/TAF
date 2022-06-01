package baseEntities;

import Services.BrowserService;
import models.Project;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.LoginStep;
import steps.NavigationStep;
import utils.Listener;

@Listeners(Listener.class)
public class BaseTest {
    public WebDriver driver;
    protected LoginStep loginStep;
    protected NavigationStep navigationStep;


    protected Project mainProject;

  //  @BeforeTest
   // public void prepareData() throws IOException {
      //  Reader reader = Files.newBufferedReader(Paths.get("projectResult.json"));
      //  mainProject = new Gson().fromJson(reader, Project.class);

   // }


    @BeforeMethod
    public void setup(){
        driver = new BrowserService().getDriver();
        loginStep = new LoginStep(driver);
        navigationStep = new NavigationStep(driver);

        //driver.get(ReadProperties.getUrl());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
