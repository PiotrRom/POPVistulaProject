import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Piotr on 2017-03-27.
 */
public class NewProjectAddTest extends MainTest {

    @BeforeMethod
    public void setup() {
        loginPage.loginAsAdmin();
    }

    @Test
    public void shouldAddNewProjectCorrectly() {
        kokpit.goToAdministrationPanel();
        projectPage.addNewProject();
        projectPage.setNameForNewProject("Projekt"+ generateRandomNumber(3));
        projectPage.setPrefixField(generateRandomLetters(3).toUpperCase());
        projectPage.setStatusColorField();
        projectPage.saveNewProject();
        kokpit.goToProjects();
        projectPage.inputNewProjectName();
        projectPage.searchNewProject();

        projectPage.assertThatNewProjectIsCreated();
    }
}
