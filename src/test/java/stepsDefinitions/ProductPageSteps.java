package stepsDefinitions;

import cucumber.api.java.en.When;
import enums.Context;
import helpers.TestContext;
import lombok.extern.log4j.Log4j;
import pages.CategoryPage;
import pages.CheckoutPage;
import pages.MyAccountPage;
import pages.ProductPage;
import utils.TakeScreens;

@Log4j
public class ProductPageSteps extends AbstractStepDefinitions {

    TestContext testContext;
    ProductPage productPage;
    MyAccountPage myAccountPage;
    CategoryPage categoryPage;
    CheckoutPage checkoutPage;

    public ProductPageSteps(TestContext context) {
        testContext = context;
        productPage = testContext.getPageObjectManager().getProductPage();
        myAccountPage = testContext.getPageObjectManager().getMyAccountPage();
        categoryPage = testContext.getPageObjectManager().getCategoryPage();
        checkoutPage = testContext.getPageObjectManager().getCheckOutPage();
    }

    @When("^user choose necessary attributes$")
    public void userChooseNecessaryAttributes() throws InterruptedException {
        clickOnElement(productPage.getAddQuantityBtn());
        clickOnElement(productPage.getSizeDropDown());
        productPage.selectSize();
        clickOnElement(productPage.getAddToCartBtn());
        testContext.waitForVisibility(productPage.getProceedToCheckoutBtn());
        clickOnElement(productPage.getProceedToCheckoutBtn());
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver());
        log.info("User choose necessary attributes");
    }

    @When("^an item is been added to the shoppingCart$")
    public void itemHasBeenAddedToShoppingCart() {
        clickOnElement(myAccountPage.getCategory());
        clickOnElement(categoryPage.getListBtn());
        clickOnElement(categoryPage.getAddToCartBtn());
        testContext.waitForVisibility(productPage.getProceedToCheckoutBtn());
        clickOnElement(productPage.getProceedToCheckoutBtn());

        String productName = productPage.getProductName();
        testContext.getScenarioContext().setContext(Context.PRODUCT_NAME, productName);
        TakeScreens.takeScreenshot(testContext.getWebDriverManager().getDriver());
        log.info("An item is been added to the shoppingCar");
    }
}
