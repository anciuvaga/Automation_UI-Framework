package pages;

import dataProvider.ConfigFileReader;
import lombok.Getter;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInBtn;

    @FindBy(xpath = "//a[@class='button ajax_add_to_cart_button btn btn-default']")
    private WebElement addToCartBtnHome;

    public void navigateToHomePage() {
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getWebsiteURL());
    }

}
