package Tests;

import Pages.AddAdminBoutiquePage;
import Pages.AdminBoutiqueListPage;
import Pages.CatalogAdminPage;
import UsedByAll.RandomObject;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Kostya on 12.08.2016.
 */

public class AdminRegisterAdminBoutiqueTest extends BaseTest { //регистрация админа бутика

    String adminBoutiqueRandom = RandomObject.generateLatinString(10);

    @Test
    public void userAdminRegisterBoutiqueTest() {

        CatalogAdminPage catalogAdminPage = new CatalogAdminPage(driver, wait);
        AdminBoutiqueListPage adminBoutiqueListPage = new AdminBoutiqueListPage(driver, wait);
        AddAdminBoutiquePage addAdminBoutiquePage = new AddAdminBoutiquePage(driver, wait);

        //авторизироваться
        AdminAuthorisationTest.authoriseAsAdmin(driver, wait);

        //перейти из каталога в список админов бутиков
        driver.findElement(catalogAdminPage.manageGeneral).click();
        driver.findElement(catalogAdminPage.manageAdminBoutique).click();
        driver.findElement(adminBoutiqueListPage.addNewAdminBoutique).click();

        //добавить нового админа бутика
        Select select = new Select(driver.findElement(addAdminBoutiquePage.chooseBoutique));
        select.selectByVisibleText("Botanic");
        driver.findElement(addAdminBoutiquePage.userName).sendKeys(adminBoutiqueRandom);
        driver.findElement(addAdminBoutiquePage.firstName).sendKeys(adminBoutiqueRandom);
        driver.findElement(addAdminBoutiquePage.lastName).sendKeys(adminBoutiqueRandom);
        driver.findElement(addAdminBoutiquePage.email).sendKeys("adminboutique@gmail.com");
        Select statusSelect = new Select(driver.findElement(addAdminBoutiquePage.status));
        statusSelect.selectByValue("1");
        driver.findElement(addAdminBoutiquePage.currentPassword).sendKeys("admin123");
        driver.findElement(addAdminBoutiquePage.password).sendKeys("qwerty123");
        driver.findElement(addAdminBoutiquePage.confirmPassword).sendKeys("qwerty123");
        driver.findElement(addAdminBoutiquePage.adminBoutiqueSave).click();

        //найти нового админа бутика в списке и удалить
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminBoutiqueListPage.getAdminBoutiqueLocatorByName(adminBoutiqueRandom))).click();
        driver.findElement(addAdminBoutiquePage.adminBoutiqueDelete).click();
        driver.switchTo().alert().accept(); // перейти на алерт и принять

        //проверить, что админа бутика в списке нет
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminBoutiqueListPage.adminBoutiqueTable));
        try {
            driver.findElement(adminBoutiqueListPage.getAdminBoutiqueLocatorByName(adminBoutiqueRandom));
            assertTrue("Link is not present", false);
        } catch (NoSuchElementException ex) {
            /* do nothing, element is not present, assert is passed */
        }
        System.out.println("AdminRegisterAdminBoutiqueTest passed successfully");
    }
}
