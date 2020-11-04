package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@Getter
public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        try {
            size = new Select(driver.findElement(By.id("group_1")));
        } catch (Exception e) {

        }
    }

    @FindBy(xpath = "//i[@class='icon-plus']")
    private WebElement addQuantityBtn;

    @FindBy(id = "group_1")
    private WebElement sizeDropDown;
    Select size;

    @FindBy(name = "Submit")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class='button-container']/a[1]")
    private WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//td[@class='cart_description']//p[@class='product-name']")
    private WebElement productName;

    public void selectSize() {
        size.selectByValue("2");
    }

    public String getProductName() {
        System.out.println(productName.getText());
        return productName.getText();
    }

}
