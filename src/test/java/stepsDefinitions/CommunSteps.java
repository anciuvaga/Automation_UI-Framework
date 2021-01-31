package stepsDefinitions;

import cucumber.api.java.en.When;
import helpers.TestContext;
import lombok.extern.log4j.Log4j;
import actionsUtils.TakeScreens;

import static helpers.ElementSearchUtils.getWebElementName;

@Log4j
public class CommunSteps  {

    TestContext testContext;
    public CommunSteps(TestContext context) {
        testContext = context;
    }

    @When("^user clicks on '(.*)' generic button from '(.*)'$")
    public void userClicksOnButton(String element, String currentPage)  {
         getWebElementName(testContext, currentPage, element).click();
         TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("user clicks on " + element +  " generic button");
    }
}



