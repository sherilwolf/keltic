package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 2/29/2016.
 */
public class CatalogAdminPage extends BasePage { //страница каталога и товаров в админке

    public static final By manageGeneral = By.xpath("//span[text()='Управление']");
    public static final By manageBoutique = By.xpath("//span[text()='Управление бутиками']");
    public static final By manageAdminBoutique = By.xpath("//span[text()='Управление админами бутиков']");
    public static final By addProduct = By.xpath("//span[text()='Добавить товар']");
    public static final By productTable = By.id("productGrid_table");
    public static final By manageClients = By.xpath("//span[text()='Управление']");

    public static By getProductLocatorByName(String name) {
        return By.xpath("//td[contains(text(), '" + name + "')]");
    }

    public CatalogAdminPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        url = url + "index.php/admin/catalog_product/index/key/";
    }
}
