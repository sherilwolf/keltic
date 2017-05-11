package Tests;

import Pages.AdminAuthorisationPage;
import UsedByAll.Config;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Kostya on 16.08.2016.
 */
public class AdminAuthorisationTest extends BaseTest { //авторизироваться в админке

    @Test
    public void userAdminAuthorisationTest() {
        authoriseAsAdmin(driver, wait);
    }

    public static void authoriseAsAdmin(WebDriver driver, WebDriverWait wait) {
        AdminAuthorisationPage adminAuthorisationPage = new AdminAuthorisationPage(driver, wait);
        adminAuthorisationPage.open();
        assertTrue("Page not opened", adminAuthorisationPage.isOpened());

        System.out.println(Config.getConfig().getAdmin().getEmail());
        driver.findElement(adminAuthorisationPage.autoLogin).sendKeys(Config.getConfig().getAdmin().getEmail());
        driver.findElement(adminAuthorisationPage.autoPassword).sendKeys(Config.getConfig().getAdmin().getPassword1());
        driver.findElement(adminAuthorisationPage.autoButton).click();
        assertEquals("Управление товарами / Каталог / Панель администрирования Magento", adminAuthorisationPage.getTitle());

        System.out.println("AdminAuthorisationTest passed successfully");
    }
}
