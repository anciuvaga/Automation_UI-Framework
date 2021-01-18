package stepsDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import helpers.TestContext;
import lombok.extern.log4j.Log4j;
import pages.AccountCreationPage;
import utils.TakeScreens;

@Log4j
public class AccountCreationPageSteps extends AbstractStepDefinitions {

    TestContext testContext;
    AccountCreationPage accountCreationPage;

   public AccountCreationPageSteps(TestContext context) {
        testContext = context;
        accountCreationPage = testContext.getPageObjectManager().getAccountCreationPage();

    }

    @When("^user fills in personal information details$")
    public void userFillsInPersonalInformationDetails(DataTable dataTable) {
        accountCreationPage.fillInPersonalDetails(dataTable);
        clickOnElement(accountCreationPage.getGenderRadioBtn());
        clickOnElement(accountCreationPage.getDayOfBirth());
        accountCreationPage.selectDay();
        clickOnElement(accountCreationPage.getMonthOfBirth());
        accountCreationPage.selectMonth();
        clickOnElement(accountCreationPage.getYearOfBirth());
        accountCreationPage.selectYear();
        clickOnElement(accountCreationPage.getOptin());
        clickOnElement(accountCreationPage.getNewsletter());
        clickOnElement(accountCreationPage.getState());
        accountCreationPage.selectState();
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("User fills in personal information details");
    }

}
