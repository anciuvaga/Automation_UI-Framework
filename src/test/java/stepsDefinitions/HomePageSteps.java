package stepsDefinitions;

import helpers.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j;
import pages.HomePage;
import utils.TakeScreens;

@Log4j
public class HomePageSteps extends AbstractStepDefinitions {

    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("^user is on HomePage$")
    public void userIsOnHomePage() {
        homePage.navigateToHomePage();
        clickOnElement(homePage.getSignInBtn());
       TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver());
        log.info("User is on HomePage");
    }

    @When("^user clicks on 'Sign in' button$")
    public void userClicksOnSignInButton() {
        clickOnElement(homePage.getSignInBtn());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver());
        log.info("User clicks on 'Sign in' button");
    }
}
