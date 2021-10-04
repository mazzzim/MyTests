import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DynamicElementPage {
    WebDriver driver;

    public DynamicElementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void getDynamicElementPage(){
        driver.get("http://the-internet.herokuapp.com/entry_ad");
    }
    public void closePopUp(){
        WebElement closePopUpButton = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".modal-footer>p")));
        closePopUpButton.click();
    }
    public void openPopUp(){
        WebElement openPopUpButton = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("p>#restart-ad")));
        openPopUpButton.click();
    }
    public void textIsDisplay(){
        WebElement textIsDisplay= new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".modal-title>h3")));
        textIsDisplay.isDisplayed();
    }
}
