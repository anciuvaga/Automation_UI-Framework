package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class CategoryPage {
    WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//ul[@class='product_list row list']/li[2])//a[@class='button lnk_view btn btn-default']")
    private WebElement moreBtn;

    @FindBy(xpath = "//a[@class='button ajax_add_to_cart_button btn btn-default']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//i[@class='icon-th-list']")
    private WebElement listBtn;

}
