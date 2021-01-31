package stepsDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.TestContext;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import pages.AuthenticationPage;
import actionsUtils.TakeScreens;
import java.util.Map;
import static actionsUtils.Actions.clickOnElement;
import static actionsUtils.Actions.sendKeysToField;

@Log4j
public class AuthenticationPageSteps {

    TestContext testContext;
    AuthenticationPage authenticationPage;


    public AuthenticationPageSteps(TestContext context) {
        testContext = context;
        authenticationPage = testContext.getPageObjectManager().getAuthenticationPage();
    }

    @Then("^user is redirected on 'AutheticationPage'$")
    public void userIsRedirectedOnAutheticationPage() {
        Assert.assertEquals("Page header name is not: AUTHENTICATION",
                "AUTHENTICATION", authenticationPage.getHeader().toUpperCase());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("User is redirected on 'AutheticationPage'");

    }

    @When("^user enter '(.*)' address$")
    public void userEnterEmailAddress(String email) {
        authenticationPage.inputEmail(email);
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("User enter email address");
    }

    @When("^user enters his credentials$")
    public void userEntersHisCredentials(Map<String, String> credentials) {
        sendKeysToField(authenticationPage.getEmailAuthentication(), credentials.get("EmailAddress"));
        sendKeysToField(authenticationPage.getPasswordAuthentication(), credentials.get("Password"));
        clickOnElement(authenticationPage.getSubmitLogin());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("User enters his credentials");
    }

    @Then("^user is logged out successfully$")
    public void userIsLoggedOutSuccessfully() {
        String autheticationPageURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        Assert.assertEquals("User is not redirected to the Authentication Page",
                autheticationPageURL, testContext.getWebDriverManager().getDriver().getCurrentUrl());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("User is logged out successfully");
    }

    @Given("^user is logged in successfully$")
    public void user_is_logged_in_successfully(Map<String, String> credentials) {
        sendKeysToField(authenticationPage.getEmailAuthentication(), credentials.get("EmailAddress"));
        sendKeysToField(authenticationPage.getPasswordAuthentication(), credentials.get("Password"));
        clickOnElement(authenticationPage.getSubmitLogin());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("User is logged in successfully");
    }
}
