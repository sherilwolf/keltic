package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Kostya on 16.08.2016.
 */
public class AddSimpleProductPage extends BasePage { //страница симпл товара в админке

    public static final By simpleProductStatus = By.id("simple_product_status");
    public static final By simpleProductVisibility = By.id("simple_product_visibility");
    public static final By simpleProductColor = By.id("simple_product_color");
    public static final By simpleProductSize = By.id("simple_product_shoes");
    public static final By simpleProductQty = By.id("simple_product_inventory_qty");
    public static final By simpleProductStock = By.id("simple_product_inventory_is_in_stock");
    public static final By simpleProductCreate = By.xpath("//span[text()='Быстрое создание']");

    public static final By simpleLoader = By.id("loading_mask_loader");

    public static final By save = By.xpath("//span[text()='Сохранить']");

    public AddSimpleProductPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        url = url + "http://keltic.t4web.com.ua/index.php/admin/catalog_product/edit/id/1056/back/edit/tab/product_info_tabs_configurable/attributes/MjA0LDky/set/12/type/configurable/key/";
    }
}
