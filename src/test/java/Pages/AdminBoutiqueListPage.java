package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Kostya on 12.08.2016.
 */
public class AdminBoutiqueListPage extends BasePage { //список админов бутиков

    public static final By addNewAdminBoutique = By.xpath("//span[text()='Добавить нового администратора бутика']");
    public static final By adminBoutiqueTable = By.id("usersGrid_table");

    public static By getAdminBoutiqueLocatorByName(String name) {
        return By.xpath("//td[contains(text(), '" + name + "')]");
    }

    public AdminBoutiqueListPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        url = url + "index.php/admin_boutique/adminhtml_users/index/key/";
    }
}
