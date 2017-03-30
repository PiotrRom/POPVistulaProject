import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 25.03.2017.
 */
public class LoginPage {
    WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://demo.testarena.pl/zaloguj");
    }

    public LoginPage setEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void loginAsAdmin() {
        driver.get("http://demo.testarena.pl/zaloguj");
        emailField.sendKeys("administrator@testarena.pl");
        passwordField.sendKeys("sumXQQ72$L");
        loginButton.click();
    }
}
