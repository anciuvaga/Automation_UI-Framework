package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class CheckoutPage extends BasePageObject {

    @FindBy(linkText = "Blouse")
    private WebElement item;

    @FindBy(xpath = "//i[@class='icon-minus']")
    private WebElement removeBtn;

    @FindBy(xpath = "//div[@class='shopping_cart']//span[@class='ajax_cart_quantity']")
    private WebElement summaryProductsQuantity;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    private WebElement proceedToCheckoutCartBtn;

    @FindBy(name = "processAddress")
    private WebElement processAddressBtn;

    @FindBy(id = "cgv")
    private WebElement termsOfServiceCheckbox;

    @FindBy(name = "processCarrier")
    private WebElement processCarrierBtn;

    @FindBy(xpath = "//a[@class='cheque']")
    private WebElement checkMethod;

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    private WebElement confirmBtn;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement successMsgAlert;

    @FindBy(xpath = "//a[@class='button-exclusive btn btn-default']")
    private WebElement backToOrdersBtn;

    @FindBy(xpath = "//div[@class='box order-confirmation']")
    private WebElement orderReference;

    public CheckoutPage(WebDriver driver) {
       super(driver);
    }

    public String getItemName() {
        return item.getText();
    }

    public String getSummaryProductQuantityText() {

        return summaryProductsQuantity.getAttribute("innerHTML");
    }

    public boolean successfulAlertMessage() {
        return successMsgAlert.isDisplayed();
    }

    public String getOrderReference() {

        String orderRef = orderReference.getText();

        final String regex = "[A-Z]{9}";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(orderRef);
        String reference = "";

        while (matcher.find()) {
            reference = matcher.group(0);
        }
        return reference;
    }
}
