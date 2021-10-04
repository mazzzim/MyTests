import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tests {
    public static WebDriver driver;
    public CheckBoxPage checkboxPage;
    public DynamicElementPage dynamicElementPage;

    @BeforeAll
    public static void createAndStartService() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Test
        public void changeCheckBox (){
        //TO DO add a test which goes to http://the-internet.herokuapp.com/checkboxes URL and check checkbox
        //Verify checkbox is checked in the test
        checkboxPage = new CheckBoxPage(driver);
        checkboxPage.getCheckBoxPage();
        checkboxPage.clickCheckBox1();
        assertEquals(checkboxPage.checkBox1.isSelected() , checkboxPage.checkBox2.isSelected());
    }
    @Test
    public void dynamicElement(){
        //TO DO add a test which goes to http://the-internet.herokuapp.com/entry_ad URL and closes the pop-up
        //then it clicks `click here.` link and checks `THIS IS A MODAL WINDOW` text is displayed on the page
        dynamicElementPage = new DynamicElementPage(driver);
        dynamicElementPage.getDynamicElementPage();
        dynamicElementPage.closePopUp();
        dynamicElementPage.openPopUp();
        dynamicElementPage.textIsDisplay();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit(); }
}

