package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by zieli_k on 2018-03-28.
 */
public class AdminMenuPage extends AbstractPage {

    public AdminMenuPage(WebDriver driver){
        super(driver);
    }


    @FindBy(id = "ToolbarForm:domain_label")
    private WebElement btn_MenuArrow;

    @FindBy (xpath = "//*[@title='STRATEGY']")
    private WebElement btn_StrategyPanel;


    public void goToActionDefinitionList()  throws InterruptedException{
        btn_MenuArrow.click();
        Thread.sleep(500);
        btn_StrategyPanel.click();
        Thread.sleep(2000);
    }
}
