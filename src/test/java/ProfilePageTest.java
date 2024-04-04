import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import factory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class ProfilePageTest extends TestObject{
    protected WebDriver getWebDriver;
    ChromeDriver webDriver;
    private boolean userReg = false;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        if (webDriver != null) {
            webDriver.close();
        }
        if (userReg == true) {

        }
    }

    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        return new Object[][]{

                {"zer099", "aabbvv", "5663"},

        };
    }

    @Test(dataProvider = "getUser")
    public void ProfilePageTest(String username, String password, String userId) {

        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");
        header.clickLogin();
        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");
        loginPage.fillInUserName(username);
        loginPage.fillInPassword(password);
        loginPage.checkRememberMe();
        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me checkbox is not checked.");
        loginPage.clickSignIn();
        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");
        homePage.navigateTo();
       header.clickExitButton();

    }
}