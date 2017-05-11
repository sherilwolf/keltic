package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Kostya on 12.08.2016.
 */
public class AddAdminBoutiquePage  extends BasePage { //добавить нового админа бутика

    public static final By chooseBoutique = By.id("store_id");
    public static final By userName = By.id("username");
    public static final By firstName = By.id("firstname");
    public static final By lastName = By.id("lastname");
    public static final By email = By.id("email");
    public static final By status = By.id("is_active");
    public static final By currentPassword = By.id("current_password");
    public static final By password = By.id("password");
    public static final By confirmPassword = By.id("confirmation");
    public static final By adminBoutiqueSave = By.xpath("//span[text()='Сохранить пользователя']");
    public static final By adminBoutiqueDelete = By.xpath("//span[text()='Удалить пользователя']");

    public AddAdminBoutiquePage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        url = url + "index.php/admin_boutique/adminhtml_users/new/key/";
    }
}
