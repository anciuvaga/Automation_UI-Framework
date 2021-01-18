package stepsDefinitions;

import cucumber.api.java.en.When;
import helpers.TestContext;
import lombok.extern.log4j.Log4j;
import pages.CategoryPage;
import utils.TakeScreens;

@Log4j
public class CategoryPageSteps extends AbstractStepDefinitions{

    TestContext testContext;
    CategoryPage categoryPage;

    public CategoryPageSteps(TestContext context) {
        testContext = context;
        categoryPage = testContext.getPageObjectManager().getCategoryPage();
    }

    @When("^clicks on an item$")
    public void clicksOnAnItem() {
        clickOnElement(categoryPage.getListBtn());
        clickOnElement(categoryPage.getMoreBtn());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("User clicks on an item");
    }
}
