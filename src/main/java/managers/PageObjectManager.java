package managers;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageObjectManager {

    private WebDriver driver;
    private HomePage homePage;
    private AuthenticationPage authenticationPage;
    private AccountCreationPage accountCreationPage;
    private MyAccountPage myAccountPage;
    private CategoryPage categoryPage;
    private ProductPage productPage;
    private CheckoutPage checkOutPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public  HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public  AuthenticationPage getAuthenticationPage() {
        return (authenticationPage == null) ? authenticationPage = new AuthenticationPage(driver) : authenticationPage;
    }

    public  AccountCreationPage getAccountCreationPage() {
        return (accountCreationPage == null) ? accountCreationPage = new AccountCreationPage(driver) : accountCreationPage;
    }

    public  MyAccountPage getMyAccountPage() {
        return (myAccountPage == null) ? myAccountPage = new MyAccountPage(driver) : myAccountPage;
    }

    public CategoryPage getCategoryPage() {
        return (categoryPage == null) ? categoryPage = new CategoryPage(driver) : categoryPage;
    }

    public ProductPage getProductPage() {
        return (productPage == null) ? productPage = new ProductPage(driver) : productPage;
    }

    public CheckoutPage getCheckoutPage() {
        return (checkOutPage == null) ? checkOutPage = new CheckoutPage(driver) : checkOutPage;
    }
}
