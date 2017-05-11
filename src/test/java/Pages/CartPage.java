package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 2/16/2016.
 */
public class CartPage extends BasePage { //корзина
    public static final By cartToCheckout = By.xpath("//button[@class='button btn-proceed-checkout btn-checkout']");

    public CartPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        url = url + "checkout/cart/";
    }
}
