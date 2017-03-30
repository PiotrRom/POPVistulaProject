import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by student on 25.03.2017.
 */
public class LoginTest extends MainTest {

    @BeforeMethod
    public void setup() {
        loginPage.open();
    }

    @Test
    public void shouldLoginCorrectly() {
        loginPage
                .setEmail(getAdminMail())
                .setPassword(getAdminPass())
                .clickLoginButton();

                assertThatLoggedIn();
    }
}

