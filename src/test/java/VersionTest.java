import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by student on 25.03.2017.
 */
public class VersionTest extends MainTest {

    @BeforeMethod
    public void setup() {
        loginPage.loginAsAdmin();
    }

    @Test
    public void shouldAddNewVersionCorrectly() {
        kokpit.goToVersion();
        version.addNewVersion();
        version.setNameForNewVersion("Wersja" + version.generateRandomNumber(2));
        version.clickSaveButton();
    }
}
