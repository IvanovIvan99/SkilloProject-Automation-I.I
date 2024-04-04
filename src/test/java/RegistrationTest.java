import factory.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class RegistrationTest extends LoginTest{

    ChromeDriver webDriver;

    private boolean userReg = false;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver();


        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        if (webDriver != null) {
            webDriver.close();
        }
        if(userReg == true){

        }
    }

    @DataProvider(name="regUser")
    public Object[][] regUsers(){
        return new Object[][]{

                {"Vanko992","ivan99kr@abv.bg","AABBVVGGDD","AABBVVGGDD"},

        };
    }
@Test
    public void RegistrationTest(String username,String email ,String password, String rePassword){
    HomePage homePage = new HomePage(webDriver);
    Header header= new Header(webDriver);
    LoginPage loginPage= new LoginPage(webDriver);
    RegistrationPage registrationPage = new RegistrationPage(webDriver);
    ProfilePage profilePage = new ProfilePage(webDriver);

    homePage.navigateTo();
    Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

    header.clickLogin();
    Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");

    loginPage.clickRegister();
    Assert.assertTrue(registrationPage.isUrlLoaded(), "Registration page is not loaded");

   registrationPage.fillInUserName(username);
    registrationPage.fillInEmail(email);
    registrationPage.fillInPassword(password);
    registrationPage.reFillPasswordTextField(password);

    registrationPage.clickSignIn();
    header.clickProfile();
    Assert.assertTrue(profilePage.isUrlLoaded(),"Current page is not profile page");
    }


}