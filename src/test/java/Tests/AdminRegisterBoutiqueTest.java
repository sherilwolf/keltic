package Tests;


import Pages.AddBoutiquePage;
import Pages.BoutiqueListPage;
import Pages.CatalogAdminPage;
import UsedByAll.FileUploader;
import UsedByAll.RandomObject;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.File;
import org.openqa.selenium.NoSuchElementException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by User on 2/29/2016.
 */
public class AdminRegisterBoutiqueTest extends BaseTest { //регистрация бутика

    File file = new File("testfile.jpg"); // Определяем файл аттача
    String boutiqueRandom = RandomObject.generateLatinString(10);

    @Test
    public void userAdminRegisterBoutiqueTest() throws InterruptedException, AWTException {
        CatalogAdminPage catalogAdminPage = new CatalogAdminPage(driver, wait);
        BoutiqueListPage boutiqueListPage = new BoutiqueListPage(driver, wait);
        AddBoutiquePage addBoutiquePage = new AddBoutiquePage(driver, wait);

        //авторизироваться
        AdminAuthorisationTest.authoriseAsAdmin(driver, wait);

        //перейти из каталога в список бутиков
        driver.findElement(catalogAdminPage.manageGeneral).click();
        driver.findElement(catalogAdminPage.manageBoutique).click();
        driver.findElement(boutiqueListPage.addNewBoutique).click();

        //добавить новый бутик
        driver.findElement(addBoutiquePage.boutiqueName).sendKeys(boutiqueRandom);
        driver.findElement(addBoutiquePage.boutiqueIdentifier).sendKeys(boutiqueRandom);
        Select statusSelect = new Select(driver.findElement(addBoutiquePage.boutiqueStatus));
        statusSelect.selectByValue("1");
        driver.findElement(addBoutiquePage.boutiqueImage).click();
        FileUploader.uploadFile(file); // Аплоадим файл
        driver.findElement(addBoutiquePage.boutiqueOwner).sendKeys("Sheril Wolf");
        driver.findElement(addBoutiquePage.boutiquePhone).sendKeys("0667846629");
        driver.findElement(addBoutiquePage.boutiqueStreet).sendKeys("Vishnyakovskaya");
        driver.findElement(addBoutiquePage.boutiqueCity).sendKeys("Kiev");
        driver.findElement(addBoutiquePage.boutiqueCountry).sendKeys("Ukraina");
        driver.findElement(addBoutiquePage.boutiqueDescription).sendKeys("good butik");
        driver.findElement(addBoutiquePage.boutiqueSave).click();

        //найти новый бутик в списке бутиков и удалить
        wait.until(ExpectedConditions.visibilityOfElementLocated(boutiqueListPage.getBoutiqueLocatorByName(boutiqueRandom))).click();
        driver.findElement(addBoutiquePage.boutiqueDelete).click();
        driver.switchTo().alert().accept(); // перейти на алерт и принять

        //проверить, что бутика в списке бутиков нет
        wait.until(ExpectedConditions.visibilityOfElementLocated(boutiqueListPage.boutiqueTable));
        try {
            driver.findElement(boutiqueListPage.getBoutiqueLocatorByName(boutiqueRandom));
            assertTrue("Link is not present", false);
        } catch (NoSuchElementException ex) {
            /* do nothing, element is not present, assert is passed */
        }
        System.out.println("AdminRegisterBoutiqueTest passed successfully");
    }
}
