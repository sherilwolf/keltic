package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 2/29/2016.
 */
public class AdminAuthorisationPage extends BasePage { //авторизация в админку

    public static final By autoLogin = By.id("username");
    public static final By autoPassword = By.id("login");
    public static final By autoButton = By.xpath("//input[@class='form-button']");

    public AdminAuthorisationPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        url = url + "admin/";
    }
}
