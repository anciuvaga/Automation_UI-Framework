package actionsUtils;

import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

      WebDriverWait wait;
      WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigFileReader().getImplicitWait());
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibilityOfElementLocated(By xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

}
