import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(css = "#username")
    WebElement usernameField;

    @FindBy(css = "#password")
    WebElement passwordField;

    @FindBy(css = "[type=submit]")
    WebElement loginButton;

    @FindBy(css = "#flash.flash.error")
    WebElement errorResoult;

    @FindBy(css = "#flash.flash.success")
    WebElement successResoult;

    String wrongLogin = RandomStringUtils.randomAlphabetic(8);
    String wrongPassword = RandomStringUtils.randomAlphanumeric(8);
    String trueLogin = "tomsmith";
    String truePassword = "SuperSecretPassword!";


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void getLoginPage(){
        driver.get("http://the-internet.herokuapp.com/login");
    }

}
