package Tests;

import Pages.RegistrationPage;
import UsedByAll.Config;
import UsedByAll.GmailMessager;
import UsedByAll.RandomObject;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.mail.MessagingException;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by Kostya on 15.08.2016.
 */
public class RegistrationTest extends BaseTest { //регистрация пользователя на фронте

@Test
    public void userRegistrationTest() throws IOException, MessagingException {
    GmailMessager gmailMessager = new GmailMessager();
    String currentMessageTime="";
    String newMessageTime="";
    String confirmLink = "http://" + Config.getConfig().getScheme() + "customer/account/confirm/?back_url=http%3A%2F%2Fkeltic.t4web.com.ua%2F&amp;id=";

    try {
        //gmailMessager.initializePOP3(testUser);
        currentMessageTime = gmailMessager.getLastMessageTime("Pashunya2013", "bratuhina.anya@gmail.com");
        // System.out.println("Current last message time: " + currentMessageTime);
    } catch (MessagingException e) {
        e.printStackTrace();
    }

    RegistrationPage registrationPage = new RegistrationPage(driver, wait);
    registrationPage.open();
    assertTrue("Page not opened", registrationPage.isOpened());

    //сгенерировать данные
    String registrationRandom = RandomObject.generateLatinString(7);

    wait.until(ExpectedConditions.visibilityOfElementLocated(registrationPage.pageLoader));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(registrationPage.pageLoader));

    //заполнить поля, зарегистрироваться
    driver.findElement(registrationPage.firstName).sendKeys(registrationRandom);
    driver.findElement(registrationPage.middleName).sendKeys(registrationRandom);
    driver.findElement(registrationPage.lastName).sendKeys(registrationRandom);
    driver.findElement(registrationPage.email).sendKeys("bratuhina.anya@gmail.com");
    driver.findElement(registrationPage.password).sendKeys("Renaissance123");
    driver.findElement(registrationPage.confirmPassword).sendKeys("Renaissance123");
    driver.findElement(registrationPage.registrationButton).click();

    //подтвердить регистрацию в почте
    int count = 1; // счетчик, если равно 100, выйти из цикла
    do {
        try {
            //gmailMessager.initializePOP3(testUser);
            newMessageTime = gmailMessager.getLastMessageTime("Pashunya2013", "bratuhina.anya@gmail.com");
            //System.out.println("New last message time: " + newMessageTime);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        count++;
        if (count == 5) break;
    }while(currentMessageTime.equals(newMessageTime));
    String activationLink = gmailMessager.openAndReturnLink("Pashunya2013", "bratuhina.anya@gmail.com", "Подтверждение учётной записи", confirmLink);
    activationLink = activationLink.replace("amp;", ""); // привести ссылку активации к нужному виду
    driver.get(activationLink);
    //Дальше скорей всего надо перейти в профиль и проверить, что на странице есть имя пользователя, который зарегистрировался. Это будет критерием успешного прохождения теста
    }
}
