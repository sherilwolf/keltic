package UsedByAll;

/**
 * Created by Fill on 10.08.2016. Класс для загрузки файла через диалоговое окно браузера
 */

import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class FileUploader {

    // Загрузка файла в диалоговом окне
    public static void uploadFile(File file) throws AWTException, InterruptedException {
        setClipboardData("\"" + file.getAbsolutePath() + "\"");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL); // Нажать ctrl
        robot.keyPress(KeyEvent.VK_V); // Нажать V
        robot.keyRelease(KeyEvent.VK_V); // Отпустить V
        robot.keyRelease(KeyEvent.VK_CONTROL); // Отпустить ctrl
        robot.delay(1000); // Задержка 1с. Без нее не срабатывает нажатие энтера
        robot.keyPress(KeyEvent.VK_ENTER); // Нажать энтер
        robot.keyRelease(KeyEvent.VK_ENTER); // Отпустить энтер
    }

    // Скопировать
    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }
}
