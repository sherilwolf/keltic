package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 2/29/2016.
 */
public class ProductPage extends BasePage{ //страница товара на фронте

    public static final By color = By.id("attribute92");
    public static final By size = By.id("attribute204");
    public static final By addToCartButton = By.xpath("//button[@class='button btn-cart']");
    public static final By cartProductCount = By.xpath("//span[@class='qty-cart']");
    public static final By cartButton = By.xpath("//i[@class='icon-handbag icons']");

    public ProductPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        url = url + "obuv-konfig/";
    }
}
