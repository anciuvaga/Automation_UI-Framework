package helpers;


import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TakeScreens;


public class TestContext {

    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    private ScenarioContext scenarioContext;
    private WebDriverWait wait;
    private TakeScreens printStep;


    public TestContext() {
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
        scenarioContext = new ScenarioContext();
        printStep = new TakeScreens();
        wait = new WebDriverWait(webDriverManager.getDriver(), FileReaderManager.getInstance().getConfigFileReader().getImplicitWait());
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public  PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext() {
        return  scenarioContext;
    }

    public void waitForVisibility(WebElement element) {
      wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibilityOfElementLocated(By xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

}
