package pages;

import lombok.Getter;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage extends BasePageObject {

    WebDriver driver;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInBtn;

    @FindBy(xpath = "//a[@class='button ajax_add_to_cart_button btn btn-default']")
    private WebElement addToCartBtnHome;

    public HomePage(WebDriver driver) {
       super(driver);
       this.driver=driver;
    }

    public void navigateToHomePage() {
        getDriver().get(FileReaderManager.getInstance().getConfigFileReader().getWebsiteURL());
    }

}
