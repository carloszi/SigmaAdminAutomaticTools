package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by zieli_k on 2018-03-28.
 */
public class AdminLoginPage extends AbstractPage {

    public AdminLoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="LoginForm:username")
    protected WebElement txtbx_Login;

    @FindBy(id="LoginForm:password")
    protected WebElement txtbx_Password;

    @FindBy (id="LoginForm:loginCmdLink")
    protected WebElement btn_Login;

    @FindBy (xpath = "/html/body/div[1]/div/div/div[1]/div/div[2]")
    public WebElement lbl_AdminWeb;

    public void loginToAdmin(){
        txtbx_Login.sendKeys("jmeter1");
        txtbx_Password.sendKeys("Haslo123");
        btn_Login.click();
    }

}
