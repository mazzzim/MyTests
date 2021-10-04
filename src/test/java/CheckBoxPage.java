import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {
    WebDriver driver;

    @FindBy(css = "#checkboxes input:first-of-type")
    WebElement checkBox1;

    @FindBy(css = "#checkboxes input:last-of-type")
    WebElement checkBox2;

    public CheckBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void getCheckBoxPage(){
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }
    public void clickCheckBox1() {
        checkBox1.click();
    }

//    public WebElement getcheckBox1() {
//        return checkBox1;
//    }
//    public WebElement getcheckBox2() {
//        return checkBox2;
//    }
}
