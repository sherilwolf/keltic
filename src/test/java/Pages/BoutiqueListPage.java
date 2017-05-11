package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 2/29/2016.
 */
public class BoutiqueListPage extends BasePage { //список бутиков в админке

    public static final By addNewBoutique = By.xpath("//span[text()='Добавить новый бутик']");
    public static final By boutiqueTable = By.id("boutiqueGrid_table");

    public static By getBoutiqueLocatorByName(String name) {
        return By.xpath("//td[contains(text(), '" + name + "')]");
    }

    public BoutiqueListPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        url = url + "index.php/admin_boutique/adminhtml_boutique/index/key/";
    }
}
