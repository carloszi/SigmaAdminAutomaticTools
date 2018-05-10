package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

/**
 * Created by zieli_k on 2018-04-24.
 */
public class OperationsMainPage extends AbstractPage {

    public OperationsMainPage(WebDriver driver){
        super(driver);
    }

    @FindBy (id="welcomeTab")
    private WebElement welcomeTab;

    @FindBy (id="OperationTypeForm:searchNumber")
    private WebElement searchField;

    @FindBy (id="OperationTypeForm:searchButton")
    private WebElement searchButton;

    @FindBy (id="OperationTypeForm:loginAndBreakMenuBtn")
    private WebElement breakButton;

    @FindBy (id="OperationTypeForm:logoutButton")
    private WebElement logoutButton;

    public void welcomeTabExists(){
        assertTrue(welcomeTab.isDisplayed());
    }

    public void fillAgreementId(String agreementId){
        searchField.sendKeys(agreementId);
    }

    public void searchingAgreement(){
        searchButton.click();
    }

    public void logoutFromApp(){
        breakButton.click();
        logoutButton.click();
    }


}
