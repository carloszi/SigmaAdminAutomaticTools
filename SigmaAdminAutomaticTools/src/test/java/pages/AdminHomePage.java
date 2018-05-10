package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by zieli_k on 2018-03-28.
 */
public class AdminHomePage extends AbstractPage {
    /*private WebDriver driver;

    public AdminHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }*/

    public AdminHomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "BreadCrumb")
    public WebElement lbl_MainSite;

    @FindBy(xpath = "//*[@id=\"ToolbarForm:loginMenuBtn\"]/span[1]")
    private WebElement btn_LogoutIcon;

    @FindBy(id = "ToolbarForm:logoutButton")
    private WebElement btn_Logut;

    public void logoutFromAdmin(){
        btn_LogoutIcon.click();
        btn_Logut.click();
    }
}
