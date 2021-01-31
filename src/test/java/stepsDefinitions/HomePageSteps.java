package stepsDefinitions;

import helpers.TestContext;
import cucumber.api.java.en.Given;
import lombok.extern.log4j.Log4j;
import pages.HomePage;
import actionsUtils.TakeScreens;

@Log4j
public class HomePageSteps {

    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("^user is on HomePage$")
    public void userIsOnHomePage() {
        homePage.navigateToHomePage();
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("User is on HomePage");
    }
}
