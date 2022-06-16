package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ProjectsPage projectsPage;
    protected AddProjectPage addProjectPage;
    protected SideMenuPage sideMenuPage;
    protected MilestonesPage milestonesPage;
    protected AddMilestonePage addMilestonePage;



    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        projectsPage = new ProjectsPage(driver);
        addProjectPage = new AddProjectPage(driver);
        sideMenuPage = new SideMenuPage(driver);
        milestonesPage = new MilestonesPage(driver);
        addMilestonePage = new AddMilestonePage(driver);

    }
}
