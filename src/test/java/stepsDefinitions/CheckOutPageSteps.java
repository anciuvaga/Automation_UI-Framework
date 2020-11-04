package stepsDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import helpers.TestContext;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pages.CheckoutPage;
import utils.TakeScreens;

@Log4j
public class CheckOutPageSteps extends AbstractStepDefinitions{

    TestContext testContext;
    CheckoutPage checkoutPage;

    public CheckOutPageSteps(TestContext context) {
        testContext = context;
        checkoutPage = testContext.getPageObjectManager().getCheckOutPage();
    }

    @Then("^items are added to cart$")
    public void itemsAreAddedToCart() {
        Assert.assertEquals("Item name is  not: \"Blouse\"",
                "Blouse", checkoutPage.getItemName());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver());
        log.info("User adds items to cart");
    }

    @When("^an item is removed from shoppingCart$")
    public void anItemIsRemovedFromShoppingCart() {
        clickOnElement(checkoutPage.getRemoveBtn());
      TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver());
        log.info("User removes an  item from the cart");
    }

    @Then("^correct items amount is present in the shoppingCart$")
    public void corectItemsAmountIsPresentInTheShoppingCart() throws InterruptedException {
        Thread.sleep(2000);
        Actions act = new Actions(testContext.getWebDriverManager().getDriver());
        testContext.waitForVisibilityOfElementLocated(By.xpath("//div[@class='shopping_cart']//span[@class='ajax_cart_quantity']"));
        act.moveToElement(checkoutPage.getSummaryProductsQuantity()).perform();
        Assert.assertEquals("Item's amount is not: \"1\"", "1",
                checkoutPage.getSummaryProductQuantityText());
       TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver());
        log.info("Correct items amount is present in the shoppingCart");
    }

    @When("^user process checkout information$")
    public void userClickToProceedToCheckout() {
        clickOnElement(checkoutPage.getProceedToCheckoutCartBtn());
        clickOnElement(checkoutPage.getProcessAddressBtn());
        clickOnElement(checkoutPage.getTermsOfServiceCheckbox());
        clickOnElement(checkoutPage.getProcessCarrierBtn());
        clickOnElement(checkoutPage.getCheckMethod());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver());
        log.info("User processes checkout information");
    }

    @When("^'I confirm my order' btn is pressed$")
    public void IconfirmMyOrderBtnIsPressed() {
        clickOnElement(checkoutPage.getConfirmBtn());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver());
        log.info("'I confirm my order' btn is pressed");
    }

    @Then("^successful confirmation message is displayed$")
    public void successfulConfirmationMessageIsDisplayed() {
        Assert.assertTrue("Successful confirmation message is not displayed",checkoutPage.successfulAlertMessage());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver());
        log.info("Successful confirmation message is displayed");
    }

    @When("^user goes back to orders$")
    public void userGoesBackToOrders() {
        String orderRef = checkoutPage.getOrderReference();
        testContext.getScenarioContext().setContext(Context.ORDER_REF, orderRef);
        clickOnElement(checkoutPage.getBackToOrdersBtn());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver());
        log.info("User goes back to orders");
    }
}
