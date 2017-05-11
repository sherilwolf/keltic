package Tests;

import Pages.CatalogPage;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.ProductPage;
import UsedByAll.RandomObject;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by User on 2/18/2016.
 */
public class OrderRegisterTest extends BaseTest { //оформить заказ с регистрацией
    @Test
    public void userOrderRegisterTest(){

        CatalogPage catalogPage = new CatalogPage(driver, wait);
        ProductPage productPage = new ProductPage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);
        CheckoutPage checkoutPage = new CheckoutPage(driver,wait);
        catalogPage.open();
        assertTrue("Page not opened", catalogPage.isOpened());

        //сгенерировать почту
        String randomString = RandomObject.generateLatinString(7);
        String email = randomString + "@mailforspam.com";
        System.out.println(email);

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

        //заполнить поля для регистрации
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogPage.pageLoader));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(catalogPage.pageLoader));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.checkoutRegisterLabel)).click();
        driver.findElement(checkoutPage.checkoutMethod).click();
        driver.findElement(checkoutPage.firstName).sendKeys("Anya");
        driver.findElement(checkoutPage.lastName).sendKeys("Polikarpova");
        driver.findElement(checkoutPage.email).sendKeys(email);
        driver.findElement(checkoutPage.address).sendKeys("Vishnyakovskaya, 3");
        driver.findElement(checkoutPage.city).sendKeys("Kiev");
        driver.findElement(checkoutPage.postcode).sendKeys("02140");
        driver.findElement(checkoutPage.telephone).sendKeys("0667846629");
        driver.findElement(checkoutPage.password).sendKeys("Renaissance123");
        driver.findElement(checkoutPage.confirmPassword).sendKeys("Renaissance123");

        //оформить заказ
        driver.findElement(checkoutPage.customInformLabel).click();
        driver.findElement(checkoutPage.customInform).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.deliveryMethodLabel)).click();
        driver.findElement(checkoutPage.deliveryMethod).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.paymentInformLabel)).click();
        driver.findElement(checkoutPage.paymentInform).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.checkOut)).click();

        System.out.println("OrderRegisterTes passed successfully");
    }
}
