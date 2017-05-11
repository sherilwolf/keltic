package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 2/11/2016.
 */
public class LogInPage extends BasePage{

    //public static final By pageLoader = By.xpath("//div[@class='page-loader']"); наследуем от главной
    public static final By email = By.id("email");
    public static final By password = By.id("pass");
    public static final By logInButton = By.id("send2");

    public LogInPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        url = url + "customer/account/login/";
    }
}
