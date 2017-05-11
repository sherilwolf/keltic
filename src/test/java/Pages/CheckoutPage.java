package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 2/18/2016.
 */
public class CheckoutPage extends BasePage { //оформление заказа

    //used by all
    public static final By checkoutMethod = By.id("onepage-guest-register-button");
    public static final By firstName = By.id("billing:firstname");
    public static final By lastName = By.id("billing:lastname");
    public static final By email = By.id("billing:email");
    public static final By address = By.id("billing:street1");
    public static final By city = By.id("billing:city");
    public static final By postcode = By.id("billing:postcode");
    public static final By telephone = By.id("billing:telephone");
    public static final By customInformLabel = By.xpath("//label[@for='billing:use_for_shipping_yes']");
    public static final By customInform = By.xpath("//div[@id='billing-buttons-container']/button");
    public static final By deliveryMethodLabel = By.xpath("//label[@for='s_method_flatrate_flatrate']");
    public static final By deliveryMethod = By.xpath("//div[@id='shipping-method-buttons-container']/button");
    public static final By paymentInformLabel = By.xpath("//label[@for='p_method_cashondelivery']");
    public static final By paymentInform = By.xpath("//div[@id='payment-buttons-container']/button");
    public static final By checkOut = By.xpath("//div[@id='review-buttons-container']/button");

    //login
    public static final By cartEmail = By.id("login-email");
    public static final By cartPassword = By.id("login-password");
    public static final By cartLogin = By.xpath("//button[@type='submit']/span/span");

    //as guest
    public static final By checkoutAsGuestLabel = By.xpath("//label[@for='login:guest']");

    //register
    public static final By checkoutRegisterLabel = By.xpath("//label[@for='login:register']");
    public static final By password = By.id("billing:customer_password");
    public static final By confirmPassword = By.id("billing:confirm_password");

    public CheckoutPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        url = url + "checkout/onepage";
    }
}
