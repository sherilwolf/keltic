package Tests;

import Pages.CatalogPage;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.ProductPage;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by User on 2/16/2016.
 */
public class OrderLoginTest extends BaseTest { //оформить заказ с авторизацией
    @Test
    public void userOrderLoginTest(){

        CatalogPage catalogPage = new CatalogPage(driver, wait);
        ProductPage productPage = new ProductPage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);
        CheckoutPage checkoutPage = new CheckoutPage(driver,wait);
        catalogPage.open();
        assertTrue("Page not opened", catalogPage.isOpened());

        //зайти в каталог на фронте и выбрать товар
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogPage.pageLoader));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(catalogPage.pageLoader));
        wait.until(ExpectedConditions.elementToBeClickable(catalogPage.chooseProduct)).click();
        wait.until(ExpectedConditions.titleIs("Обувь конфиг - Мужская обувь - Обувь"));

        //выбрать из селекта параметры товара и добавить в корзину
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogPage.pageLoader));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(catalogPage.pageLoader));
        Select select;
        select = new Select(driver.findElement(productPage.color));
        select.selectByVisibleText("черный");
        select = new Select(driver.findElement(productPage.size));
        select.selectByVisibleText("36");
        driver.findElement(productPage.addToCartButton).click();

        //проверить наличие товара, перейти в корзину, перейти к оформлению
        wait.until(ExpectedConditions.textToBePresentInElementLocated(productPage.cartProductCount, "1"));
        driver.findElement(productPage.cartButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogPage.pageLoader));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(catalogPage.pageLoader));
        assertEquals("Корзина", catalogPage.getTitle());
        driver.findElement(cartPage.cartToCheckout).click();
        assertEquals("Оформить заказ", catalogPage.getTitle());

        //авторизироваться
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogPage.pageLoader));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(catalogPage.pageLoader));
        driver.findElement(checkoutPage.cartEmail).sendKeys("polikarpova.anya@gmail.com");
        driver.findElement(checkoutPage.cartPassword).sendKeys("Renaissance123");
        driver.findElement(checkoutPage.cartLogin).click();

        //оформить заказ
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogPage.pageLoader));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(catalogPage.pageLoader));
        driver.findElement(checkoutPage.customInformLabel).click();
        driver.findElement(checkoutPage.customInform).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.deliveryMethodLabel)).click();
        driver.findElement(checkoutPage.deliveryMethod).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.paymentInformLabel)).click();
        driver.findElement(checkoutPage.paymentInform).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.checkOut)).click();

        System.out.println("OrderLoginTest passed successfully");
    }
}
