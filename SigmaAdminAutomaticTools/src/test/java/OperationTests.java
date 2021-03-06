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
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.Steps;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import pages.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

/**
 * Created by zieli_k on 2018-04-24.
 */
public class OperationTests extends JUnitStory {
    private OperationsAgreementPage agreementPage;
    private OperationsClientPage clientPage;
    private OperationsDocumentPage documentPage;
    private OperationsHomePage homePage;
    private OperationsMainPage mainPage;
    private static WebDriver driver;


    @BeforeStory
    public void before(){
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        agreementPage = new OperationsAgreementPage(driver);
        clientPage = new OperationsClientPage(driver);
        documentPage = new OperationsDocumentPage(driver);
        homePage = new OperationsHomePage(driver);
        mainPage = new OperationsMainPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("Open webdriver")
    public void openWebdriver(){
        /*System.setProperty("webdriver.chrome.driver", "C:\\dev\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        agreementPage = new OperationsAgreementPage(driver);
        clientPage = new OperationsClientPage(driver);
        documentPage = new OperationsDocumentPage(driver);
        homePage = new OperationsHomePage(driver);
        mainPage = new OperationsMainPage(driver);*/
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("I go to operations-web")
    public void goToOperationsWeb() throws InterruptedException {
        driver.get("https://sigmapprod/sigma-operations-web/noAuth/login");
        Thread.sleep(1000);
        //driver.manage().window().maximize();
    }

    @Then("I see Podaj dane logowania")
    public void seeLoginData() throws InterruptedException {
        homePage.checkLoginDataHeader();
        Thread.sleep(1000);
    }

    @When("I login to main page")
    public void loginToMainPage() throws InterruptedException {
        homePage.loginOperationsWeb();
        Thread.sleep(1000);
    }

    @Then("I see welcome page")
    public void seeWelcomePage() throws InterruptedException {
        mainPage.welcomeTabExists();
        Thread.sleep(1000);
    }

    @When("I write $agreementId in search field and click searching")
    public void writeAgreementId(String agreementId) throws InterruptedException {
        mainPage.fillAgreementId(agreementId);
        mainPage.searchingAgreement();
        Thread.sleep(1000);
    }

    @Then("I see client data $clientData")
    public void seeClientData(String clientData) throws InterruptedException {
        agreementPage.checkClientData(clientData);
        Thread.sleep(1000);
    }

    @When("I click debt value")
    public void clickDebtValue() throws InterruptedException {
        agreementPage.clickDebtValue();
        Thread.sleep(2000);
    }

    @Then("I see client data section $clientData")
    public void seeClientDataSecion(String clientData) throws InterruptedException {
        clientPage.checkClientDataLabel(clientData);
        Thread.sleep(2000);
    }

    @When("I click documents")
    public void clickDocuments() throws InterruptedException {
        clientPage.clickClientDocuments();
        Thread.sleep(500);
    }

    @Then("I see documents header")
    public void seeDocumentHeader() throws InterruptedException {
        documentPage.checkClientDocument();
        Thread.sleep(1000);
    }

    @When("I fill $barcode")
    public void fillBarcode(String barcode) throws InterruptedException {
        documentPage.writeBarcodeToSearchField(barcode);
        Thread.sleep(1000);
    }

    @Then("I see only one document")
    public void seeOnlyOneDocument(){
        documentPage.checkCountDocuments();
        mainPage.logoutFromApp();
    }

    @AfterStory
    public void closeDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.manage().deleteAllCookies();
        Thread.sleep(1000);
        driver.close();
        Thread.sleep(1000);
    }
/*
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
    */
}
