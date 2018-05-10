package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by zieli_k on 2018-04-24.
 */
public class OperationsClientPage extends AbstractPage {

    public  OperationsClientPage(WebDriver driver){
        super(driver);
    }

    @FindBy (id="ClientDataForm:clientDataCompanyName")
    private WebElement clientDataLabel;

    @FindBy (id="documentListForm:documentsButton")
    private WebElement clientDocumentsButton;

    public void checkClientDataLabel(String clientData){
        assertEquals(clientDataLabel.getText(),clientData);
    }

    public void clickClientDocuments(){
        clientDocumentsButton.click();
    }
}
