package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Kostya on 15.08.2016.
 */
public class AddConfigProductPage extends BasePage { //страница конфиг товара в админке

    public static final By setOfAttributes = By.id("attribute_set_id");
    public static final By typeOfProduct = By.id("product_type");
    public static final By continueButton = By.xpath("//span[text()='Продолжить']");
    public static final By size = By.id("attribute_204");
    public static final By color = By.id("attribute_92");
    public static final By name = By.id("name");
    public static final By sku = By.id("sku");
    public static final By status = By.id("status");
    public static final By owner = By.id("amrolepermissions_owner");
    public static final By priceTab = By.id("product_info_tabs_group_55");
    public static final By price = By.id("price");
    public static final By stockTab = By.xpath("//span[text()='Склад']");
    public static final By stock = By.id("inventory_stock_availability");
    public static final By categoryTab = By.xpath("//a[@title='Категории']/span");
    public static final By categoryShoes = By.xpath("//span[contains(text(), 'Обувь')]");
    public static final By categoryMenShoes = By.xpath("//span[contains(text(), 'Мужская обувь')]");
    public static final By groupOfProducts = By.xpath("//span[text()='Объединённые товары']");
    public static final By saveAndContinue = By.xpath("//span[text()='Сохранить и продолжить редактирование']");
    public static final By delete = By.xpath("//span[text()='Удалить']");

    public AddConfigProductPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        url = url + "index.php/admin/catalog_product/new/key/";
    }
}
