/**
 * Created by zieli_k on 2018-02-21.
 */

import database.StrategyProcessDatabase;
import org.jbehave.core.Embeddable;
import org.jbehave.core.annotations.*;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.jbehave.core.reporters.EscapeMode.HTML;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AdminTests extends JUnitStory{

    private AdminLoginPage loginPage;
    private AdminHomePage homePage;
    private AdminMenuPage menuPage;
    private AdminStrategyPage strategyPage;
    private StrategyProcessDatabase spd;
    private static WebDriver driver;


    @BeforeClass
    public static void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeStories
    public void before(){
        loginPage = new AdminLoginPage(driver);
        homePage = new AdminHomePage(driver);
        menuPage = new AdminMenuPage(driver);
        strategyPage = new AdminStrategyPage(driver);
        spd = new StrategyProcessDatabase();
    }


    @Given("Go to admin site")
    public void testGoToAdminSite() throws InterruptedException {
        driver.get("https://b.int.sigma/sigma-admin-web/noAuth/login");
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @When("I write user, password and click login")
    public void testLogin() throws InterruptedException {
        loginPage.loginToAdmin();
        Thread.sleep(2000);
    }

    @Then("I go to admin main site")
    public void testVerifyLogin() throws InterruptedException{
        assertEquals(homePage.lbl_MainSite.getText(), "Strona domowa");
        Thread.sleep(2000);
    }

    @When("I click logout button")
    public void testLogout() throws InterruptedException{
        homePage.logoutFromAdmin();
        Thread.sleep(2000);
    }

    @Then("I back to login admin page")
    public void testVerifyLogout()throws InterruptedException{
        assertEquals(loginPage.lbl_AdminWeb.getText(), "Moduł administratora - dane logowania");
        Thread.sleep(2000);
    }

    @Given("Go to Admin main site")
    public void testGoToAdminMainSite() throws InterruptedException {
        driver.get("https://b.int.sigma/sigma-admin-web/noAuth/login");
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        loginPage.loginToAdmin();
        Thread.sleep(1000);
    }

    @When("User try get into Action Definition List")
    public void testActionDefinitionList() throws InterruptedException {
        menuPage.goToActionDefinitionList();
        strategyPage.clickToActivDefinitionList();
        Thread.sleep(1000);
    }

    @Then("User see Działania strategiczne")
    public void testVerifyActionDefinitionList()throws InterruptedException {
        System.out.println(strategyPage.lbl_ActionDefinitionList.getText());
        assertEquals(strategyPage.lbl_ActionDefinitionList.getText(), "Działania strategiczne");
    }

    @Given("User in action definition list")
    public void testActionDefinitionDefine() throws InterruptedException {
        testActionDefinitionList();
    }

    @When("User try add new action definition with name $name and symbol $symbol")
    public void testAddindNewActionDefinition(String name, String symbol) throws InterruptedException {
        strategyPage.createActionExecutionApplication(name, symbol);
    }

    @Then ("User see name $name in database")
    public void testVerifyNewActionDefinitionDatabase(String name) throws SQLException, ClassNotFoundException {
        //StrategyProcessDatabase spd = new StrategyProcessDatabase();
        ArrayList<String> activityDefinitionNames = spd.getDBData("StrategyProcess", "ActionDefinition", "name");
        assertTrue(activityDefinitionNames.contains(name));
    }

    @AfterStory
    public void closeDriver() {
        driver.close();
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats()
                        .withFormats(Format.HTML,Format.CONSOLE)
                        .withRelativeDirectory("jbehave-report"));
    }

    @Override
    public List candidateSteps() {
        return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
    }


}





