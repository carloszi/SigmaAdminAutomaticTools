package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by zieli_k on 2018-03-28.
 */
public class AdminStrategyPage extends AbstractPage {

    public AdminStrategyPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "menuStrategyForm:menuItemActionDefinitionList")
    private WebElement btn_ActionDefinitionList;

    @FindBy(xpath="//*[@id='actionDefinitionListForm:j_idt73']/span")
    public WebElement btn_Plus;

    @FindBy(id="ccActionDefinitionDialog:actionDefinitionForm:name")
    public WebElement txtbx_Name;

    @FindBy(id="ccActionDefinitionDialog:actionDefinitionForm:symbolInp")
    public WebElement txtbx_Symbol;

    @FindBy(id="ccActionDefinitionDialog:actionDefinitionForm:type_label")
    public WebElement btn_Type;

    @FindBy(xpath="//*[@id='ccActionDefinitionDialog:actionDefinitionForm:type_panel']/div/ul/li[6]")
    public WebElement btn_ExecutionApplication;

    @FindBy(id="ccActionDefinitionDialog:actionDefinitionForm:actionDays")
    public WebElement btn_ActionDays;

    @FindBy(xpath="//*[@id=\"ccActionDefinitionDialog:actionDefinitionForm:actionDays_panel\"]/div[1]/div/div[2]/span")
    public WebElement chcbx_ActionDaysAll;

    @FindBy(xpath = "//*[@id=\"ccActionDefinitionDialog:actionDefinitionForm:actionDays_panel\"]/div[1]/a/span")
    public WebElement btn_CircleClose;

    @FindBy(id = "ccActionDefinitionDialog:actionDefinitionForm:generalNextBtn")
    public WebElement btn_Next;

    @FindBy(id ="ccActionDefinitionDialog:actionDefinitionForm:actionDefinitionDetailsPanel_header")
    public WebElement lbl_ExecutionApplication;

    @FindBy(id ="ccActionDefinitionDialog:actionDefinitionForm:executionForm_label")
    public WebElement btn_ExecutionForm;

    @FindBy(xpath ="//*[@id='ccActionDefinitionDialog:actionDefinitionForm:executionForm_panel']/div/ul/li[3]")
    public WebElement btn_ExecutionFormPaper;

    @FindBy(id ="ccActionDefinitionDialog:actionDefinitionForm:documentTypeExecution_label")
    public WebElement btn_DocumentTypeExecution;

    @FindBy (xpath = "//*[@id='ccActionDefinitionDialog:actionDefinitionForm:documentTypeExecution_panel']/div/ul/li[12]")
    public WebElement btn_DSEGroup;

    @FindBy(id ="ccActionDefinitionDialog:actionDefinitionForm:documentNameExecution_label")
    public WebElement  btn_DocumentNameExecution;

    @FindBy (xpath = "//*[@id='ccActionDefinitionDialog:actionDefinitionForm:documentNameExecution_panel']/div/ul/li[31]")
    public WebElement btn_WniosekEgz;

    @FindBy(id ="ccActionDefinitionDialog:actionDefinitionForm:solicitor")
    public WebElement  btn_LegalCounselList;

    @FindBy (xpath = "//*[@id='ccActionDefinitionDialog:actionDefinitionForm:solicitor_panel']/div[1]/div[1]/div[2]/span")
    public WebElement chcbx_LegalCounselAll;

    @FindBy (xpath = "//*[@id='ccActionDefinitionDialog:actionDefinitionForm:solicitor_panel']/div[1]/a/span")
    public WebElement btn_LegalCounselCircleClose;

    @FindBy (id = "ccActionDefinitionDialog:actionDefinitionForm:detailsAddBtn")
    public WebElement btn_AddActionDefinition;

    @FindBy(id = "actionDefinitionListForm:actionDefinitionListDT:j_idt75:filter")
    public WebElement lbl_ActionDefinitionListFilterSymbol;

    @FindBy(id ="actionDefinitionListForm:actionDefinitionListPanel_header")
    public WebElement lbl_ActionDefinitionList;

    @FindBys({@FindBy(id = "actionDefinitionListForm:actionDefinitionListDT_data")})
    public static List<WebElement> lbl_ActionDefinitionsList;

    public void clickToActivDefinitionList() throws InterruptedException {
        btn_ActionDefinitionList.click();
        Thread.sleep(1000);
    }

    public void createActionExecutionApplication(String name, String symbol) throws InterruptedException{
        btn_Plus.click();
        Thread.sleep(500);
        txtbx_Name.sendKeys(name);
        txtbx_Symbol.sendKeys(symbol);
        Thread.sleep(500);
        btn_Type.click();
        Thread.sleep(500);
        btn_ExecutionApplication.click();
        Thread.sleep(500);
        btn_ActionDays.click();
        Thread.sleep(500);
        chcbx_ActionDaysAll.click();
        Thread.sleep(500);
        btn_CircleClose.click();
        Thread.sleep(500);
        btn_Next.click();
        Thread.sleep(1000);
        btn_ExecutionForm.click();
        Thread.sleep(500);
        btn_ExecutionFormPaper.click();
        Thread.sleep(500);
        btn_DocumentTypeExecution.click();
        Thread.sleep(500);
        btn_DSEGroup.click();
        Thread.sleep(500);
        btn_DocumentNameExecution.click();
        Thread.sleep(500);
        btn_WniosekEgz.click();
        Thread.sleep(500);
        btn_LegalCounselList.click();
        Thread.sleep(500);
        chcbx_LegalCounselAll.click();
        Thread.sleep(500);
        btn_LegalCounselCircleClose.click();
        Thread.sleep(500);
        btn_AddActionDefinition.click();
        Thread.sleep(2000);
        lbl_ActionDefinitionListFilterSymbol.sendKeys(symbol);
        Thread.sleep(2000);
    }

    public Integer getActionDefinitionListSize(){
        Integer size = lbl_ActionDefinitionsList.size();
        return size;
    }

}
