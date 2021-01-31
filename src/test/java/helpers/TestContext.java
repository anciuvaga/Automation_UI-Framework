package helpers;

import managers.PageObjectManager;
import managers.WebDriverManager;
import actionsUtils.TakeScreens;
import actionsUtils.WaitUtils;

public class TestContext {

    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    private ScenarioContext scenarioContext;
    private TakeScreens takeScreens;
    private WaitUtils waitUtils;

    public TestContext() {
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
        scenarioContext = new ScenarioContext();
        takeScreens = new TakeScreens();
        waitUtils = new WaitUtils(webDriverManager.getDriver());
    }
    public TakeScreens getTakeScreens() {
               return takeScreens;
           }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public  PageObjectManager getPageObjectManager() { return pageObjectManager; }

    public ScenarioContext getScenarioContext() {
        return  scenarioContext;
    }

    public WaitUtils getWaitUtils() {
        return waitUtils;
    }

}

