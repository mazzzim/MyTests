import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tests {
    public static WebDriver driver;
    public CheckBoxPage checkboxPage;
    public DynamicElementPage dynamicElementPage;
    public LoginPage loginPage;
    public DynamicLoadingPage dynamicLoadingPage;
    public DownloadFilePage downloadFilePage;

    @BeforeAll
    public static void createAndStartService() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
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
        //BugReport #......
        dynamicElementPage = new DynamicElementPage(driver);
        dynamicElementPage.getDynamicElementPage();
        dynamicElementPage.closePopUp();
        dynamicElementPage.openPopUp();
        dynamicElementPage.textIsDisplay();
    }

    @Test
    public void testInvalidLogin(){
        //TO DO add a test which goes to http://the-internet.herokuapp.com/login URL and fills in incorrect details
        //then it clicks `Login` button
        //Here should be a check on error message is displayed on the page
        loginPage = new LoginPage(driver);
        loginPage.getLoginPage();
        loginPage.usernameField.sendKeys(loginPage.wrongLogin);
        loginPage.passwordField.sendKeys(loginPage.wrongPassword);
        loginPage.loginButton.click();
        loginPage.errorResoult.isDisplayed();
    }

    @Test
    public void testValidLogin (){
        //TO DO add a test which goes to http://the-internet.herokuapp.com/login URL and fills in correct details
        //then it clicks `Login` button
        //Here should be a check that user is logged in and a new content is displayed
        loginPage = new LoginPage(driver);
        loginPage.getLoginPage();
        loginPage.usernameField.sendKeys(loginPage.trueLogin);
        loginPage.passwordField.sendKeys(loginPage.truePassword);
        loginPage.loginButton.click();
        loginPage.successResoult.isDisplayed();
    }

    @Test
    public void testDynamicLoadingElement(){
        //TO DO add a test which goes to  http://the-internet.herokuapp.com/dynamic_loading/1 URL and
        //clicks start button
        //Here should be a check that Hello World text is displayed
        dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.getDynamicLoadingPage();
        dynamicLoadingPage.startButton.click();
        dynamicLoadingPage.successLoading();
    }

    @Test
    public void testDownloadFile(){
        //TO DO add a test which goes to http://the-internet.herokuapp.com/jqueryui/menu URL and
        //goes to Enabled-Download-Excel and clicks it
        //verify that the file is downloaded
        downloadFilePage = new DownloadFilePage(driver);
        downloadFilePage.getDownloadFilePage();
        downloadFilePage.goEnabled();
        downloadFilePage.goDownloads();
        downloadFilePage.goExcel();
        downloadFilePage.fileDownloadCheck();
    }
    @AfterAll
    public static void tearDown() {
        driver.quit(); }
}

