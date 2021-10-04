import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class DownloadFilePage {
    WebDriver driver;

    @FindBy(xpath = ".//a[contains(.,'Enabled')]")
    WebElement enabledButton;

    @FindBy(xpath = ".//a[contains(.,'Downloads')]")
    WebElement downloadsButton;

    @FindBy(xpath = ".//a[contains(.,'Excel')]")
    WebElement excelButton;

    public DownloadFilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void getDownloadFilePage() {
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu");
    }
    public void goEnabled() {
        Actions action = new Actions(driver);
        action.moveToElement(enabledButton).perform();
        enabledButton.click();
    }
    public void goDownloads() {
        Actions action = new Actions(driver);
        action.moveToElement(downloadsButton).perform();
        downloadsButton.click();
    }
    public void goExcel() {
        Actions action = new Actions(driver);
        action.moveToElement(excelButton).perform();
    }
    public void fileDownloadCheck() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        String tmpFolderPath = "./";
        String expectedFileName = "menu.xls";
        File file = new File(tmpFolderPath + expectedFileName);
        if (file.exists())
            file.delete();
        excelButton.click();
        wait.until((ExpectedCondition<Boolean>) webDriver -> file.exists());
    }
}
