package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by zieli_k on 2018-04-25.
 */
public class OperationsDocumentPage extends AbstractPage{

    public OperationsDocumentPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="documentListForm:documentsComponent:documentsPanel_header")
    private WebElement clientDocumentsHeader;

    @FindBy(id="documentListForm:documentsComponent:documentList:j_idt131:filter")
    private WebElement searchByBarcodeField;

    @FindBys({@FindBy(id="documentListForm:documentsComponent:documentList_data")})
    private List<WebElement> documentList;

    public void checkClientDocument(){
        assertTrue(clientDocumentsHeader.isDisplayed());
    }

    public void writeBarcodeToSearchField(String barcode){
        searchByBarcodeField.sendKeys(barcode);
    }

    public void checkCountDocuments(){
        int listSize = documentList.size();
        assertEquals(1,listSize);
    }
}
