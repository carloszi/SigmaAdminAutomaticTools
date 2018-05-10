package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertTrue;

/**
 * Created by zieli_k on 2018-04-24.
 */
public class OperationsHomePage extends  AbstractPage{


    public OperationsHomePage (WebDriver driver){
        super(driver);
    }

    @FindBy(id = "LoginForm:username")
    private WebElement field_userName;

    @FindBy(id="LoginForm:password")
    private WebElement field_password;

    @FindBy(id="LoginForm:loginCmdLink")
    private WebElement btn_login;

    @FindBy(id="LoginForm:headerText")
    private WebElement loginDataHeader;

    public void loginOperationsWeb(){
        field_userName.sendKeys("jmeter1");
        field_password.sendKeys("Haslo123");
        btn_login.click();
    }

    public void checkLoginDataHeader(){
        assertTrue(loginDataHeader.isDisplayed());
    }

}
