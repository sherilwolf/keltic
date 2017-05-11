package Tests;

import Pages.AddConfigProductPage;
import Pages.AddSimpleProductPage;
import Pages.CatalogAdminPage;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;


/**
 * Created by Kostya on 15.08.2016.
 */
public class AddProductTest extends BaseTest { //добавить новый товар

    @Test
    public void userAddProductTest(){

        CatalogAdminPage catalogAdminPage = new CatalogAdminPage(driver, wait);
        AddConfigProductPage addConfigProductPage = new AddConfigProductPage(driver, wait);
        AddSimpleProductPage addSimpleProductPage = new AddSimpleProductPage(driver, wait);

        //авторизироваться
        AdminAuthorisationTest.authoriseAsAdmin(driver, wait);

        //добавить новый товар
        driver.findElement(catalogAdminPage.addProduct).click();
        Select setOfAttributesSelect = new Select(driver.findElement(addConfigProductPage.setOfAttributes));
        setOfAttributesSelect.selectByVisibleText("Обувь");
        Select typeOfProductSelect = new Select(driver.findElement(addConfigProductPage.typeOfProduct));
        typeOfProductSelect.selectByValue("configurable");
        driver.findElement(addConfigProductPage.continueButton).click();
        driver.findElement(addConfigProductPage.size).click();
        driver.findElement(addConfigProductPage.color).click();
        driver.findElement(addConfigProductPage.continueButton).click();
        driver.findElement(addConfigProductPage.name).sendKeys("Тестовый товар");
        driver.findElement(addConfigProductPage.sku).sendKeys("99999");
        Select statusSelect = new Select(driver.findElement(addConfigProductPage.status));
        statusSelect.selectByValue("1");
        Select ownerSelect = new Select(driver.findElement(addConfigProductPage.owner));
        ownerSelect.selectByVisibleText("Florida");
        driver.findElement(addConfigProductPage.priceTab).click();
        driver.findElement(addConfigProductPage.price).sendKeys("555");
        driver.findElement(addConfigProductPage.stockTab).click();
        Select stockSelect = new Select(driver.findElement(addConfigProductPage.stock));
        stockSelect.selectByValue("1");
        driver.findElement(addConfigProductPage.categoryTab).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addConfigProductPage.categoryShoes)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addConfigProductPage.categoryMenShoes)).click();
        driver.findElement(addConfigProductPage.groupOfProducts).click();
        driver.findElement(addConfigProductPage.saveAndContinue).click();

        //быстрое создание симпл товаров в конфиге
        wait.until(ExpectedConditions.visibilityOfElementLocated(addSimpleProductPage.simpleProductStatus));
        Select simpleProductStatusSelect = new Select(driver.findElement(addSimpleProductPage.simpleProductStatus));
        simpleProductStatusSelect.selectByValue("1");
        Select simpleProductVisibilitySelect = new Select(driver.findElement(addSimpleProductPage.simpleProductVisibility));
        simpleProductVisibilitySelect.selectByVisibleText("Каталог, поиск");
        Select simpleProductColorSelect = new Select(driver.findElement(addSimpleProductPage.simpleProductColor));
        simpleProductColorSelect.selectByVisibleText("зеленый");
        Select simpleProductSizeSelect = new Select(driver.findElement(addSimpleProductPage.simpleProductSize));
        simpleProductSizeSelect.selectByVisibleText("37");
        driver.findElement(addSimpleProductPage.simpleProductQty).sendKeys("200");
        Select simpleProductStockSelect = new Select(driver.findElement(addSimpleProductPage.simpleProductStock));
        simpleProductStockSelect.selectByValue("1");
        driver.findElement(addSimpleProductPage.simpleProductCreate).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(addSimpleProductPage.simpleLoader));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(addSimpleProductPage.simpleLoader));

        driver.findElement(addSimpleProductPage.save).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(addSimpleProductPage.simpleLoader));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(addSimpleProductPage.simpleLoader));

        //найти симпл товар в списке и удалить
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogAdminPage.getProductLocatorByName("Тестовый товар-зеленый-37"))).click();
        driver.findElement(addConfigProductPage.delete).click();
        driver.switchTo().alert().accept(); // перейти на алерт и принять

        //найти конфиг товар в списке и удалить
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogAdminPage.getProductLocatorByName("Тестовый товар"))).click();
        driver.findElement(addConfigProductPage.delete).click();
        driver.switchTo().alert().accept(); // перейти на алерт и принять

        //проверить, что симпл товар из списка удален
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogAdminPage.productTable));
        try {
            driver.findElement(catalogAdminPage.getProductLocatorByName("Тестовый товар-зеленый-37"));
            assertTrue("Link is not present", false);
        } catch (NoSuchElementException ex) {
            /* do nothing, element is not present, assert is passed */
        }

        //проверить, что конфиг товар из списка удален
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogAdminPage.productTable));
        try {
            driver.findElement(catalogAdminPage.getProductLocatorByName("Тестовый товар"));
            assertTrue("Link is not present", false);
        } catch (NoSuchElementException ex) {
            /* do nothing, element is not present, assert is passed */
        }

        System.out.println("AddProductTest passed successfully");
    }
}

