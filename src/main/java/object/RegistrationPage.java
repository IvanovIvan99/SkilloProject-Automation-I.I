package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    public static final String REGPAGE_URL = "http://training.skillo-bg.com:4200/users/register";
    private final WebDriver webDriver;

    public RegistrationPage(WebDriver driver){
        this.webDriver = driver;
    }
    public boolean regIsUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(REGPAGE_URL));
    }
    public void regFillInUserName(String username){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement usernameTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//app-root/div[2]/app-register/div/div/form/div[1]/input"))));
        usernameTextField.sendKeys(username);
    }
    public void fillInEmail(String email) {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement usernameTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("app-root/div[2]/app-register/div/div/form/div[2]/input"))));
        usernameTextField.sendKeys(email);
    }
    public void regFillInPassword(String password) {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement usernameTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("///*[@id=\"defaultRegisterFormPassword\"]"))));
        usernameTextField.sendKeys(password);

    }
    public void regReFillInPassword(String password) {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement usernameTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//*[@id=\"defaultRegisterPhonePassword\"]"))));
        usernameTextField.sendKeys(password);
    }
        public void clickSignIn(){
           WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("sign-in-button"))));
            signInButton.click();
        }
    }


