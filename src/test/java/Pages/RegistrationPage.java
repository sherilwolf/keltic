package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Kostya on 15.08.2016.
 */
public class RegistrationPage extends BasePage{ // страница регистрации пользователя на фронте

    public static final By firstName = By.id("firstname");
    public static final By middleName = By.xpath("//input[@name='middlename']");
    public static final By lastName = By.xpath("//input[@name='lastname']");
    public static final By email = By.id("email_address");
    public static final By password = By.id("password");
    public static final By confirmPassword = By.id("confirmation");
    public static final By registrationButton = By.xpath("//span[text()='Зарегистрироваться']");

    public RegistrationPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        url = url + "customer/account/login/";
    }
}
