import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 25.03.2017.
 */
public class KokpitPage {
    WebDriver driver;

    @FindBy(css = "a[href='http://demo.testarena.pl/versions']")
    private WebElement versionButton;

    @FindBy(css = "a[href='http://demo.testarena.pl/wyloguj']")
    private WebElement logoutButton;

    @FindBy(css = "a[href='http://demo.testarena.pl/administration']")
    private WebElement administrationButton;

    @FindBy(css ="a[href='http://demo.testarena.pl/administration/projects']")
    private WebElement projectsButton;

    public KokpitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToVersion() {
        versionButton.click();
    }

    public void goToAdministrationPanel() {
        administrationButton.click();
    }

    public boolean logoutButtonisVisible() {
        return logoutButton.isDisplayed();
    }

    public void goToProjects() {
        projectsButton.click();
    }
}
