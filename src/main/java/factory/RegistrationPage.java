package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class RegistrationPage {
    public static final String REGPAGE_URL = "http://training.skillo-bg.com:4200/users/register";
    private final WebDriver webDriver;
    @FindBy(xpath ="//app-root/div[2]/app-register/div/div/form/div[1]/input")
    private WebElement usernameTextField;
    @FindBy(xpath = "app-root/div[2]/app-register/div/div/form/div[2]/input")
    private WebElement  emailTextfield;
    @FindBy(xpath = "///*[@id=\"defaultRegisterFormPassword\"]")
    private WebElement passwordTextField;
    @FindBy (xpath = "//*[@id=\"defaultRegisterPhonePassword\"]")
    private WebElement  reFillPasswordTextField;
    @FindBy(id = "//*[@id=\"sign-in-button\"]")
    private WebElement signInButton;

    public RegistrationPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(REGPAGE_URL));
    }

    public void fillInUserName(String username){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(usernameTextField));
        usernameTextField.sendKeys(username);
    }
    public void fillInEmail (String email) {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(emailTextfield));
        emailTextfield.sendKeys(email);
    }
    public void fillInPassword(String password){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(reFillPasswordTextField));
        reFillPasswordTextField.sendKeys(password);
    }
    public void reFillPasswordTextField(String password){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(passwordTextField));
        passwordTextField.sendKeys(password);

    }

    public void clickSignIn(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public void navigateTo() {
        this.webDriver.get(REGPAGE_URL);
    }

    public void completeSingIn(String username, String email, String password, String repassword){
        fillInUserName(username);
        fillInEmail(email);
        fillInPassword(password);
        reFillPasswordTextField(repassword);
        clickSignIn();
    }


}
