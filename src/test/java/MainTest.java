import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

/**
 * Created by student on 25.03.2017.
 */
public class MainTest {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    KokpitPage kokpit = new KokpitPage(driver);
    VersionPage version = new VersionPage(driver);
    NewProjectPage projectPage = new NewProjectPage(driver);

    private String adminMail = "administrator@testarena.pl";
    private String adminPass = "sumXQQ72$L";


    public String getAdminMail() {
        return adminMail;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomLetters(int numberOfLetters) {
        return RandomStringUtils.randomAlphabetic(numberOfLetters);
    }

    public void assertThatLoggedIn() {
        Assert.assertTrue(kokpit.logoutButtonisVisible());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
