package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 2/29/2016.
 */
public class AddBoutiquePage extends BasePage { //добавить новый бутик

    public static final By boutiqueName = By.id("name");
    public static final By boutiqueIdentifier = By.id("identifier");
    public static final By boutiqueStatus = By.id("is_active");
    public static final By boutiqueImage = By.id("image");
    public static final By boutiqueOwner = By.id("owner");
    public static final By boutiquePhone = By.id("telephone");
    public static final By boutiqueStreet = By.id("address");
    public static final By boutiqueCity = By.id("city");
    public static final By boutiqueCountry = By.id("country");
    public static final By boutiqueDescription = By.id("description");
    public static final By boutiqueSave = By.xpath("//span[text()='Сохранить бутик']");
    public static final By boutiqueDelete = By.xpath("//span[text()='Удалить бутик']");

    public AddBoutiquePage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        url = url + "index.php/admin_boutique/adminhtml_boutique/new/key/";
    }
}
