package factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class HomePage {
    public static final String HOME_URL = "http://training.skillo-bg.com:4200/posts/all";
    private final WebDriver webDriver;
    @FindBy(xpath = "/html/body/app-root/div[2]/app-all-posts/div/div/div[1]/app-post-detail/div/div[2]/div/div[1]/i[1]")
    private WebElement likeButton;


    public HomePage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void navigateTo() {
        this.webDriver.get(HOME_URL);
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(HOME_URL));
    }

    public void clickLikeButton() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(likeButton));
        likeButton.click();
    }


    }
