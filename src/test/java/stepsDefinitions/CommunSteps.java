package stepsDefinitions;

import cucumber.api.java.en.When;
import helpers.CommunUtils;
import helpers.TestContext;
import lombok.extern.log4j.Log4j;
import utils.TakeScreens;
import webElementsEnum.WebElements;

@Log4j
public class CommunSteps extends CommunUtils {

    TestContext testContext;
    public CommunSteps(TestContext context) {
        super(context);
        testContext = context;
    }

    @When("^user clicks on '(.*)' generic button$")
    public void userClicksOnButton(String element) {
       getElement(WebElements.getByBusinessName(element).selector()).click();
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("user clicks on " + element +  " generic button");
    }

}


