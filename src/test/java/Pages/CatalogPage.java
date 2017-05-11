package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 2/16/2016.
 */
public class CatalogPage extends BasePage { //каталог товаров на фронте

    //public static final By pageLoader = By.xpath("//div[@class='page-loader']"); наследуем от главной
    public static final By chooseProduct = By.xpath("//a[text()='Обувь конфиг']"); //a[contains(text(), 'Обувь конфиг')]

    public CatalogPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        url = url + "shoes/muzhskaja-obuv/";
    }
}
