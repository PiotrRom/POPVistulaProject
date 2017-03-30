import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 25.03.2017.
 */
public class VersionPage {

    WebDriver driver;

    @FindBy(css = "a[href='http://demo.testarena.pl/add_version']")
    private WebElement addVersionButton;

    @FindBy(id = "name")
    private WebElement nameVersionField;

    @FindBy(id = "save")
    private WebElement saveVersionButton;

    public VersionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public void addNewVersion() {
        addVersionButton.click();
    }

    public void setNameForNewVersion(String nameVersion) {
        nameVersionField.sendKeys(nameVersion);
    }

    public void clickSaveButton() {
        saveVersionButton.click();
    }

}
