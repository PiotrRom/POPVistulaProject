import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Piotr on 2017-03-27.
 */
public class NewProjectPage {

    WebDriver driver;

    private static String createdProjectName;

    @FindBy(css="a[href='http://demo.testarena.pl/administration/add_project']")
    private WebElement addProjectButton;

    @FindBy(id="name")
    private WebElement projectNameField;

    @FindBy(id="prefix")
    private WebElement prefixField;

    @FindBy(id="save")
    private WebElement saveButton;

    @FindBy(css="input[class='color']")
    private WebElement statusColorField;

    @FindBy(css="span[title='#cc0000']")
    private WebElement redStatusColor;

    @FindBy(xpath = "//div[@class='textLabelEditor']/div[@class='content_label_title']")
    private WebElement projectName;

    @FindBy(id="search")
    private WebElement projectSearchField;

    @FindBy(id="j_searchButton")
    private WebElement searchButton;

    @FindBy(xpath="//a[contains(@href,'http://demo.testarena.pl/administration/project_view/')]")
    private static WebElement projectNameInSearchBox;

    public void setName(String createdProjectName) {
        this.createdProjectName = createdProjectName;
    }

    public NewProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewProject() {
        addProjectButton.click();
    }

    public void setNameForNewProject(String projectName) {
        projectNameField.sendKeys(projectName);
        createdProjectName = projectNameField.getAttribute("value");
    }

    public void setPrefixField(String prefixName) {
        prefixField.sendKeys(prefixName);
    }

    public void setStatusColorField() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", statusColorField);
        executor.executeScript("arguments[0].click();", redStatusColor);
    }

    public void saveNewProject() {
        saveButton.click();
    }

    public void inputNewProjectName() {
        projectSearchField.sendKeys(createdProjectName);
    }

    public void searchNewProject() {
        searchButton.click();
    }

    public void assertThatNewProjectIsCreated() {
        Assert.assertEquals(NewProjectPage.projectNameInSearchBox.getText(), NewProjectPage.createdProjectName);
    }

}