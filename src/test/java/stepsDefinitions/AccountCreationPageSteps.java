package stepsDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import helpers.TestContext;
import lombok.extern.log4j.Log4j;
import pages.AccountCreationPage;
import actionsUtils.TakeScreens;

@Log4j
public class AccountCreationPageSteps {

    TestContext testContext;
    AccountCreationPage accountCreationPage;

   public AccountCreationPageSteps(TestContext context) {
        testContext = context;
        accountCreationPage = testContext.getPageObjectManager().getAccountCreationPage();

    }

    @When("^user fills in personal information details$")
    public void userFillsInPersonalInformationDetails(DataTable dataTable) {
        accountCreationPage.fillInPersonalDetails(dataTable);
        accountCreationPage.completeRegistration();
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("User fills in personal information details");
    }

}
