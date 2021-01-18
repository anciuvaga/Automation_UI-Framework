package stepsDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import helpers.TestContext;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CheckoutPage;
import pages.MyAccountPage;
import utils.TakeScreens;

@Log4j
public class MyAccountPageSteps extends AbstractStepDefinitions{

    TestContext testContext;
    MyAccountPage myAccountPage;
    CheckoutPage checkoutPage;

    public MyAccountPageSteps(TestContext context) {
        testContext = context;
        myAccountPage = testContext.getPageObjectManager().getMyAccountPage();
        checkoutPage = testContext.getPageObjectManager().getCheckOutPage();
    }

    @Then("^new account is created for the user$")
    public void newAccountIsCreatedForTheUser() {
        Assert.assertEquals("Account Name is not: \"John Dow\"", "John Dow",
                myAccountPage.getAccountName());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("New account is created for the user");
}

    @Then("^user lands on 'MyAccount' page$")
    public void user_lands_on_MyAccount_page() {
        String myAccoutUrl = "http://automationpractice.com/index.php?controller=my-account";
        Assert.assertEquals("User has not landed on \"MyAccount page\"", myAccoutUrl,
                testContext.getWebDriverManager().getDriver().getCurrentUrl());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("User lands on 'MyAccount' page");

    }

    @When("^user selects a category$")
    public void userSelectCategory() {
        clickOnElement(myAccountPage.getCategory());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("User selects a category");

    }

    @When("^user goes to 'My Personal Information'$")
    public void goes_to_My_Personal_Information() {
        clickOnElement(myAccountPage.getInfoTab());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("User selects a category");
    }

    @When("^password is updated$")
    public void password_is_updated(DataTable dataTable) {
        myAccountPage.updatePassword(dataTable);
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("User selects a category");
    }

    @Then("^successful update info confirmation message is displayed$")
    public void updateInfoConfirmationMessage() {
       Assert.assertTrue("Successful confirmation message should be displayed",
               myAccountPage.successfulInformationUpdatetMessage());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("Successful update info confirmation message is displayed");
    }

    @Then("^order reference is present in order history$")
    public void orderReferenceIsPresentInOrderHistory() {
        String orderRef = testContext.getScenarioContext().getContext(Context.ORDER_REF);
        String reference = myAccountPage.getOrderReference();
        Assert.assertTrue("Order reference is not present in order history", reference.contains(orderRef));
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("Order reference is present in order history");

    }

    @When("^user clicks on order reference$")
    public void userClicksOnOrderReference() {
        WebElement orderRef = testContext.getWebDriverManager().getDriver()
                .findElement(By.xpath("//table//tbody//a[contains(text(),'"
                        + testContext.getScenarioContext().getContext(Context.ORDER_REF) +"')]"));
        orderRef.click();
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("User clicks on order reference");
    }

    @Then("^correct item name is present in order details table$")
    public void correctItemNameIsPresentInOrderDetailsTable() {
        String productName = testContext.getScenarioContext().getContext(Context.PRODUCT_NAME);
        testContext.waitForVisibilityOfElementLocated(By.xpath("//table[@class='table table-bordered']//tbody/tr[1]//td[2]//label"));
        Assert.assertTrue("Corect product name: \"Faded Short Sleeve T-shirts\" is not present in order details ",
                myAccountPage.getProductName().contains(productName));
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver(),
                testContext.getTakeScreens().getScreenPath());
        log.info("Correct item name is present in order details table");
    }
}
