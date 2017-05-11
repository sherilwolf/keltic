package Tests;

import Pages.LogInPage;
import UsedByAll.Config;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static junit.framework.TestCase.assertEquals;

import static org.junit.Assert.assertTrue;

/**
 * Created by User on 2/11/2015.
 */
public class LogInTest extends BaseTest {

    @Test
    public void userLogInTest(){

        LogInPage logInPage = new LogInPage(driver, wait);
        logInPage.open();
        assertTrue("Page not opened", logInPage.isOpened());

        wait.until(ExpectedConditions.visibilityOfElementLocated(logInPage.pageLoader));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(logInPage.pageLoader));

        driver.findElement(logInPage.email).sendKeys(Config.getConfig().getBaseUser().getEmail());
        driver.findElement(logInPage.password).sendKeys(Config.getConfig().getBaseUser().getPassword1());
        driver.findElement(logInPage.logInButton).click();
        assertEquals(logInPage.getTitle(), "Моя учётная запись");

        System.out.println("LogInTest passed successfully");
    }
}
