package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertEquals;

/**
 * Created by zieli_k on 2018-04-24.
 */
public class OperationsAgreementPage extends AbstractPage {

    public OperationsAgreementPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="ViewDebtAgreementForm:viewDebtAgreementTreeTable:0:viewDebtAgreementClientNameField")
    private WebElement clientNameSurname;

    @FindBy (id="ViewDebtAgreementForm:viewDebtAgreementTreeTable:0:showCompany1")
    private WebElement debtValue;

    public void checkClientData(String clientData){
        assertEquals(clientData, clientNameSurname.getText());
    }

    public void clickDebtValue(){
        debtValue.click();
    }
}
